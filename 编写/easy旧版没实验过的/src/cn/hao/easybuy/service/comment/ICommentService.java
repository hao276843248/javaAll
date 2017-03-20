package cn.hao.easybuy.service.comment;

import cn.hao.easybuy.entity.EasybuyComment;
import cn.hao.easybuy.util.PageBean;

public interface ICommentService {

	public void addComment(EasybuyComment comment);
	
	public PageBean findComment(Integer pageIndex,Integer pageSize);
	
	public void updateComment(EasybuyComment comment);
	
	public void delete(Integer id);
	
	public EasybuyComment get(Integer id);
}
