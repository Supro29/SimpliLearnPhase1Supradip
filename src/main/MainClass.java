package main;

import java.io.IOException;
import java.util.Scanner;

import Business.BusinessLogic;
import custom_exception.BusinessCheckedException;

public class MainClass {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

        
    	Scanner sc = new Scanner(System.in);
		String ch = null;
		String ch2 = null;
		BusinessLogic bl=new BusinessLogic();
		System.out.println("                                            Welcome");
		System.out.println("                            To Lockers Pvt File Viewer and Manager ");
		System.out.println("                                           Developed by ");
		System.out.println("                     Supradip Banerjee ,Email Address -supro.jee@gmail.com");
		System.out.println();
		System.out.println();
		do {
			System.out.println("Please select one of the following options");
			System.out.println();
			System.out.println("Press:");
			System.out.println();
			System.out.println("     1    View all the files in the folder in ascending order");
			System.out.println();
			System.out.println("     2    Get an interface containing further options");
			System.out.println();
			System.out.println("     3    EXIT");
			System.out.println();
				ch = sc.nextLine();
			switch (ch) {
			case "1"://System.out.println("\nRetrieving the files\n");
					bl.retrieveFiles();
					System.out.println();
					break;
			case "2":
				do {
					System.out.println();
					System.out.println("What more operation do you want to perform from below");
					System.out.println();
					System.out.println("Details of the user interface");
					System.out.println("--------------------------------------------");
					System.out.println();
					System.out.println("1)Add a file to the application");
					System.out.println("2)Delete a  from the application");
					System.out.println("3)Search a  file from the application");
					System.out.println("4)Go back to main menu\n");
					System.out.println("Please enter your appropriate choice(1-4)");
					
						ch2 = sc.nextLine();
						
					switch(ch2) {
					case "1":
						System.out.println("Please mention the file name to be created");
						String addfile = sc.nextLine();
						try {
							bl.addFile(addfile);
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
						continue;
					case "2":
						System.out.println("Please mention the file name to be deleted");
						String deletefile = sc.nextLine();
						try {
							bl.deleteFile(deletefile);
						} catch (BusinessCheckedException e) {
							System.out.println(e.getMessage());;
						}
						continue;
					case "3":
						System.out.println("Please mention the file name to be searched");
						String searchfile = sc.nextLine();
						 bl.searchFile(searchfile);
						 continue;
						
					case "4":System.out.println("Going back to main menu\n");
							break;
							
					default:System.out.println("Invalid Choice... Choice should and must be between 1-4 only");
							continue;
					}
					break;
				}while(ch2 != "4");
				break;
			case "3":
				System.out.println("\nThank you for using our app.");
				System.exit(0);
			
			default:System.out.println("Invalid Choice... Choice should and must be between 1-3 only");
				System.out.println();
			break;
			}
		} while (ch != "3");

	}
	
	
}
