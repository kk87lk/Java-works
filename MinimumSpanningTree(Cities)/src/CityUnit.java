
public class CityUnit {
    private String cityName;
    private int cityNo;
    private int[][] connect = {{0}};
    
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
    public void setConnect(int[][] connect) {
		this.connect = connect;
	}
    public int[][] getConnect() {
		return connect;
	}
}
