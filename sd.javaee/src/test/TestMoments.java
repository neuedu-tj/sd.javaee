package test;

import java.util.List;

import org.junit.Test;

import com.dao.MomentsDao;
import com.model.Moments;

public class TestMoments {
	
	
	
	@Test
	public void testAddMoments() {
		Moments m = new Moments("第8条朋友圈......" );
		
		MomentsDao dao = new MomentsDao();
		dao.saveMoments(m);
		
	}
	
	@Test
	public void findAllMoments() {
		MomentsDao dao = new MomentsDao();
		List<Moments> moments = dao.getMoments();
		
		for (Moments m : moments) {
			System.out.println(m);
		}
	}

}
