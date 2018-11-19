

public class CityGroup {
	private CityUnit[] CityNo = null;
	private int[][] connect = {{0}};
	
	public void setCityNo(CityUnit[] cityNo) {
		CityNo = cityNo;
	}
	public CityUnit[] getCityNo() {
		return CityNo;
	}
	public void setConnect(int[][] connect) {
		this.connect = connect;
	}
	public int[][] getConnect() {
		return connect;
	}
}

class CityUnit {
	private String cityName = "Undefined";
	private int cityNo = 0;
	private int count = 0;
	
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
	public void setCount(int count) {
		this.count = count;
	}
	public int getCount() {
		return count;
	}
}