import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperation {

	//JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/librarymanage?useSSL=false";
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
                String Pwd = rs.getString("Pwd");
                // �ж������Ƿ���ȷ
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
	public static void main(String[] args) {
		DBOperation rip = new DBOperation();
		rip.getData();
	}
}
