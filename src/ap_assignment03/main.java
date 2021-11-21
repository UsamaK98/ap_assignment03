package ap_assignment03;

import java.util.Scanner;
import java.util.StringTokenizer;

public class main {
	
	
	public final static void clearConsole()  {  
		try  {  
			final String os = System.getProperty("os.name");  
			if (os.contains("Windows")){  
				Runtime.getRuntime().exec("cls");  
			}  else  {  
				Runtime.getRuntime().exec("clear");  
			}  
		}  catch (final Exception e) {  
			e.printStackTrace();  
		}
	} 
	
	public static void loginMenu() {
		 
		System.out.println("\t\t********** LOGIN MENU *********\n");
		System.out.println("Username: ");
		Scanner uname= new Scanner(System.in);
		String u = uname.nextLine();
		
		System.out.println("Password: ");
		Scanner pword= new Scanner(System.in);
		String p = pword.nextLine();
		
	}
	
	public static void MainMenu() {
		
		System.out.println("\t\t\t*************** MAIN MENU **************");
		System.out.println("\t1.Display BST built from Vocabulary file");
		System.out.println("\t2.Display Vectors built from input files");
		System.out.println("\t3.View matched words and frequency");
		System.out.println("\t4.Search a query");
		System.out.println("\t5.Exit");
	}
	
	public static void main (String[] args) throws InterruptedException {
		
		int j=args.length;
		System.out.println("Number of files input: "+ j);
		int i=0;
		while (i!=j) {
			System.out.println(args[0]);
			i++;
		}
		
		FileProcVocab vocabFile = new FileProcVocab (args[0]); 
		FileProcInput InputFile = new FileProcInput (args[1]);
		Thread t1 = vocabFile;
		Thread t2 = InputFile;
		word allWords = new word();
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		vocabFile.compareWithBST(InputFile.getVec(), allWords);
		allWords.displayWords();
		
		int option = 0;
		while (option!=5) {
			MainMenu();
			Scanner opt = new Scanner(System.in);
			option = opt.nextInt();
			
			switch (option) {
				case 1: vocabFile.displayBST();
						break;
				case 2: InputFile.displayVectors();
						break;
				case 3: //TODO: put matched words func here
				case 4: //TODO: put seearch query func here
			}
		}
	}
}	