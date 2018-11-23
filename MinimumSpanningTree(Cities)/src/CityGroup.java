
class CityUnit {
	private String cityName = "Undefined";
	private int cityNo = 0;
	private int x = 0;
	private int y = 0;
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityNo(int cityNo) {
		this.cityNo = cityNo;
	}
	public int getCityNo() {
		return cityNo;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
}


public class CityGroup {
	private CityUnit[] cityUnits = new CityUnit[20];
	private int[][] connect = new int[20][20];
	private int count = 0;
	
	public CityGroup() {
		// TODO Auto-generated constructor stub
		int x = 0;
		while(x<=19) {
			cityUnits[x] = new CityUnit();
			x++;
		}
		int m = 0,n = 0;
		for(; m <= 19;m++)
			for(; n <= 19; n++)
				connect[m][n] = 0;
	}
	public void setCityUnits(CityUnit[] cityUnits) {
		this.cityUnits = cityUnits;
	}
	public CityUnit[] getCityUnits() {
		return cityUnits;
	}
	public void setConnect(int[][] connect) {
		this.connect = connect;
	}
	public int[][] getConnect() {
		return connect;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCount() {
		return count;
	}
}