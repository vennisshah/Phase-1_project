package com.app.bo;
import java.io.File;
public interface AppBO {
	public File addFile(String dir,String filename);
	public File delFile(String dir,String filename) ;
	public File searchFile(String dir,String filename);
}
