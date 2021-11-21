package ap_assignment03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class FileProcVocab extends FileProc {
	
	private File myFile;
	private BinarySearchTree myBST;
	
	FileProcVocab(String name) {
		super(name);
		myFile = new File (name);
		myBST = new BinarySearchTree();
	}

	@Override
	synchronized public void run() {
		// opening the streams
		try {
			myFile = new File ("E:\\AP Workspace\\ap_assignment03\\src\\ap_assignment03\\words1.txt");
			FileReader fr = new FileReader (myFile);
			Scanner myReader = new Scanner (fr);	
			while (myReader.hasNext()) {		
				//System.out.println(myReader.next());
				myBST.addNode(myReader.next());
			}
			myReader.close();
		} catch (IOException e) {
			System.out.println("An error occurred!");
			e.printStackTrace();
		} 
	} 
		
	public void displayBST() {
		myBST.traverseInOrder();
	}
	
	public void compareWithBST (Vector<String> c, word myWords) {
		for (int i=0; i< 315; ++i)
			if (myBST.SearchPostOrder(c.get(i))) {
				myWords.addWord(c.get(i));
			}	
	}
	
}
