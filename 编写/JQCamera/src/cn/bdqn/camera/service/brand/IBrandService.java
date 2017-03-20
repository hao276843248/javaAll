package cn.bdqn.camera.service.brand;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.bdqn.camera.entity.Brand;

public interface IBrandService {
	public List<Brand> find();
}
