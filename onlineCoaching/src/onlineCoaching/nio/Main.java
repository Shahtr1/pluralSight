//FileReader, FileWriter,FileInputStream,FileOutputStream (only the file Types)

/*
	Path	
		used to locate a file system item
		can be a file or a directory
		
	Paths
		Static Path factory methods
		From string-based hierarchical path
		From URI
		
	Path p1 = Paths.get("\\documents\\data\\foo.txt");	
	or
	Path p2 = Paths.get("\\documents","data","foo.txt");
	
	Once we have a path we can use Files Type to interact with those files
	
	Files
		Static methods for interacting with files
		Create,Copy,Delete,etc.
		Open file streams
			newBufferedReader
			newBufferedWriter
			newInputStream
			newOutputStream
			
			In java io, we had to create file reader object or file writer object
			but here we	have a factory method , we are using a Files type to get it
		Read/write file contents
			readAllLines
			write
		
		void readData() throws IOException{
			try(BufferedReader br = 
				Files.newBufferedReader(Paths.get("data.txt"))){
					String inValue;
					while((inValue = br.readLine())!=null){
						Sop(inValue);
					}
				}
		}
		
								Read All Lines
		void readThemAll() throws IOException{
			List<String> lines = 
				Files.readAllLines(Paths.get("data.txt"));
				
				for(String line:lines)
					Sop(line);
		}
		
		Paths class works only for default file systems
		so we have to hace some more general way of interacting
		with file systems and getting access to path instances within a file system
		To do that:
			
			FileSystem
				Represents an individual file system
				contain Factory for Path instances
			FileSystems
				Static FileSystem factory methods
				Open or create a file system
					newFileSystem
			How to identify File Systems
				File systems identified by URIs
					specifics of URI vary greatly
					Zip file system uses "jar:file" scheme
						jar:file:/jimwilson/data/bar.zip
				File systems support custom properties
					Different for each file system type
					Examples
						Whether to create if doesn't exist
						String encoding
				
		
*/

package onlineCoaching.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main{
	public static void main(String ...args){
		String[] data ={
			"Line 1",
			"Line 2 2",
			"Line 3 3 3",
			"Line 4 4 4 4",
			"Line 5 5 5 5 5"
		};
		
		try(FileSystem zipFs = openZip(Paths.get("myData.zip"))){
			copyToZip(zipFs);
			writeToFileInZip1(zipFs,data);
			writeToFileInZip2(zipFs,data);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	private static FileSystem openZip(Path zipPath) throws IOException,URISyntaxException{
		Map<String,String> providerProps = new HashMap<>();
		providerProps.put("create","true");
		
		URI zipUri = new URI("jar:file",zipPath.toUri().getPath(),null);
		FileSystem zipFs = FileSystems.newFileSystem(zipUri,providerProps);
		
		return zipFs;
	}
	
	private static void copyToZip(FileSystem zipFs) throws IOException{
		Path sourceFile = Paths.get("file1.txt");//Paths is just a shortcut or we can use
//		Path sourceFile = FileSystems.getDefault().getPath("file1.txt");
		
		Path destFile = zipFs.getPath("/file1Copied.txt");
		
		Files.copy(sourceFile, destFile,StandardCopyOption.REPLACE_EXISTING);
	}
	
	private static void writeToFileInZip1(FileSystem zipFs,String[] data) throws IOException{
		try(BufferedWriter writer = Files.newBufferedWriter(zipFs.getPath("/newFile1.txt"))){
			for(String d:data) {
				writer.write(d);
				writer.newLine();
			}
		}
	}
	
	private static void writeToFileInZip2(FileSystem zipFs,String[] data) throws IOException{
		//as it should implement iterable so we convert the string array to a list
		Files.write(zipFs.getPath("/newFile2.txt"),Arrays.asList(data),Charset.defaultCharset(),StandardOpenOption.CREATE);
	}
}




















