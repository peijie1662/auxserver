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
	        	//有错误,但能转换成功
	        }
	    } 
	   
	  /**
	   * 文件名去括号
	   */
	  public static String convertFilename(String fileName){
		  String name = fileName.split("\\.")[0];
			if (name.startsWith("{") && name.endsWith("}")){
				name = name.substring(1,name.length()-1);
			}
		  return name;
	  }
	  
}