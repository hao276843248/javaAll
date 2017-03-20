package cn.hao.easybuy.form.productategory;

public class ProductcategoryForm {

	private Integer epcId;
	private String epcName;
	private Integer epcParentId;
	private Integer level;
	
	public Integer getEpcId() {
		return epcId;
	}
	public void setEpcId(Integer epcId) {
		this.epcId = epcId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getEpcName() {
		return epcName;
	}
	public void setEpcName(String epcName) {
		this.epcName = epcName;
	}
	public Integer getEpcParentId() {
		return epcParentId;
	}
	public void setEpcParentId(Integer epcParentId) {
		this.epcParentId = epcParentId;
	}
	
	
}
