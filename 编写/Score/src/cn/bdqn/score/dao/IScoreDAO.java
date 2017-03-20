package cn.bdqn.score.dao;

import java.util.List;

import cn.bdqn.score.entity.Score;

public interface IScoreDAO {

	//添加成绩
	public void addScore(Score score);
	
	//删除成绩
	public void deleteScore(String name);
	
	//修改成绩
	public void updateScore(String name,int newScore);
	
	//查询成绩
	public List<Score> findScore();
}







