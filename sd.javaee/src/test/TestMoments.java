package test;

import org.junit.Test;

import com.dao.MomentsDao;
import com.model.Moments;

public class TestMoments {
	
	@Test
	public void testAddMoments() {
		Moments m = new Moments("µÚ8ÌõÅóÓÑÈ¦......" );
		
		MomentsDao dao = new MomentsDao();
		dao.saveMoments(m);
		
	}

}
