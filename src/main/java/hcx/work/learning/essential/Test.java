package hcx.work.learning.essential;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
	String path = "C:\\score.txt";

	Map<String, Integer> map = new HashMap<String, Integer>();
//	map.put("hel", 10);
	map.compute("hel", (k, v) -> {
	    if (v == null) {
		return 1;
	    }
	    return v + 1;
	});
	System.out.println(map.get("hel"));
    }

}

class Student {
    private String name;
    private String score;
    private String cls;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getScore() {
	return score;
    }

    public void setScore(String score) {
	this.score = score;
    }

    public String getCls() {
	return cls;
    }

    public void setCls(String cls) {
	this.cls = cls;
    }

    public Student(String name, String score, String cls) {
	super();
	this.name = name;
	this.score = score;
	this.cls = cls;
    }

}
