package cn.hao.camera.util;

public class Fanwei {

	//��Сֵ
	private Number minValue;
	//���ֵ
	private Number maxValue;
	public Fanwei(String str) {
		String[] parts=str.split("~");
		//��ȡ����ĵ�һ��Ԫ��ת������Сֵ
		minValue=Double.valueOf(parts[0]);
		if(parts.length==2){
			//��ȡ����ĵڶ���Ԫ��ת�������ֵ
			maxValue=Double.valueOf(parts[1]);
		}
	}
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
