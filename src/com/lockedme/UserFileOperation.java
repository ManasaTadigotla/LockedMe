package com.lockedme;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;


public class UserFileOperation 
{
	
 	public int makeChoice()
	{
		int userChoice=0;
		Scanner userInput1=new Scanner(System.in);
		
		do
		{
			System.out.println("Please select the operation you want to perform");
			System.out.println("1.Add File");
			System.out.println("2.Delete File");
			System.out.println("3.Display All Files");
			System.out.println("4.Search File");
			System.out.println("5.Close");
		
			
			if(userInput1.hasNextInt())
			{
				userChoice=userInput1.nextInt();	
				//return userChoice;
			}
			else
			{
				System.out.println("Please Give Proper input.(Number 1-5) ");
				userInput1.next();
				System.out.println("enter ur choice");
				if(userInput1.hasNextInt())
				{
					userChoice=userInput1.nextInt();
					if(userChoice==0)
						System.out.println("enter 1-5");
					continue;
				}
				//userInput1.reset();
				//userInput1.nextLine();
												
			}
			
		
		}while(userChoice==0);	
		return userChoice;
	}

 	public Boolean addOperation(String filePath,String fileType)
 	{
 		String fileName;
 		Boolean isAdded=false;
 		Scanner userInput =new Scanner(System.in);
 		FileUtil fileOperation=new FileUtil();
 		System.out.println("please enter file Name");
		
		
		fileName=userInput.next();
		
		if(filePath!=null)
		{
			//System.out.println(filePath);
			try
			{
			isAdded=fileOperation.addFile(fileName,fileType,filePath);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
	
		}
		return isAdded;
 	}
 	
	public static void main(String[] args)  
	{
		int choice;
		String fileName;
		String filePath =null;
		String fileType="txt";
		boolean isAdded=false;
		Scanner userInput=null;
		UserFileOperation userOperation=new UserFileOperation();
		choice=userOperation.makeChoice();
		
		while(choice>0 && choice<6)
		{
			filePath=System.getProperty("user.dir");
			filePath=filePath+"\\"+"resources";
			FileUtil fileOperation=new FileUtil();
			userInput=new Scanner(System.in);
			//System.out.println(filePath);
			switch (choice) 
			{
				case 1: 
				{
					//System.out.println("please enter file Name");
					while(!isAdded){
						
						//fileName=userInput.next();

					isAdded=userOperation.addOperation(filePath, fileType);
					
					//isAdded=userOperation.addOperation(filePath, fileType);
							if(isAdded)
								System.out.println("File added successfully..");
							else
							{
								System.err.println("File alredy exists with the same name.please try again..");
								//System.out.println("please enter file Name");								
								//fileName=userInput.next();	
								//isAdded=userOperation.addOperation(filePath, fileType);
								//return;
							}
					}
						
						
						break;
				}
				case 2:
				{
					Boolean isDeleted;
					System.out.println("eneter file name.File name is case sensitive");
					//userInput=new Scanner(System.in);
					fileName=userInput.next();
					isDeleted=fileOperation.deleteFile(fileName,filePath);
					if(isDeleted)
						{
						System.out.println("File deleted successfully");
						}
					else
						System.out.println("file is not found ");
					
						
					break;
				}
				case 3:
				{
					List<MyFile> allFiles=new ArrayList<>();
					
			        allFiles=fileOperation.getFiles(filePath.toString());
			        for(MyFile f:allFiles)
					System.out.println(f.getId()+"\t"+f.getFileName());
				    break;
				}
				case 4:
				{	
					boolean isFound=false;
					System.out.println("enter file name");
					//userInput=new Scanner(System.in);
					fileName=userInput.next();
					isFound=fileOperation.searchFile(fileName,filePath);
					if(isFound)
						System.err.println("file exists");
					else
						System.out.println("file doesnt exit");
					break;
				}
				case 5:
				{
					System.out.println("Thank you...Bye");
					//Runtime.getRuntime().exit(0);
					System.exit(0);
					break;
						
				}			
			
				default:
						System.out.println("This choice is not available");
						
			}			
			
			try
			{	
				int optionContinue=0;
				System.out.println("Do you want to perform another action?"+"\n "+"press 1 to continue");
				userInput=new Scanner(System.in);
						if(userInput.hasNextInt())
				{
					
				
				optionContinue=userInput.nextInt();
				}
					if(optionContinue==1)
					{
					choice=userOperation.makeChoice();
					}
					else
					{
						System.out.println("thank you for choosing.. ");					
						//Runtime.getRuntime().gc();
						System.exit(0);
						
					}
				
				
			}
			catch(InputMismatchException ex)
			{
				System.out.println("This is not proper input...");
			}
			//userInput.close();
	
		
	
		}
		
	}
	
		

	

}
