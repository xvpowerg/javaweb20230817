package tw.com.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import tw.com.jpa.MyUser;

@Stateless
public class MyUserBean  implements MyUserBeanLocal{
		
	@Inject
	private EntityManager em;
	@Override
	public boolean login(MyUser myUser) {
		// TODO Auto-generated method stub
		 TypedQuery<MyUser>  query = 
				 em.createNamedQuery("findMyUserByAccountAnPass",MyUser.class);
		 query.setParameter("account", myUser.getAccount());
		 query.setParameter("password", myUser.getPassword());
		 try {
			return  query.getSingleResult() != null;
		 }catch(Exception ex) {
			 System.out.println(ex);
		 }
		return false;
	}

	@Override
	public boolean regisrter(MyUser myUser) {
		// TODO Auto-generated method stub
		try {
			
			if (this.findUserByAccount(myUser.getAccount())!= null) {
				return false;
			}
			
			em.persist(myUser);
			return true;
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		
		return false;
	}

	@Override
	public MyUser findUserByAccount(String account) {
		// TODO Auto-generated method stub
		MyUser myUser = null;
		 TypedQuery<MyUser> query = em.createNamedQuery("findMyUserByAccount",MyUser.class);
		 query.setParameter("account", account);
		 try {
			 myUser =  query.getSingleResult();
			 return myUser;
		 }catch(Exception ex) {
			 System.out.println(ex);
		 }
		
		return null;
	}

	@Override
	public boolean deleteUser(MyUser myUser) {
		// TODO Auto-generated method stub
		try {
			MyUser rObj =  em.merge(myUser);
			em.remove(rObj);
			return true;
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return false;
	}

}
