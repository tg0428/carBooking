package org.wg.carbooking.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class pictureCatch {
	
	private static List<String> filePathsList = new ArrayList<String>();

	public static List<String> getPictures(String url) throws IOException{
		
		File dir = new File(url);
		if (dir.exists()){
			File [] files = dir.listFiles();
			for (File file : files) {
				if (file.isFile()){
					filePathsList.add(file.getPath());
				} else {
					getPictures(file.getPath());
				}
			}
		} 
		return filePathsList;
	}
	
	public static List<String> getServerPicturePaths(String url) throws IOException{
		filePathsList.clear();
		return getPictures(url);
	}
}
