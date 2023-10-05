package tw.com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tw.com.beans.MyUser;

public class MySqlUser implements UserDao {

	@Override
	public boolean login(String account, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean regisrter(String account, String password) {
		String sql = "INSERT  INTO user_info(account,password)VALUES(?,?)";
		try(Connection conn =  DbTools.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, account);
			ps.setString(2, password);
			return ps.executeUpdate() > 0;
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MyUser findUserById(String account) {
		// TODO Auto-generated method stub
		return null;
	}

}
