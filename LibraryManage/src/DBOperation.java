import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperation {

	//JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/librarymanage?useSSL=false";
    // 数据库的用户名与密码
    static final String USER = "root";
    static final String PASS = "root";
    
    public boolean register(String acc, String pwd) {
	    java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * from account";
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                String Acc = rs.getString("Acc");
                String Pwd = rs.getString("Pwd");
                // 判断密码是否正确
                if(acc.equals(Acc))
                	return false;
            }
            sql = "INSERT INTO account VALUES ('" + acc + "','" + pwd +"')";
            stmt.executeUpdate(sql);
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
            return true;
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
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
	            // 注册 JDBC 驱动
	            Class.forName(JDBC_DRIVER);
	            // 打开链接
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	            // 执行查询
	            stmt = conn.createStatement();
	            String sql;
	            sql = "SELECT * from account";
	            ResultSet rs = stmt.executeQuery(sql);
	            // 展开结果集数据库
	            while(rs.next()){
	                // 通过字段检索
	                String Acc = rs.getString("Acc");
	                String Pwd = rs.getString("Pwd");
	                // 判断密码是否正确
	                if(acc.equals(Acc)&&pwd.equals(Pwd))
	                	return true;
	            }
	            // 完成后关闭
	            rs.close();
	            stmt.close();
	            conn.close();
	            return false;
	        }catch(SQLException se){
	            // 处理 JDBC 错误
	            se.printStackTrace();
	        }catch(Exception e){
	            // 处理 Class.forName 错误
	            e.printStackTrace();
	        }finally{
	            // 关闭资源
	            try{
	                if(stmt!=null) stmt.close();
	            }catch(SQLException se2){
	            }// 什么都不做
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
		System.out.print(rip.isCorrect("admin", "admin"));
	}
}
