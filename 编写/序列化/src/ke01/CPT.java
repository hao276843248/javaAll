package ke01;

import java.io.Serializable;

public class CPT implements Serializable {
	
	
	private static final long serialVersionUID = 1231231231;
	private String cpu;
	private int nc;
	private String yp;
	
	public CPT() {
		// TODO Auto-generated constructor stub
	}

	public CPT(String cpu, int nc, String yp) {
		super();
		this.cpu = cpu;
		this.nc = nc;
		this.yp = yp;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getNc() {
		return nc;
	}

	public void setNc(int nc) {
		this.nc = nc;
	}

	public String getYp() {
		return yp;
	}

	public void setYp(String yp) {
		this.yp = yp;
	}
	
	
}
