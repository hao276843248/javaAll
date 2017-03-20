package lvyou.dao;

import java.util.List;

import lvyou.model.Manage;





public interface ManageDao  {
	
	
	
	public void insertBean(Manage bean);
	
	public void deleteBean(Manage bean);
	
	public void updateBean(Manage bean);

	public Manage selectBean(String where);
	
	public List<Manage> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
