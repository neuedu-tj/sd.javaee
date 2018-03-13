package javase.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import javase.set.support.Stu;

public class TestTreeSet {
	
	@Test
	public void testTreeSet () {
		Set set = new TreeSet();
		
		Stu s1 = new Stu(2, 20 , 89 , "A");
		Stu s2 = new Stu(1, 21 , 80 , "C");
		Stu s3 = new Stu(4, 22 , 87 , "D");
		Stu s4 = new Stu(3, 20 , 63, "B");
		
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		
		Iterator<Stu> it = set.iterator();
		
		while( it.hasNext() ){
			Stu s = it.next();
			System.out.println(s);
		}
		
	}

}
