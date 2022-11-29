package com.lockedme;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	static int count=0;
	List<MyFile> files=new ArrayList<>();
	public FileUtil()
	{
		
	/*	File f=new File("C://Manasa");
		String[] fs=f.list();
		for(MyFile file:files)
		{
			count++;
			files.add(count,file);
		}
	*/
	}

	/*public FileUtil(List<MyFile> files,String path)
	{
		File f=new File(path);
		String[] fs=f.list();
		for(String file:fs)
		{
			count++;
		files.add(new MyFile(count,file));
		}	
		
	}
	*/
	public List<MyFile> getFiles(String filePath)
	{
		
		List<MyFile> files=new ArrayList<>();
		File f=new File(filePath);
		String[] fs=f.list();
		//System.out.println(filePath+"\\"+"resources");
		for(String file:fs)
		{
			count++;
		files.add(new MyFile(count,file));
		}	
		return files;
	}
	public boolean addFile(String fileName,String fileType,String filePath) throws IOException
	{
		//String filePath=System.getProperty("user.dir");
		//filePath=filePath+"\\";
		File f=new File(filePath+"\\"+fileName+"."+fileType);
		
			if(f.createNewFile())
			{
				return true;
			    //System.out.println(filePath);
				//System.out.println("Congratulations new file is created with "+fileName+".txt");
			}
			else
				return false;
				//System.out.println("File already exists with the same name");
				
		
	}
	public boolean deleteFile(String fileName,String filePath)
	{
		boolean isDeleted=false;
		files=getFiles(filePath);
		for(MyFile file:files)
		{
			//file.getFileName().toLowerCase();
			if(file.getFileName().startsWith(fileName))
			{
				try
				{
			    	File f=new File("C://Manasa//FileProject//"+file.getFileName());
				
				    isDeleted=f.delete();
				}
				catch (NullPointerException ex)
				{
					System.out.println("file path is empty");
				}	
				catch(SecurityException ex)
				{
					System.out.println("File is not accesible to delete");
				}
				
			}
		}
		return isDeleted;
		
	}
	public boolean searchFile(String fileName,String filePath)

	{
		boolean isIdentified=false;
		files=getFiles(filePath);
		for(MyFile file:files)
		{
			if(file.getFileName().startsWith(fileName))
			{
				isIdentified=true;
				break;
			}
		}
		return isIdentified;
	}
	
	
	
	
}
