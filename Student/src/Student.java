
public class Student {
	String No = "";
	String name = "";
	int score_en = 0;
	int score_ma = 0;
	int score_co = 0;
	int score_sum = 0;
	
	public Student(String no, String name, int en, int ma, int co) {
		this.No = no;
		this.name = name;
		this.score_en = en;
		this.score_ma = ma;
		this.score_co = co;
		setSum();
	}
	
	private void setSum() {
		this.score_sum = this.score_co + this.score_en + this.score_ma;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setNo(String no) {
		this.No = no;
	}
	public void setScore_co(int score_co) {
		this.score_co = score_co;
		setSum();
	}
	public void setScore_en(int score_en) {
		this.score_en = score_en;
		setSum();
	}
	public void setScore_ma(int score_ma) {
		this.score_ma = score_ma;
		setSum();
	}
	public String getName() {
		return name;
	}
	public String getNo() {
		return No;
	}
	public int getScore_co() {
		return score_co;
	}
	public int getScore_en() {
		return score_en;
	}
	public int getScore_ma() {
		return score_ma;
	}
	public int getScore_sum() {
		return score_sum;
	}
	
	@Override
	public String toString() {
		return No + " " + name + " " + score_en + " " + score_ma + " " + score_co + " " + score_sum;
	}
	
	public boolean equals(Student s) {
		if(s.name.equals(name)&&s.No.equals(No)&&s.score_co == score_co&&s.score_en == score_en&&s.score_ma == score_ma)
			return true;
		else
			return false;
	}
	
	public int compare(Student s) {
		if(score_sum > s.score_sum)
			return 1;
		else if(score_sum == s.score_sum)
			return 0;
		else
			return -1;
	}
	
	public int testScore() {
		int testScore = 0;
		testScore = score_sum / 3;
		return testScore;
	}
}
