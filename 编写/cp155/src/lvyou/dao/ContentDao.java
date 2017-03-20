package lvyou.dao;

import java.util.List;

import lvyou.model.Content;



public interface ContentDao  {
	
	
	public void insertBean(Content bean);
	
	public void deleteBean(Content bean);
	
	public void updateBean(Content bean);

	public Content selectBean(String where);
	
	public List<Content> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
