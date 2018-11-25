import java.util.LinkedList;
import java.util.Queue;

public class Algorithm{
	
	public int[][] prim(CityGroup cityGroup) {
		int[][] connect_re = new int[20][20];
		int[][] connnect_temp = cityGroup.getConnect();
		int countUnit = 0;
		Queue<Integer> unitList;
//		LinkedList<Integer> unitList = new LinkedList();
		unitList.offer(0);
		int i = 0;
		while(countUnit == cityGroup.getCount()) {
			i = unitList.poll();
			for(int n = 0;connnect_temp[][])
			unitList.offer();
			countUnit++;
		}
		return connect_re;
	}
    
}
