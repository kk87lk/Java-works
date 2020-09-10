import java.util.ArrayList;
import java.util.List;

public class FarmUnit {

    private String name;

    private String dept;

    private int money;

    private List<FarmUnit> subordinates;

    // ¹¹Ôìº¯Êý
    public FarmUnit(String name, String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.money = sal;
        subordinates = new ArrayList<FarmUnit>();
    }

    public void add(FarmUnit e) {
        subordinates.add(e);
    }

    public void remove(FarmUnit e) {
        subordinates.remove(e);
    }

    public List<FarmUnit> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return ("FarmUnit :[ Name : " + name + ", dept : " + dept + ", money :" + money + " ]");
    }
}