package javase.set.support;

public class Stu implements Comparable<Stu> {

	private int id;
	private int age;
	private int score;
	private String name;

	public Stu() {

	}

	public Stu(int id, int age, int score, String name) {
		super();
		this.id = id;
		this.age = age;
		this.score = score;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Stu [id=" + id + ", age=" + age + ", score=" + score + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Stu o) {
		Stu s1 = this;
		Stu s2 = o;
		
		if(s1.getScore() > s2.getScore() ) return -1;
		else if( s1.getScore() < s2.getScore() ) return 1;
		else return 0;
	
	}


}
