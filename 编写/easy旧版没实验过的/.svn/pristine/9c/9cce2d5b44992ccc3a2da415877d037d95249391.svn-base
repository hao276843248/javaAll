package cn.hao.easybuy.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hao.easybuy.dao.product.IProductDAO;
import cn.hao.easybuy.entity.EasybuyProduct;
import cn.hao.easybuy.util.PageBean;


@Service("productService")
public class ProductServiceImpl implements IProductService{

	private IProductDAO productDAO;
	@Autowired
	public void setProductDAO(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	@Override
	public EasybuyProduct get(Integer id) {
		return productDAO.get(id);
	}

	@Override
	public PageBean find(int pageIndex, int pageSize, int lei) {
		
		return productDAO.find(pageIndex, pageSize, lei);
	}

	@Override
	public void delete(Integer id) {
		productDAO.delete(id);
	}

	@Override
	public void add(EasybuyProduct product) {
		productDAO.add(product);
	}

	@Override
	public void update(EasybuyProduct product) {
		productDAO.update(product);
	}


	
}
