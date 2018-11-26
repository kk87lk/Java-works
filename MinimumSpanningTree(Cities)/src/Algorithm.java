import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Vex{
	int num = -1;
	Vex pre = null;
	public Vex() {
		num = -1;
		pre = this;
	}
	public int getNum() {
		return num;
	}
	public Vex getPre() {
		return pre;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setPre(Vex pre) {
		this.pre = pre;
	}
}
class Edge implements Comparable<Edge>{
	Vex vex1 = new Vex();
	Vex vex2 = new Vex();
	int weigh = 0;
	public Edge(Vex vex1_in,Vex vex2_in,int weigh_in) {
		vex1 = vex1_in;
		vex2 = vex2_in;
		weigh = weigh_in;
	}
	public Vex getVex1() {
		return vex1;
	}
	public Vex getVex2() {
		return vex2;
	}
	public int getWeigh() {
		return weigh;
	}
	public void setVex1(Vex vex1) {
		this.vex1 = vex1;
	}
	public void setVex2(Vex vex2) {
		this.vex2 = vex2;
	}
	public void setWeigh(int weigh) {
		this.weigh = weigh;
	}
	@Override
	public int compareTo(Edge e) {
		if(weigh > e.weigh)
			return 1;
		else if(weigh < e.weigh)
			return -1;
		return 0;
	}
}
public class Algorithm{
	
	Vex find(Vex v) {
		if(v.getPre() == v)
			return v;
		else
			return find(v.getPre());
	}
	
	public int[][] prim(CityGroup cityGroup) {
		int[][] connect_re = new int[20][20];
		int[][] connect_temp = cityGroup.getConnect();
		int[] unitList = new int[20];
		for(int i = 0;i<cityGroup.getCount();i++)
			unitList[i] = 0;//0 unchecked,1 checked
		int tempM = 0, tempN = 0;
		unitList[0] = 1;
		for(int count = 0;count<cityGroup.getCount() - 1;count++) {
			int value_temp = 10000;
			for(int m = 0;m<cityGroup.getCount();m++) {
				for(int n = 0;n<cityGroup.getCount();n++) {
					if(unitList[m] == 1 && unitList[n] == 0 && connect_temp[m][n] != 0 && connect_temp[m][n] < value_temp) {
						value_temp = connect_temp[m][n];
						tempM = m;
						tempN = n;
					}
				}
			}
			connect_re[tempM][tempN] = connect_temp[tempM][tempN];
			unitList[tempN] = 1;
		}
		return connect_re;
	}
    
	public int[][] kruskal(CityGroup cityGroup) {
		int[][] connect_re = new int[20][20];
		int[][] connect_temp = cityGroup.getConnect();
		List<Edge> edges = new ArrayList<Edge>();
		Vex[] vexs = new Vex[cityGroup.getCount()];
		for(int i = 0;i<cityGroup.getCount();i++) 
			vexs[i] = new Vex();
		for(int i = 0;i<cityGroup.getCount();i++) {
			vexs[i].setNum(i);
			vexs[i].setPre(vexs[i]);
		}
		for(int m = 0;m<cityGroup.getCount();m++) {
			for(int n = m;n<cityGroup.getCount();n++) {
				if(connect_temp[m][n] != 0) 
					edges.add(new Edge(vexs[m],vexs[n],connect_temp[m][n]));
			}
		}
		int flag = 0;
		Collections.sort(edges);
		for(int i = 0;i<edges.size();i++) {
			if(find(edges.get(i).getVex1()) != find(edges.get(i).getVex2())) {
				find(edges.get(i).getVex2()).setPre(find(edges.get(i).getVex1()));
				connect_re[edges.get(i).getVex1().getNum()][edges.get(i).getVex2().getNum()] = edges.get(i).getWeigh();
				flag++;
			}else 
				continue;
			if(flag == cityGroup.getCount() - 1)
				break;
		}
		
		return connect_re;
	}
	
	
}