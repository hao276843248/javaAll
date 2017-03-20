package cn.hao.easybuy.dao.order;

import cn.hao.easybuy.entity.EasybuyOrder;

public interface IOrderDAO {

	public void addorder(EasybuyOrder order);
	public void deleteorder(int id);
	public void update(EasybuyOrder order);

}
 