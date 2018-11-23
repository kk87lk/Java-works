import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;


public class FileFlow {
	public void writeIntoFile(CityGroup cityGroupFile) {
		String spr = File.separator;
        String filename = "C:"+spr+"Data.txt";
        try {
            File f = new File(filename);
            if (!f.exists()) {
                f.createNewFile();
            }
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(f));
            BufferedWriter writer = new BufferedWriter(write);
            for(int i = 0;i<=19;i++) 
            	writer.write(cityGroupFile.getCityUnits()[i].getCityName()+" "+cityGroupFile.getCityUnits()[i].getX()+" "+cityGroupFile.getCityUnits()[i].getY()+"\r\n");
            for(int i = 0;i<=19;i++) {
            	for(int l = 0;l<=19;l++)
            		writer.write(cityGroupFile.getConnect()[i][l]+" ");
            	writer.write("\r\n");
            }
            System.out.println(cityGroupFile.getCount());
            writer.write(cityGroupFile.getCount() + " ");
            writer.flush();  
            write.close();
            writer.close();
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
        return;
	}
	
	public CityGroup readFromFile() {
		CityGroup temp = new CityGroup();
		
		int[][] tempC = new int[20][20];
		for(int i = 0;i<=19;i++)
			for(int l = 0;l<=19;l++)
				tempC[i][l] = 0;
		CityUnit[] tempU = new CityUnit[20];
		for(int i = 0;i<=19;i++)
			tempU[i] = new CityUnit();
		String spr = File.separator;
        String filename = "C:"+spr+"Data.txt";
        try {
            FileReader f = new FileReader(filename);
//            InputStreamReader read = new InputStreamReader(new FileInputStream(f));
            BufferedReader reader = new BufferedReader(f);
            String tempS = new String();
            for(int i = 0;i<=19;i++) {
            	tempS = reader.readLine();
            	String[] tempSS = tempS.split(" ");
            	tempU[i].setCityName(tempSS[0]);
            	tempU[i].setX(Integer.parseInt(tempSS[1]));
            	tempU[i].setY(Integer.parseInt(tempSS[2]));
            	temp.setCityUnits(tempU);
            }
            for(int i = 0;i<=19;i++) {
            	tempS = reader.readLine();
            	String[] tempSS = tempS.split(" ");
            	for(int l = 0;l<=19;l++) {
            		tempC[i][l] = Integer.parseInt(tempSS[l]);
            	}
            }
            temp.setConnect(tempC);
            temp.setCount(Integer.parseInt(reader.readLine()));
            reader.close();
            return temp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return temp;
	}
}
