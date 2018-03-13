package javase.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class TestSet {
	
	
	@Test
	public void testHashAndTree() {
		
		Set<Integer> s1 = new HashSet<Integer>();
		s1.add(2);
		s1.add(1);
		s1.add(5);
		s1.add(3);
		
		Set<String> s2 = new HashSet<String>();
		s2.add("2");
		s2.add("1");
		s2.add("5");
		s2.add("3");
		
//		System.out.println(s2);
		
		////遍历
		Iterator it = s1.iterator();
		while(it.hasNext()) {
			Integer e = (Integer) it.next();
			System.out.println(e);
		}
		
	}

}
