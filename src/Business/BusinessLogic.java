package Business;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import custom_exception.BusinessCheckedException;

public class BusinessLogic {

	public void retrieveFiles() {
		
		 String[] pathnames;

		 	String path = System.getProperty("user.dir");
	        File f = new File(path+ "\\Root\\");
	        System.out.println("\nRetrieving the files\n");
	        if(f.isDirectory()) {
	        	if(f.list().length>0) {
		        pathnames = f.list();
		        Arrays.sort(pathnames);
		        for (String pathname : pathnames) {
		            System.out.println(pathname);
		         }
		        }
			  else { 
				  System.out.println("\n*****No files found in the Root Directory! Kindly add the files*****"); 
			  }
			 
	        }
	        else {
	        	
	        	f.mkdir();
	        	
	        }
	}
	
	public  void addFile(String name) throws IOException {
		
		String file = name;
		file= file + ".txt";
		String path = System.getProperty("user.dir");
		File f = new File(path+ "\\Root\\" + file);
		
			
			if (!f.exists()) {
			
			f.createNewFile();
			System.out.println("File is created with the name " + file);
			}
			else {
				System.out.println("*****File already exists! Kindly input different file name*****");
			}
	
	}
	
	public void deleteFile(String name) throws BusinessCheckedException {
		
		String file = name;
		file= file + ".txt";
		String path = System.getProperty("user.dir");
		File f = new File(path+ "\\Root\\"+file);
		if(!f.exists()) {
			throw new BusinessCheckedException("File Not Found");
		}
		else {
		if(file.equals(f.getName())) {
			f.delete();
			System.out.println("Successfully deleted file = " + file);
		}else {
			System.out.println("File does not match the name specified");
		}
		}
	}
	
	public void searchFile(String name) {
		
		String file = name;
		int i;
		file= file + ".txt";
		String path = System.getProperty("user.dir");
		File f = new File(path+ "\\Root\\");
		
		String[] list = f.list();
		
		if(list==null) {
	         System.out.println("Either dir does not exist or it's an empty directory"); 
	      } else { 
	          for ( i=0;i<list.length;i++)
	          {
	              if (file.equals(list[i]))
	              {
	                  System.out.println("The specified file with the name "+ name + " exists " );
	                  break;
	              }
	             
	          }
	          if(i==list.length) {
	        	  
	        	  System.out.println("The file is not present");
	          }
	          
	}
	
	}
}
	

