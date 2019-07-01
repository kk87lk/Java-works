import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperation {

	//JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/librarymanage?useSSL=false&useUnicode=true&characterEncoding=utf8";
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
                // 判断账号是否存在
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
	
	public Object[][] getData() {
		java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        int count = 0;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * from book ORDER BY BookID";
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
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
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
            return info;
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
		return null;
	}
	
	public boolean add(int id,String i,String j,String k,String l,double price,int number) {
		java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行插入
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO book VALUES("+id+",'"+i+"','"+j+"','"+k+"','"+l+"',"+price+","+number+");";
            stmt.executeUpdate(sql);
            // 完成后关闭
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
	
	public boolean del(String isbn) {
		java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行插入
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT BookISBN from book";
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                String ISBN = rs.getString("BookISBN");
                // 判断密码是否正确
                if(isbn.equals(ISBN)) {
                	sql = "DELETE FROM book where BookISBN='"+isbn+"'";
                    stmt.executeUpdate(sql);
                    stmt.close();
                    conn.close();
                	return true;
                }
            }
            // 完成后关闭
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
	
	public Book findISBN(String isbn) {
		Book tep = new Book();
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
            sql = "SELECT * FROM book WHERE BookISBN='"+isbn+"'";
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
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
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
            return tep;
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
		return null;
	}
	
	public Book findName(String name) {
		Book tep = new Book();
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
            sql = "SELECT * FROM book WHERE BookName='"+name+"'";
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
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
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
            return tep;
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
		return null;
	}
	
	public boolean changeBook(String isbn, Book CB) {
		java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行插入
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE book SET BookID="+CB.getBookID()+", BookISBN='"+CB.getBookISBN()+"', BookName='"+CB.getBookName()+"', BookAuthor='"+CB.getBookAuthor()+"', BookPress='"+CB.getBookPress()+"', BookPrice="+CB.getBookPrice()+", BookNumber="+CB.getBookNumber()+" WHERE BookISBN='"+isbn+"'";;
            stmt.executeUpdate(sql);
            // 完成后关闭
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
		
		Book kind = new Book();
		Book kind2 = new Book();
		kind.setBookID(4);
		kind.setBookISBN("978-7-5680-1139-6");
		kind.setBookName("《巴黎伦敦落魄记》");
		kind.setBookAuthor("奥威尔");
		kind.setBookPress("奥威尔作品出版社");
		kind.setBookPrice(42.8);
		kind.setBookNumber(22);
		rip.changeBook("978-7-5680-1139-6", kind);
	}
}
