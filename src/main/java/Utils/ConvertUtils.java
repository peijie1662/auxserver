package Utils;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

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
	public static boolean combineMp3(String outFile, Object[] inFiles)
			throws Exception {
		File[] files = new File[inFiles.length];
		for (int i = 0; i < files.length; i++) {
			files[i] = new File((String) inFiles[i]);
		}
		FileOutputStream fos = new FileOutputStream(outFile, true);
		for (int i = 0; i < files.length; i++) {
			byte[] buf = new byte[1024 * 1024];
			int length = (int) files[i].length();
			int tagLen = getMp3TagLen(files[i]);
			int realLen = 0;
			RandomAccessFile rf = new RandomAccessFile(files[i], "r");
			if (i == 0) {
				realLen = rf.read(buf, 0, length - 16*56);
			} else {
				rf.seek(tagLen);
				realLen = rf.read(buf, 0, length - tagLen - 16*56);
			}
			rf.close();
			fos.write(buf,0,realLen);
		}
		fos.close();
		return true;
	}
	
	/**
	 * 将多个文件合成一个文件
	 */
	public static boolean combineAmr(String outFile, Object[] inFiles)
			throws Exception {
		FileOutputStream fos = new FileOutputStream(outFile, true);
		for (int i = 0; i < inFiles.length; i++) {
			byte[] buf = new byte[1024 * 1024];
			File file = new File((String) inFiles[i]);
			int length = (int) file.length();
			int tagLen = 6;
			int realLen = 0;
			RandomAccessFile rf = new RandomAccessFile(file, "r");
			if (i == 0) {
				realLen = rf.read(buf, 0, length);
			} else {
				rf.seek(tagLen);
				realLen = rf.read(buf, 0, length - tagLen);
			}
			rf.close();
			fos.write(buf,0,realLen);
		}
		fos.close();
		return true;
	}

	public static int toSize(byte[] bytes) {
		int result = bytes[0] << 21 | bytes[1] << 14 | bytes[2] << 7 | bytes[3];
		return result;
	}

	/**
	 * mp3头长度
	 */
	public static int getMp3TagLen(File file) {
		try {
			byte[] size = new byte[4];
			RandomAccessFile rf = new RandomAccessFile(file, "r");
			rf.seek(6);
			rf.read(size);
			rf.close();
			return toSize(size);
		} catch (Exception e) {
			return 0;
		}
	}

}