

public class CityGroup {
	private CityUnit[] cityUnits = null;
	private int[][] connect = {{0}};
	private int count = 0;
	
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

class CityUnit {
	private String cityName = "Undefined";
	private int cityNo = 0;
	
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
}