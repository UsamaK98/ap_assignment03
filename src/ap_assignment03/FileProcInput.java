package ap_assignment03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class FileProcInput extends FileProc {
	
	private File myFile;
	private Vector<String> myVec;
	
	FileProcInput(String name) {
		super(name);
		myFile = new File (name);
		myVec = new Vector<String>();
	}
	
	public Vector<String> getVec(){
		return myVec;
	}

	@Override
	synchronized public void run() {
		// opening the streams
		try {
			myFile = new File ("E:\\AP Workspace\\ap_assignment03\\src\\ap_assignment03\\input1.txt");
			FileReader fr = new FileReader (myFile);
			Scanner myReader = new Scanner (fr);	
			while (myReader.hasNext()) {		
				//System.out.println(myReader.next());
				myVec.add(myReader.next());
			}
			myReader.close();
		} catch (IOException e) {
			System.out.println("An error occurred!");
			e.printStackTrace();
		} 
	} 
	
	public void displayVectors() {
		System.out.print(myVec.capacity());
		for (int i = 0; i < 315 ;i++)
			if (myVec.get(i)!=null)
				System.out.println(myVec.get(i));
	}
}