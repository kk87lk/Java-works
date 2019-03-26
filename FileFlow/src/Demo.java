import java.io.IOException;

public class Demo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileLocation = "C:\\Demo\\CreatedFile.txt";
		String targetLocation = "C:\\Demo\\CopyedFile.txt";
		FileIO fileIO = new FileIO();
		fileIO.moveFile(fileLocation, targetLocation);
	}

}
