import java.sql.*;

/**
 * Created by mm on 2017/5/3.
 */
public class ConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8";
        String username = "root";
        String password = "root";
        System.out.println("this is a test");
        String driverClass = "com.mysql.jdbc.Driver";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url,username,password);
            stmt = conn.createStatement();
            String insertSql = "insert into user(id,username,password,phone)values(\"2\",\"zhang\",\"lisi\",\"13516269745\")";
            boolean b = stmt.execute(insertSql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stmt = null;
            }
            if(conn !=null){
                try{
                    conn.close();
                    conn = null;
                }catch(SQLException e){
                }
            }
        }
    }
}
