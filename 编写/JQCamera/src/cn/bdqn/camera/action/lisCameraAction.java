package cn.bdqn.camera.action;

import java.util.List;

import cn.bdqn.camera.dao.camera.ICameraDAO;
import cn.bdqn.camera.entity.Camera;
import cn.bdqn.camera.service.cameras.ICameraService;
import cn.bdqn.camera.util.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class lisCameraAction extends ActionSupport{

	private ICameraService cameraService;
	
	//分页参数 由JQuery Easyui的DataGrid 组件发送 的分页参数
	private int page=1;//页号
	private int rows=10;//每页行数
	private String sort="id";//排序字段
	private String order="asc";//排序规则
	
	private Long brandId;
	private Long typeId;
	private Double maxPrice;
	private Integer minPixel;
	private String title;
	
	//查询结果
	private List<Camera> result;
	//总行数
	private int total;
	
	@Override
	public String execute() throws Exception {
		PageBean p=cameraService.find(page, rows, brandId, typeId, maxPrice, minPixel, title, sort, order);
		result=p.getRows();
		total=p.getTotal();
		return SUCCESS;
	}

	public void setCameraService(ICameraService cameraService) {
		this.cameraService = cameraService;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	//getRows方法用来在服务器端生成的JSON数据列表
	public List<Camera> getRows() {
		return result;
	}

	//setRows方法用来接收从客户端发送的每页行数
	public void setRows(int rows) {
		this.rows = rows;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Integer getMinPixel() {
		return minPixel;
	}

	public void setMinPixel(Integer minPixel) {
		this.minPixel = minPixel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Camera> getResult() {
		return result;
	}

	public void setResult(List<Camera> result) {
		this.result = result;
	}


	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


	
	
	
}
