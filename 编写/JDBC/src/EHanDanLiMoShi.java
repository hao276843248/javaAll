
public class EHanDanLiMoShi {
	
	private EHanDanLiMoShi(){};
	
	private static EHanDanLiMoShi a=new EHanDanLiMoShi();
	
	public static EHanDanLiMoShi geta(){
		return a;
	}
}
