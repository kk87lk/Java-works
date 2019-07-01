import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperation {

	//JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/librarymanage?useSSL=false&useUnicode=true&characterEncoding=utf8";
    // ���ݿ���û���������
    static final String USER = "root";
    static final String PASS = "root";
    
    public boolean register(String acc, String pwd) {
	    java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
            // ������
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // ִ�в�ѯ
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * from account";
            ResultSet rs = stmt.executeQuery(sql);
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                String Acc = rs.getString("Acc");
                // �ж��˺��Ƿ����
                if(acc.equals(Acc))
                	return false;
            }
            sql = "INSERT INTO account VALUES ('" + acc + "','" + pwd +"')";
            stmt.executeUpdate(sql);
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
            return true;
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		return false;
    }
    
	public boolean isCorrect(String acc, String pwd) {
		    java.sql.Connection conn = null;
	        java.sql.Statement stmt = null;
	        try{
	            // ע�� JDBC ����
	            Class.forName(JDBC_DRIVER);
	            // ������
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	            // ִ�в�ѯ
	            stmt = conn.createStatement();
	            String sql;
	            sql = "SELECT * from account";
	            ResultSet rs = stmt.executeQuery(sql);
	            // չ����������ݿ�
	            while(rs.next()){
	                // ͨ���ֶμ���
	                String Acc = rs.getString("Acc");
	                String Pwd = rs.getString("Pwd");
	                // �ж������Ƿ���ȷ
	                if(acc.equals(Acc)&&pwd.equals(Pwd))
	                	return true;
	            }
	            // ��ɺ�ر�
	            rs.close();
	            stmt.close();
	            conn.close();
	            return false;
	        }catch(SQLException se){
	            // ���� JDBC ����
	            se.printStackTrace();
	        }catch(Exception e){
	            // ���� Class.forName ����
	            e.printStackTrace();
	        }finally{
	            // �ر���Դ
	            try{
	                if(stmt!=null) stmt.close();
	            }catch(SQLException se2){
	            }// ʲô������
	            try{
	                if(conn!=null) conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }
	        }
			return false;
	}
	
	public Object[][] getData() {
		java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        int count = 0;
        try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
            // ������
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // ִ�в�ѯ
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * from book ORDER BY BookID";
            ResultSet rs = stmt.executeQuery(sql);
            // չ����������ݿ�
            while(rs.next())
                count++;
            Object[][] info = new Object[count][7];
            
            count = 0;
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
            	info[count][0] = Integer.valueOf(rs.getInt("BookID"));
            	info[count][1] = rs.getString("BookISBN");
            	info[count][2] = rs.getString("BookName");
            	info[count][3] = rs.getString("BookAuthor");
            	info[count][4] = rs.getString("BookPress");
            	info[count][5] = Double.valueOf(rs.getDouble("BookPrice"));
            	info[count][6] = Integer.valueOf(rs.getInt("BookNumber"));
            	count++;
            }
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
            return info;
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		return null;
	}
	
	public boolean add(int id,String i,String j,String k,String l,double price,int number) {
		java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
            // ������
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // ִ�в���
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO book VALUES("+id+",'"+i+"','"+j+"','"+k+"','"+l+"',"+price+","+number+");";
            stmt.executeUpdate(sql);
            // ��ɺ�ر�
            stmt.close();
            conn.close();
            return true;
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		return false;
	}
	
	public boolean del(String isbn) {
		java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
            // ������
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // ִ�в���
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT BookISBN from book";
            ResultSet rs = stmt.executeQuery(sql);
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                String ISBN = rs.getString("BookISBN");
                // �ж������Ƿ���ȷ
                if(isbn.equals(ISBN)) {
                	sql = "DELETE FROM book where BookISBN='"+isbn+"'";
                    stmt.executeUpdate(sql);
                    stmt.close();
                    conn.close();
                	return true;
                }
            }
            // ��ɺ�ر�
            stmt.close();
            conn.close();
            return false;
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		return false;
	}
	
	public Book findISBN(String isbn) {
		Book tep = new Book();
		java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
            // ������
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // ִ�в�ѯ
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM book WHERE BookISBN='"+isbn+"'";
            ResultSet rs = stmt.executeQuery(sql);
            // չ����������ݿ�
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
            	tep.setBookID(Integer.valueOf(rs.getInt("BookID")));
            	tep.setBookISBN(rs.getString("BookISBN"));
            	tep.setBookName(rs.getString("BookName"));
            	tep.setBookAuthor(rs.getString("BookAuthor"));
            	tep.setBookPress(rs.getString("BookPress"));
            	tep.setBookPrice(Double.valueOf(rs.getDouble("BookPrice")));
            	tep.setBookNumber(Integer.valueOf(rs.getInt("BookNumber")));
            }
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
            return tep;
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		return null;
	}
	
	public Book findName(String name) {
		Book tep = new Book();
		java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
            // ������
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // ִ�в�ѯ
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM book WHERE BookName='"+name+"'";
            ResultSet rs = stmt.executeQuery(sql);
            // չ����������ݿ�
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
            	tep.setBookID(Integer.valueOf(rs.getInt("BookID")));
            	tep.setBookISBN(rs.getString("BookISBN"));
            	tep.setBookName(rs.getString("BookName"));
            	tep.setBookAuthor(rs.getString("BookAuthor"));
            	tep.setBookPress(rs.getString("BookPress"));
            	tep.setBookPrice(Double.valueOf(rs.getDouble("BookPrice")));
            	tep.setBookNumber(Integer.valueOf(rs.getInt("BookNumber")));
            }
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
            return tep;
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		return null;
	}
	
	public boolean changeBook(String isbn, Book CB) {
		java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
            // ������
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // ִ�в���
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE book SET BookID="+CB.getBookID()+", BookISBN='"+CB.getBookISBN()+"', BookName='"+CB.getBookName()+"', BookAuthor='"+CB.getBookAuthor()+"', BookPress='"+CB.getBookPress()+"', BookPrice="+CB.getBookPrice()+", BookNumber="+CB.getBookNumber()+" WHERE BookISBN='"+isbn+"'";;
            stmt.executeUpdate(sql);
            // ��ɺ�ر�
            stmt.close();
            conn.close();
            return false;
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		return false;
	}
	public static void main(String[] args) {
		DBOperation rip = new DBOperation();
		
		Book kind = new Book();
		Book kind2 = new Book();
		kind.setBookID(4);
		kind.setBookISBN("978-7-5680-1139-6");
		kind.setBookName("�������׶����Ǽǡ�");
		kind.setBookAuthor("������");
		kind.setBookPress("��������Ʒ������");
		kind.setBookPrice(42.8);
		kind.setBookNumber(22);
		rip.changeBook("978-7-5680-1139-6", kind);
	}
}
