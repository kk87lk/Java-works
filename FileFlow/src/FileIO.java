import java.io.*;
import java.util.Scanner;
public class FileIO {
	public void creatFile(String fileLocation) throws IOException{
		FileWriter writer = new FileWriter(fileLocation);
		Scanner scanner = new Scanner(System.in);
		String content = null;
		content = scanner.nextLine();
		writer.write(content+"\r\n");
		while(!(content = scanner.next()).equals("#"))
			writer.write(content+"\r\n");
		scanner.close();
		writer.close();
	}
	
	public void moveFile(String fileLocation,String targetLocation) throws IOException{
		String line = null;
		BufferedReader in = new BufferedReader(new FileReader(fileLocation));
		FileWriter writer = new FileWriter(targetLocation);
		line = in.readLine();
		while(line != null) {
			writer.write(line+"\r\n");
			System.out.println(line);
			line = in.readLine();
		}
		in.close();
		writer.close();
	}
}
