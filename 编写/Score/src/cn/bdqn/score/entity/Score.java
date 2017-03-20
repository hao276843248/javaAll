package cn.bdqn.score.entity;

import java.io.Serializable;

public class Score implements Serializable{

	private static final long serialVersionUID = 4280379655826976268L;
	
	private String name;
	private int score;
	
	public Score() {
		// TODO Auto-generated constructor stub
	}

	public Score(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
