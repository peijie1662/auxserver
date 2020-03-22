package pj.com.cn.web.scheduled;

import java.io.File;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import Utils.CommonUtils;
import Utils.ConvertUtils;
import pj.com.cn.web.dao.ClearDao;

/**
 * 定时任务
 */
@Component
public class HousekeeperScheduled {

	private static Logger logger = LoggerFactory.getLogger(HousekeeperScheduled.class);

	@Value("${amr_path}")
	private String amr_path;

	@Value("${mp3_path}")
	private String mp3_path;

	@Autowired
	private ClearDao clearDao;

	/**
	 * 每1分钟遍历文件 
	 */
	@Scheduled(cron = "*/60 * * * * ?")
	public void pollDir() {
		// 0.检查文件夹
		File amrPath = new File(amr_path);
		if (!amrPath.exists() || amrPath.isFile()) {
			CommonUtils.resetDir(amrPath);
		}
		File mp3Path = new File(mp3_path);
		if (!mp3Path.exists() || mp3Path.isFile()) {
			CommonUtils.resetDir(mp3Path);
		}
		// 1.遍历所有文件
		Map<String, AudioFile> audios = new HashMap<String, AudioFile>();
		File file = new File(amr_path);
		File[] fs = file.listFiles();
		for (File f : fs) {
			String fn = f.getName().split("\\.")[0];
			String prefix = fn.substring(1, fn.length() - 3);
			if (audios.containsKey(prefix)) {
				audios.get(prefix).getFilePaths().add(f.getAbsolutePath());
			} else {
				AudioFile af = new AudioFile();
				af.setPrefix(prefix);
				af.getFilePaths().add(f.getAbsolutePath());
				audios.put(prefix, af);
			}
		}
		// 2.合成符合条件文件并删除原文件
		for (AudioFile af : audios.values()) {
			boolean isTimeout = true;
			Collections.sort(af.getFilePaths());
			Date curDate = new Date();
			// 该序列所有文件创建时间都已超过30分钟,即可转换
			for (String fn : af.getFilePaths()) {
				File f = new File(fn);
				if ((curDate.getTime() - f.lastModified()) / 1000 <= 30 * 60) {
					isTimeout = false;
				}
			}
			if (isTimeout) {
				try {
					if (ConvertUtils.combineAmr(mp3_path + af.getPrefix() + ".amr", af.getFilePaths().toArray())) {
						for (String fn : af.getFilePaths()) {
							File f = new File(fn);
							if (f.exists() && f.isFile()) {
								f.delete();
							}
						}
					}
				} catch (Exception e) {
					logger.info("composing file:" + af.getPrefix() + " error");
				}
			}
			// 将此文件转换为mp3
			ConvertUtils.changeToMp3(mp3_path + af.getPrefix() + ".amr", mp3_path + af.getPrefix() + ".mp3");
		}
	}

	/**
	 * 每天中午12时清理超过1天数据
	 */
	@Scheduled(cron = "0 0 12 * * ?")
	public void weeklyClear() {
		Date curDate = new Date();
		// 1.删除超过1天语音文件
		File mp3Path = new File(mp3_path);
		if (!mp3Path.exists() || mp3Path.isFile()) {
			CommonUtils.resetDir(mp3Path);
		}
		File[] fs = mp3Path.listFiles();
		for (File f : fs) {
			if ((curDate.getTime() - f.lastModified()) / 1000 >= 1 * 24 * 60 * 60) {
				f.delete();
			}
		}
		// 2.删除DB中大于一周数据
		clearDao.clr();
	}

}
