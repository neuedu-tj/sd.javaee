package test;

import org.junit.Test;

import com.dao.UsersDao;
import com.model.Users;

public class TestUsers {
	
	@Test
	public void testCheckUsers() {

		Users user = new Users("tom" , "123");
		
		UsersDao dao = new UsersDao();
		
		Users curr = dao.checkUsers(user);
		
		System.out.println(curr);
//		
//		boolean flag = dao.checkUsers(u);
//		System.out.println("有此用户么 ? " + flag);
	}

}
