//Streams
	//Base Stream classes
	/*
	 * Stream is an ordered sequence of data
	 * 		Provide a common I/O model
	 * 		Abstracts details of underlying source or destination
	 * 		Stream types are unidirectional
	 * 
	 * 2 categories
	 * 		Byte streams
	 * 			interact as binary data   01101110
	 * 		Text streams
	 * 			interact as Unicode characters
	 * 
	 * In general interaction is the same for both stream types
	 * 
	 *  
	 *  Reading from streams
		 *  Base class for reading binary data is InputStream
		 *  	for individual byte, we call the read() method, returning an int
		 *  	for arrays, we have int read(byte[] buff)
		 *  Base class for reading text data is Reader class
		 *  	for individual character, we call the read() method, returning an int
		 *  	for arrays, we have int read(char[] buff)
		   
			Reading One Byte at a time
			 	InputStream input = //create input stream
			 	int intVal;
			 	while((intVal = input.read()) >= 0){
			 		byte byteVal = (byte) intVal;
			 		//do something with byteVal
			 	}
			 	
			Reading One Character at a time
			 	Reader reader = //create reader
			 	int intVal;
			 	while((intVal = reader.read()) >= 0){
			 		char charVal = (char) intVal;
			 		//do something with charVal
			 	}
			 	
			 Reading Array of Bytes
			 	 InputStream input = //create input stream
			 	 int length;
			 	 byte[] byteBuff = new byte[10];
			 	 while((length = input.read(byteBuff)) >= 0){
			 	 	for(int i=0; i<length; i++){
			 	 		byte byteVal = byteBuff[i];
			 	 		//do something with byteVal
			 	 	}
			 	 }
			 	 
			 Reading Array of Characters
			 	 Reader reader = //create reader
			 	 int length;
			 	 char[] charBuff = new char[10];
			 	 while((length = reader.read(charBuff)) >= 0){
			 	 	for(int i=0; i<length; i++){
			 	 		char charVal = charBuff[i];
			 	 		//do something with charVal
			 	 	}
			 	 }
	
			 	 	
		Writing to streams
			Base class for writing binary data is OutputStream
				has a write() method that accepts a int, which you want to write
				has a write method in which we can pass array too
			Base class for writing character data is Writer
				void write(int ch)
				void write(char[] buff)
				void write(String str)
				
			Writing bytes
				OutputStream output = //create output stream
				byte byteVal = 100;
				output.write(byteval);
				
				byte[] byteBuff = {0,63,127};
				output.write(byteBuff);
				
			Writing characters
				Writer writer = //create writer
				char charVal = 'a';
				writer.write(charVal);
				
				char[] charBuff = {'a','b','c'};
				writer.write(charBuff);
				
				String stringVal = "Hello World";
				writer.write(stringVal);
	 */

//	Common Input/OutputStream Derived Classes
		/*
		 * InputStream
		 * 		ByteArrayInputStream
		 * 		PipedInputStream
		 * 		FileInputStream
		 */

		/*
		 * OutputStream
		 * 		ByteArrayOutputStream
		 * 		PipedOutputStream
		 * 		FileOutputStream
		 */

 //	 Common Reader/Writer Derived Classes
		/*
		 * Reader
		 * 		CharArrayReader
		 * 		StringReader
		 * 		PipedReader
		 * 		InputStreamReader
		 * 			FileReader
		 */

		/*
		 * Writer
		 * 		CharArrayWriter
		 * 		StringWriter
		 * 		PipedWriter
		 * 		OutputStreamWriter
		 * 			FileWriter
		 */

//Chaining Streams
	/*
	 * Streams are often chained together
	 * 		One stream instance leverages another
	 * 		Creates higher-level functionality
	 * 		Simplifies reusability
	 * 		Chain using constructor
	 * Example
	 * 		InputStreamReader leverages chaining
	 * 			Reader behavior over InputStream
	 * 			Character behavior over binary
	 * 		
	 * 		void doChain(InputStream in) throws IOException{
	 * 			int length;
	 * 			char[] charBuff = new char[128];
	 * 			try(InputStreamReader rdr = new InputStreamReader(in)){
	 * 				while((length = rdr.read(charBuff)) >= 0){
	 * 					//do something with charBuff
	 * 				}
	 * 			}
	 * 		}
	 * 
	 * 		can create your own "high-level" streams
	 * 			Most commonly chain similar streams
	 * 				Chain a reader over a reader,etc.
	 * 		Classes available to simplify customization
	 * 			FilterReader,FilterWriter,
	 * 			FilterInputStream,FilterOutputStream
	 * 			Abstract classes
	 * 			Methods call to contained stream methods
	 * 			Override only customized methods
	 * 
	 * Common uses of streams is interacting with files
	 * 	java.io package has classes for each stream type
	 * 		FileReader
	 * 		FileWriter
	 * 		FileInputStream
	 * 		FileOutputStream
	 * 	The java.io classes are now deprecated
	 * 		still widely used in code
	 * 
	 * 		Buffered Streams
	 * 			Direct file access can be inefficient
	 * 			so buffered streams can improve efficiency
	 * 				Buffers content in memory
	 * 				Performs reads/writes in large chunks
	 * 				Reduces underlying stream interaction
	 * 			Buffered available for all 4 stream types
	 * 				BufferedReader
	 * 				BufferedWriter
	 * 				BufferedInputStream
	 * 				BufferedOutputStream
	 * 
	 * 			try(BufferedReader br = 
	 * 				new BufferedReader(new FileReader("file1.txt"))){
	 * 				int intVal;
	 * 				while((intVal = br.read()) >= 0){
	 * 					char charVal = (char) intVal;
	 * 					//do something with charVal
	 * 				}
 * 				}
 * 				
 * 				Buffered Streams and Line Breaks
 * 					Line breaks vary across platforms
 * 						Unix
 * 							\n(new line)
 * 						Windows
 * 							\r\n(carriage return & new line)
 * 					Buffered streams add line break support
 * 						uses correct value for current platform
 * 						BufferedWriter
 * 							Generate line breaks: newLine()
 * 						BufferedReader
 * 							Line based read: readLine()
 * 
 * 
 * 
 * 				String[] data ={
					"Line 1",
					"Line 2 2",
					"Line 3 3 3",
					"Line 4 4 4 4",
					"Line 5 5 5 5 5"
				};
 * 				void writeData(String[] data) throws IOException{
 * 					try(BufferedWriter bw =
 * 						new BufferedWriter(new FileWriter("data.txt"))){
 * 						for(String d:data){
 * 							bw.write(d); //everything will be on single line
 * 							bw.newLine();
 * 						}	
 * 					}
 * 				}
 * 				void readData() throws IOException{
 * 					try(BufferedReader br =
 * 						new BufferedReader(new FileReader("data.txt"))){
 * 						String inValue;
 * 						while((inValue = br.readLine()) != null){
 * 							System.out.println(inValue);
 * 						}	
 * 					}
 * 				}
	 */

//Regular expressions
	/*
	 *   \w+  - match 1+ word characters(letter digit underscore)
	 *   \b   - match word breaks
	 *   
	 *   String Class Support for Regular Expressions
	 *   	replaceFirst, replaceAll methods
	 *   		return a new updated string
	 *   	split method
	 *   		splits string into an array
	 *   	match method
	 *   		identifies if string matches the pattern
	 *   
	 */

//Dedicated Regular expressions classes
/*
 * 		Compilation is processing intensive
 * 		String methods repeat compilation on every use
 * 
 * Pattern class
 * 		compiles a regular expression
 * 		Factory for Matcher class instances
 */
		

package onlineCoaching.streams;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Streams {
	public static void main(String[] args) {
		
//		using replaceAll
		String s1 = "apple apple and orange please";
		String s2 = s1.replaceAll("ple\\b", "ricot");
		System.out.println(s2);
		
//		Using the split and match methods
		String[] parts = s1.split("\\b");
		for(String thePart:parts) {
			if(thePart.matches("\\w+"))
				System.out.println(thePart);
			
//			Using Pattern and Matcher classes
			String value = "apple, apple and orange please";
			Pattern pattern = Pattern.compile("\\w+");
			Matcher matcher = pattern.matcher(value);
			while(matcher.find())
				System.out.println(matcher.group());
		}
	}
	
}














