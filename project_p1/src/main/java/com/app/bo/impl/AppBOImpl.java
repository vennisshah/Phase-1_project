package com.app.bo.impl;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import com.app.bo.AppBO;
public class AppBOImpl implements AppBO{

	@Override
	public File addFile(String dir, String filename) {
		File files=new File(dir,filename);
		if (files.exists()) { System.out.println("File Already Exists");} 
		else { System.out.println("No such file exists, adding now"); 
		}
		return files;
		}
		
	@Override
	public File delFile(String dir, String filename){
		File files=new File(dir,filename);
		if(!files.exists()) {
			
			System.out.println("File not found...cannot delete it");;
		}
		return files;
	}		



	@Override
	public File searchFile(String dir, String filename) {
		File files=new File(dir);
		String[] contents=files.list();
		List<String> fileList = Arrays.asList(contents);
		if(fileList.contains(filename)) {
			System.out.println("File found");
			System.out.println("The file is found and can be seen in the below list of files in the directory");
			System.out.println(fileList);
		}
	else
			{
				System.out.println("File not found");
			}	
		
		return files;
	}

	
		
	}

	

	


