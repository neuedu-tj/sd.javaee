package test;

import org.junit.Test;

import com.dao.MomentsDao;
import com.model.Moments;

public class TestMoments {
	
	@Test
	public void testAddMoments() {
		Moments m = new Moments("��8������Ȧ......" );
		
		MomentsDao dao = new MomentsDao();
		dao.saveMoments(m);
		
	}

}
