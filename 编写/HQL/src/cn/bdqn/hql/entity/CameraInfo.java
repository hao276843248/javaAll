package cn.bdqn.hql.entity;

public class CameraInfo {

	private long rowCount;
	private double minPrice;
	private double maxPrice;
	private double avgPrice;
	
	public CameraInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public CameraInfo(long rowCount, double minPrice, double maxPrice,
			double avgPrice) {
		super();
		this.rowCount = rowCount;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.avgPrice = avgPrice;
	}




	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public double getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}
	
	
	
	
	
}
