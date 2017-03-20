package cn.bdqn.score.dao;

import java.util.List;

import cn.bdqn.score.entity.Score;

public interface IScoreDAO {

	//��ӳɼ�
	public void addScore(Score score);
	
	//ɾ���ɼ�
	public void deleteScore(String name);
	
	//�޸ĳɼ�
	public void updateScore(String name,int newScore);
	
	//��ѯ�ɼ�
	public List<Score> findScore();
}







