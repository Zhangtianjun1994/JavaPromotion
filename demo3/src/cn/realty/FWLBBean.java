package cn.realty;

public class FWLBBean {
	private double avgFJ = 0.0;
	private String LB;
	private String year;
	private String qy;
	
	public FWLBBean(){}
	public FWLBBean(double avgFJ,String LB,String year,String qy){
		this.avgFJ = avgFJ;
		this.year = year;
		this.LB = LB;
		this.qy = qy;
	}
	
	public void setQy(String qy){
		this.qy = qy;
	}
	
	public String getQy(){
		return qy;
	}

	public double getAvgFJ() {
		return avgFJ;
	}

	public void setAvgFJ(double avgFJ) {
		this.avgFJ = avgFJ;
	}

	public String getLB() {
		return LB;
	}

	public void setLB(String lB) {
		LB = lB;
	}

	public String getMonth() {
		return year;
	}

	public void setMonth(String year) {
		this.year = year;
	}
	

}
