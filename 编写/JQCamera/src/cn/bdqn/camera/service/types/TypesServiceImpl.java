package cn.bdqn.camera.service.types;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.camera.dao.types.ITypesDAO;
import cn.bdqn.camera.entity.Types;

@Service("typesService")
public class TypesServiceImpl implements ITypesService {

	private ITypesDAO typesDAO;
	@Autowired
	public void setTypesDAO(ITypesDAO typesDAO) {
		this.typesDAO = typesDAO;
	}
	
	
	@Override
	public List<Types> find() {
		return typesDAO.find();
	}
	
}
