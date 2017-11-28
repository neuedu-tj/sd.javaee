package test;

import org.junit.Test;

import com.dao.UsersDao;
import com.model.Users;

public class TestUsers {
	
	@Test
	public void testCheckUsers() {
		
		
		
		Users u = new Users(1, "tom" , "222123");
		
		
		UsersDao dao = new UsersDao();
//		
//		boolean flag = dao.checkUsers(u);
//		System.out.println("有此用户么 ? " + flag);
	}

}
