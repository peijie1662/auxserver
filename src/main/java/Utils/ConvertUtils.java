package Utils;



import java.io.File;

public class ConvertUtils {
	
	  public static void changeToMp3(String sourcePath, String targetPath) {  
	        
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
