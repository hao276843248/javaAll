package hao;

public class TouService {
	public static final int SUCCSS=1;
	public static final int PERSON_EXIST=-1;
	public static final int PERSON_NOT_EXIST=-2;
	
	private DAO dao=new DAO();
	
	
	public Ren[] show(){
		return dao.find();
	}
	
	public int addren(String name){
		
		
		int x=dao.getPerson(name);
		if(x==-1){
			return -1;
		}else if(x==1){
			dao.tou(name);
			return 1;
		}
		return 0;
	}

	
	
}





