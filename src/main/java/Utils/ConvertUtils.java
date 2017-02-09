package Utils;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ConvertUtils {

	/**
	 * 将文件转换成mp3
	 */
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
	
	/**
	 * 将多个文件合成一个文件
	 */
	public static boolean combine(String outFile, Object[] inFiles)
			throws Exception {
		File[] files = new File[inFiles.length];
		for (int i = 0; i < files.length; i++) {
			files[i] = new File((String) inFiles[i]);
		}
		FileInputStream fis = null;
		FileOutputStream fos = new FileOutputStream(outFile, true); 
		for (int i = 0; i < files.length; i++) {
			fis = new FileInputStream(files[i]);
			int len = 0;
			for (byte[] buf = new byte[1024 * 1024]; (len = fis.read(buf)) != -1;) {
				fos.write(buf, 0, len);
			}
			fis.close();
		}
		fos.close();
		return true;
	}

}