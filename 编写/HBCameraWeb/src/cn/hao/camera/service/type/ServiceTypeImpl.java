package cn.hao.camera.service.type;

import java.util.List;

import cn.hao.camera.Dao.type.TypeImpl;
import cn.hao.camera.Dao.type.TypeMapper;
import cn.hao.camera.entity.Type;



public class ServiceTypeImpl implements IServiceType{
	private TypeMapper it=new TypeImpl();
	public List<Type> findType(){
		return it.findType();
	}
}
