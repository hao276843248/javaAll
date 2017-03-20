package lvyou.dao;

import java.util.List;

import lvyou.model.Pinglun;



public interface PinglunDao  {
	
	
	public void insertBean(Pinglun bean);
	
	public void deleteBean(Pinglun bean);
	
	public void updateBean(Pinglun bean);

	public Pinglun selectBean(String where);
	
	public List<Pinglun> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
