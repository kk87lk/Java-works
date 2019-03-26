import java.io.*;
import java.util.StringTokenizer;

public class SplitWords {
	 public static String txtToString () throws IOException{
		 InputStream inputStream = new FileInputStream("c:\\652\\a\\abc.txt");
		 BufferedReader inReader = new BufferedReader(new InputStreamReader(inputStream));
		 StringBuffer buffer = new StringBuffer();
		 String line = "";
		 while((line = inReader.readLine()) != null) {
			 buffer.append(line + " ");
		 }
		 inReader.close();
		 return buffer.toString();
	 }
	 
	 public static void main(String args[]) {
		 String txt = "";
		 String split = " ";
		 try {
			txt = txtToString();
			StringTokenizer stringTokenizer = new StringTokenizer(txt,split);
			System.out.print(stringTokenizer.countTokens());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
