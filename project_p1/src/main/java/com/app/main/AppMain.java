package com.app.main;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import com.app.bo.AppBO;
import com.app.bo.impl.AppBOImpl;
public class AppMain {

	public static void main(String[] args) {
		AppBO appBO = new AppBOImpl();
		Scanner scanner=new Scanner(System.in);
		boolean success=false;
		System.out.println("***Welcome to our Application***");
		System.out.println("***The developer of the application is Ms. Vennis Shah***");
		System.out.println("Please enter the directory that you will be working with");
		String directory=scanner.nextLine();
		while(!new File(directory).exists()) 
		{
		System.out.println("This directory path doesnot exist please enter valid directory path");
		directory=scanner.nextLine();
		}
		
		int ch = 0;
		do {
			System.out.println("Application Menu");
			System.out.println("----------------");
			System.out.println("1)To list all the files in the specified directory");
			System.out.println("2)For file operations such as to add or delete a file or search for a file");
			System.out.println("3)Close the application and Exit ");
			System.out.println("Enter your choice");
			ch = Integer.parseInt(scanner.nextLine());

			switch (ch) {
			case 1:
				File d = new File(directory);
				System.out.println("Retrieving the file names for the given directory path");
					File filesList[] = d.listFiles();
					for(File file : filesList) {
				         System.out.println("File name: "+file.getName());
				         System.out.println("File path: "+file.getAbsolutePath());
				         System.out.println("Size :"+file.getTotalSpace());
				         System.out.println(" ");
					}	
				break;
			case 2:
				int c=0;
				System.out.println("Press 1 to add a file to the directory ");
				System.out.println("Press 2 to delete a file from the directory");
				System.out.println("Press 3 to search for a file in the directory");
				c = Integer.parseInt(scanner.nextLine());
				switch(c) {
				case 1:
					System.out.println("This application can add only files with '.txt' extension");
					System.out.println("Enter the file name to be added");
					String filename = scanner.nextLine();
					while(!filename.matches("^[ a-zA-z0-9]{1,}\\.txt$")) {
						System.out.println("Please enter filename with proper extension ie .txt");
						filename=scanner.nextLine();
						
					}
					
					try {
						File f=appBO.addFile(directory,filename);
						if(!(f==null)) {
						success=f.createNewFile();
					} }
					catch(IOException e) {
						e.getStackTrace();
					}
					if (success) { System.out.printf("Successfully add new file to the directory:"+filename); } 
					else { System.out.printf("Failed to add new file"); } 
					System.out.println('\n');
					break;
				case 2:
					System.out.println("Enter the file name to be deleted ");
					String filenam = scanner.nextLine();
//					final String fileNam = filenam + ".txt";
					try {
						File fdel=appBO.delFile(directory,filenam);
						success=fdel.delete();
						if (success) { System.out.printf("Successfully deleted "+filenam+" file"); } 
						else { System.out.printf("Failed to delete file"); } 
						System.out.println('\n');

					} catch (Exception e) {
						e.printStackTrace();
					} 
					
				break;
				case 3:
					
					System.out.println("Enter the file name to be searched for");
					String filena = scanner.nextLine();
					final String fileNa = filena;
					appBO.searchFile(directory,fileNa);
					
				break;
				default:
					System.out.println("Please enter a valid chioce");
				}
				
				break;
			case 3:
				System.out.println("Thanks for using our Application!!Do use it again!!");

				break;
			default:
				System.out.println("Invalid option Please Try again");
				break;
			}
		} while (ch != 3);
		scanner.close();
}}
