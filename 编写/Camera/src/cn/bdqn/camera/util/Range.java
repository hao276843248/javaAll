package cn.bdqn.camera.util;

public class Range {

	
	public Range(String str){
		String[] parts=str.split("~");
		//提取数组的第一个元素转换成最小值
		minValue=Double.valueOf(parts[0]);
		if(parts.length==2){
			//提取数组的第二个元素转换成最大值
			maxValue=Double.valueOf(parts[1]);
		}
	}
	
	//最小值
	private Number minValue;
	//最大值
	private Number maxValue;
	
	
	public Number getMinValue() {
		return minValue;
	}
	public void setMinValue(Number minValue) {
		this.minValue = minValue;
	}
	public Number getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(Number maxValue) {
		this.maxValue = maxValue;
	}
	
	
}
