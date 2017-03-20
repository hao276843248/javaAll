package lvyou.dao;

import java.util.List;

import lvyou.model.Baoming;



public interface BaomingDao  {
	
	
	public void insertBean(Baoming bean);
	
	public void deleteBean(Baoming bean);
	
	public void updateBean(Baoming bean);

	public Baoming selectBean(String where);
	
	public List<Baoming> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
