package Utils;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;

import java.io.File;

public class ConvertUtils {

	public static void changeToMp3(String sourcePath, String targetPath) {
		File source = new File(sourcePath);
		File target = new File(targetPath);
		AudioAttributes audio = new AudioAttributes();
		Encoder encoder = new Encoder();

		audio.setCodec("libmp3lame");
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp3");
		attrs.setAudioAttributes(audio);
		try {
			encoder.encode(source, target, attrs);
		} catch (Exception e) {
			// 有错误,但能转换成功
		}
	}

	/**
	 * 文件名去括号 "{...}01"->"...01"
	 */
	public static String convertFilename(String fileName) {
		String fn = fileName.split("\\.")[0];
		String filePrefix = fn.substring(0, fn.length() - 2);
		String fileSuffix = fn.substring(fn.length() - 2);
		if (filePrefix.startsWith("{") && filePrefix.endsWith("}")) {
			filePrefix = filePrefix.substring(1, filePrefix.length() - 1);
		}
		return filePrefix + fileSuffix;
	}

}