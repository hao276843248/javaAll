package cn.hao.easybuy.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hao.easybuy.dao.comment.ICommentDAO;
import cn.hao.easybuy.entity.EasybuyComment;
import cn.hao.easybuy.util.PageBean;
@Service("commentServiceImpl")
public class CommentServiceImpl implements ICommentService{

	private ICommentDAO commentDAOImpl;
	@Autowired
	public void setCommentDAOImpl(ICommentDAO commentDAOImpl) {
		this.commentDAOImpl = commentDAOImpl;
	}
	@Override
	public void addComment(EasybuyComment comment) {
		commentDAOImpl.addComment(comment);
	}

	@Override
	public PageBean findComment(Integer pageIndex, Integer pageSize) {
		
		return commentDAOImpl.findComment(pageIndex, pageSize);
	}

	@Override
	public void updateComment(EasybuyComment comment) {
		commentDAOImpl.updateComment(comment);
	}

	@Override
	public void delete(Integer id) {
		commentDAOImpl.delete(id);
	}
	@Override
	public EasybuyComment get(Integer id) {

		return commentDAOImpl.get(id);
	}

}
