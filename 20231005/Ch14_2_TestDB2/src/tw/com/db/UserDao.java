package tw.com.db;

import tw.com.beans.MyUser;

public interface UserDao {
   boolean login(String account,String password);
   boolean regisrter(String account,String password);
   MyUser findUserById(String account);
}
