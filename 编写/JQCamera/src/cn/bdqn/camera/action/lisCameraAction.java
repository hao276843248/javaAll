package cn.bdqn.camera.action;

import java.util.List;

import cn.bdqn.camera.dao.camera.ICameraDAO;
import cn.bdqn.camera.entity.Camera;
import cn.bdqn.camera.service.cameras.ICameraService;
import cn.bdqn.camera.util.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class lisCameraAction extends ActionSupport{

	private ICameraService cameraService;
	
	//��ҳ���� ��JQuery Easyui��DataGrid ������� �ķ�ҳ����
	private int page=1;//ҳ��
	private int rows=10;//ÿҳ����
	private String sort="id";//�����ֶ�
	private String order="asc";//�������
	
	private Long brandId;
	private Long typeId;
	private Double maxPrice;
	private Integer minPixel;
	private String title;
	
	//��ѯ���
	private List<Camera> result;
	//������
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

	//getRows���������ڷ����������ɵ�JSON�����б�
	public List<Camera> getRows() {
		return result;
	}

	//setRows�����������մӿͻ��˷��͵�ÿҳ����
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
