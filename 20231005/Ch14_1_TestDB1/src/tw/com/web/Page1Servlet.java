package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/page1")
public class Page1Servlet extends  HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/testdb20231005?serverTimezone=CST&useSSL=false&allowPublicKeyRetrieval=true";
		String user = "root";
		String password = "123456";
		String sql = "INSERT INTO user_info(account,password)VALUES(?,?)";
//		try(Connection conn = DriverManager.getConnection(url,user,password);
//				PreparedStatement ps =	conn.prepareStatement(sql);) {
//			ps.setString(1, "Joy");
//			ps.setString(2, "123456");
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e);
//		}
		
		String sql2 = "SELECT * FROM user_info";
		try(Connection conn = DriverManager.getConnection(url,user,password);
			PreparedStatement ps = conn.prepareStatement(sql2);){
			ResultSet resultSet  = ps.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String account = resultSet.getString(2);
				String mypass = resultSet.getString(3);
				System.out.println(id+":"+account+":"+mypass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
