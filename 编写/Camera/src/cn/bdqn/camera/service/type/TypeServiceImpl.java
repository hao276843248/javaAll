package cn.bdqn.camera.service.type;

import java.util.List;

import cn.bdqn.camera.dao.type.ITypeDAO;
import cn.bdqn.camera.dao.type.TypeDAOImpl;
import cn.bdqn.camera.entity.Type;

public class TypeServiceImpl implements ITypeService{
	
	private ITypeDAO typeDAO=new TypeDAOImpl();
	
	@Override
	public List<Type> findType() {
		return typeDAO.findType();
	}

}
