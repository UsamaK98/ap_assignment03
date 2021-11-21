package ap_assignment03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public abstract class FileProc extends Thread {
	
	private String myName;
	
	FileProc(String name){
		this.myName = name;
	}
	
	public String getFileName() {
		return myName;
	}

	public void setFileName(String fileName) {
		this.myName = fileName;
	}
	
	public abstract void run();
	
	
}
