package onlineCoaching.multithreadingAndConcurrency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

							//A Single Threaded Application	
										/*
  //A Simple Adder Class
public class SimpleAdderClassAndThreadClass {
	private String inFile,outFile;
	public SimpleAdderClassAndThreadClass(String inFile,String outFile) {
		this.inFile=inFile;
		this.outFile=outFile;
	}
	
	public void doAdd() throws IOException{
		int total = 0;
		String line = null;
		
		try(BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))){
			while((line = reader.readLine())!=null) {
				total += Integer.parseInt(line);
			}
		}
		
		try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(outFile))){
			writer.write("Total: " + total);
		}
	}
}

	//main code
	String[] inFiles = {"./file1.txt",..."./file6.txt"};
	String[] outFiles = {"./file1.out.txt",..."./file6.out.txt"};
	
	try {
		for(int i=0;i<inFiles.length;i++) {
			SimpleAdderClassAndThreadClass adder = new SimpleAdderClassAndThreadClass(inFiles[i],outFiles[i]);
			adder.doAdd();
		}
	}catch(IOException e) {
		//do something
	}

										*/

					//Adder with Threading support
//Not that simple Simple Adder Class
public class SimpleAdderClassAndThreadClass implements Runnable{
	private String inFile,outFile;
	public SimpleAdderClassAndThreadClass(String inFile,String outFile) {
		this.inFile=inFile;
		this.outFile=outFile;
	}
	
	public void doAdd() throws IOException{
		int total = 0;
		String line = null;
		
		try(BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))){
			while((line = reader.readLine())!=null) {
				total += Integer.parseInt(line);
			}
		}
		
		try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(outFile))){
			writer.write("Total: " + total);
		}
	}
	
	public void run() {
		try {
			doAdd();
		}catch(IOException e) {}
	}
}

	//main code
	String[] inFiles = {"./file1.txt",..."./file6.txt"};
	String[] outFiles = {"./file1.out.txt",..."./file6.out.txt"};
	
	Thread[] threads = new Thread[inFiles.length];
	
		for(int i=0;i<inFiles.length;i++) {
			SimpleAdderClassAndThreadClass adder = new SimpleAdderClassAndThreadClass(inFiles[i],outFiles[i]);
			threads[i] = new Thread(adder);
			threads[i].start();
		}
		
	for(Thread thread:threads)
		thread.join();//Blocks waiting for thread completion
		//main thread continues running as long as background threads have done their job
	


























