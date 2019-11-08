package Utils;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtils {
	private static Logger logger = LoggerFactory
			.getLogger(CommonUtils.class);

	/**
	 * 修复文件夹
	 * 
	 * @param dir
	 */
	public synchronized static void resetDir(File dir) {
		// 如果没有文件夹,创建文件夹
		if (!dir.exists()) {
			dir.mkdirs();
			logger.info("WARN : create dir "+dir.getAbsolutePath());
		}
		// 如果文件夹变成了0字节同名文件,先删后建
		if (dir.isFile()) {
			dir.delete();
			dir.mkdirs();
			logger.info("WARN : reset dir "+dir.getAbsolutePath());
		}
	}

}
