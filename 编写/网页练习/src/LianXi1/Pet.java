package LianXi1;

public class Pet {
	private String name;
	private int jiankzhi;
	private int love;
	
	public Pet() {
	}
	
	public  Pet(String name,int jiankzhi,int love){
		this.jiankzhi=jiankzhi;
		this.love=love;
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJiankzhi() {
		return jiankzhi;
	}
	public void setJiankzhi(int jiankzhi) {
		if(0<jiankzhi&&jiankzhi<100){
			this.jiankzhi = jiankzhi;
		}else{
			System.out.println("ÊäÈëÇ×ÃÜ¶ÈÓÐ´íÎó,»Ö¸´Ä¬ÈÏÖµ£¨60£©");
			this.jiankzhi = 60;
		}
		
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		if(0<love&&love<100){
			this.love = love;
		}else{
			System.out.println("ÊäÈëÇ×ÃÜ¶ÈÓÐ´íÎó,»Ö¸´Ä¬ÈÏÖµ£¨60£©");
			this.love = 60;
		}
		
	}

	
	
}
