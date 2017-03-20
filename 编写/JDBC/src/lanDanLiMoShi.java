
public class lanDanLiMoShi {
	
	private lanDanLiMoShi(){};
	
	private static lanDanLiMoShi a;
	
	public static lanDanLiMoShi geta(){
		if(a==null){
			a=new lanDanLiMoShi();
		}
		return a;
	}
	
	
}
