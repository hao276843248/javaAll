package hao;

import java.util.Arrays;

public class DAO implements IVDAO {
	private Ren[] rens=new Ren[3];
	private int index=-1;

	@Override
	public void addPerson(String name) {
		Ren ren=new Ren(name,0);
		if(++index==this.rens.length){
			this.rens=Arrays.copyOf(this.rens, index+1);
		}
		
		rens[index]=new Ren(name,0);
		
	}

	@Override
	public int getPerson(String name) {
		for (int i = 0; i < rens.length; i++) {
			if(name.equals(rens[i].getName())){
				return -1;
			}
		}
		return 1;
	}

	@Override
	public Ren[] find() {
		Ren[] a=Arrays.copyOf(rens, rens.length);
		Arrays.sort(a);
		return  a;
	}

	@Override
	public void tou(String name) {
		for (int i = 0; i < rens.length; i++) {
			if(name.equals(rens[i].getName())){
				rens[i].setPiao(rens[i].getPiao()+1);
			}
		}
	}
	
	

	
}
