package onlineCoaching.string;

public class FormatString {
	public static void main(String[] args) {
		int david = 13, dawson = 11,dillon = 4;
		
		String s1 = "My nephews are " + david + ", " + dawson + ", " + dillon +" years old";
		
		String s2 = String.format("My nephews are %d,%d and %d years old", david,dawson,dillon);
		//or System.out.printf();
		
		
		System.out.println(s1);
		System.out.println(s2);
		
		
		//Format Conversions
		/*
		 * s conversion is pretty powerful, we cn also pass object instances into it that are not strings
		 * So if we pass an object instance with a %s, if that class implements the
		 * interface formattable, what will happen is the formattable.format() method
		 * will be called and whatever value that returns will appear in the resulting 
		 * string. now if we pass an object instance that does not implement the formattable
		 * interface, then it justr calls the toString() method
		 * */
		
		
		//Format Flags
		/*
		 * Flag					Meaning
		 * -------------------------------------------------------------------
		 * 	#  					include radix
		 * 
		 * 	String s1 = String.format("%d",32);  =>32	//decimal
		 *  String s2 = String.format("%o",32);  =>40	//octal
		 *  String s3 = String.format("%x",32);  =>20   //hex
		 *  
		 *  String s4 = String.format("%#o",32);  =>040	//octal with radix
		 *  String s5 = String.format("%#x",32);  =>0x20   //hex with radix
		 *  String s6 = String.format("%#X",32);  =>0X20   //hex with radix
		 *  ------------------------------------------------------------------
		 *  
		 *   0					zero-padding
		 *   -					Left justify
		 *   
		 *   String s7 = String.format("W:%d X:%d", 5, 235);   =>  W:5 X:235
		 *   String s8 = String.format("Y:%d Z:%d", 481, 12);   => Y:481 Z:12
		 *   															|
		 *   															|
		 *   											The	<= _________|
		 *   										alignment here
		 *   										is all messed up
		 *   String s9 = String.format("W:%4d X:%4d", 5, 235);   => W:   5 X: 235
		 *   String s10 = String.format("Y:%4d Z:%4d", 481, 12); => Y: 481 Z:  12
		 *   
		 *   What if i want digits not spaces
		 *   String s11 = String.format("W:%04d X:%04d", 5, 235);   => W:0005 X:0235
		 *   
		 *   What if want it to be left justified?
		 *   String s12 = String.format("W:%-4d X:%-4d", 5, 235);   => W:5 X:235
		 *   
		 *   ------------------------------------------------------------------------
		 *   
		 *    ,						include grouping separator
		 *    
		 *    String s13 = String.format("%d", 1234567);  => 1234567
		 *    String s14 = String.format("%,d", 1234567);  => 1,234,567	
		 *    String s15 = String.format("%,.2f", 1234567.0);  => 1,234,567.00
		 *    
		 *    -----------------------------------------------------------------
		 *    
		 *     space				Leave space for positive numbers	
		 *       +					Always shown sign
		 *       (					Enclose negative values in parenthesis
		 *      
		 *    String s16 = String.format("%d",123);    => 123 	
		 *    String s17 = String.format("%d",-123);   => -123//issue is they will be pushed to the left, they dont align properly
		 *    String s18 = String.format("% d",123);   =>  123	
		 *    String s19 = String.format("% d",-123);  => -123
		 *    
		 *    String s20 = String.format("%+d",123);   => +123
		 *    String s21 = String.format("%+d",-123);  => -123	
		 *    
		 *    String s22 = String.format("% (d",123);   =>  123  //two flags used here space and parenthesis for alignment
		 *    String s23 = String.format("%(d",-123);  =>  (123)	
		 * */
		
		//Argument Index
		/*
		 *		Index					Meaning
		 *----------------------------------------------------------------------
		 *		Not specified			Corresponds sequentially to argument
		 *		   $index				Index of argument to use
		 *		      <					Corresponds to same argument as previous format specifier
		 *			  
		 *	   String s24 = String.format("%d %d %d", 100, 200, 300);	=>100 200 300
		 *     String s25 = String.format("%3$d %1$d %2$d", 100, 200, 300);	=>300 100 200
		 *     String s26 = String.format("%$2d %<04d %$1d", 100, 200, 300); =>200 0200 100
		 *----------------------------------------------------------------------------------------    	
		 */
		
		//Writing formatted content to a Stream
			/*
			 * Formatter class
			 * 		Provides formatting capabilities
			 * 		String.format actually uses this under the covers
			 * 		Writes content to any type that implements Appendable interface
			 * 		StringBuilder implements Appendable interface
			 * 		Writer Stream class also implements Appendable interface
			 * 
			 * Writer stream class
			 * 		implements Appendable interface
			 * 		
			 * 		void doWrite(int david, int dawson, int dillon) throws IOException{
			 * 			BufferedWriter writer = 
			 * 				Files.newBufferedWriter(Paths.get("myFile.txt"));
			 * 			//now i will create a formatter over that writer
			 * 			try(Formatter f = new Formatter(writer)){
			 * 				f.format("My nephews are %d,%d,%d years old",david,dawson,dillon);
			 * 				//this all gets directly written to that file
			 * 			}
			 * 		}
			 */
		
	}
}














