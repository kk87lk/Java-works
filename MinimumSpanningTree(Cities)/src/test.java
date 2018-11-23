import javax.swing.JFrame;

public class test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	CityGroup cities = new CityGroup();
    	CityUnit citiesUnit = cities.getCityUnits()[cities.getCount()];
		System.out.println(cities.getCount());
    	while(citiesUnit.getX() != 0) {
    		System.out.println(cities.getCount());
    		cities.setCount(cities.getCount() + 1);
    	}
    }
}
