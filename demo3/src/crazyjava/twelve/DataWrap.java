package crazyjava.twelve;

public class DataWrap implements Comparable<DataWrap>{

	private int data;
	private String flag;
	public DataWrap(int data,String flag) {
		this.data = data;
		this.flag= flag;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String toString(){
		return "["+this.data+","+this.flag+"]";
	}
	@Override
	public int compareTo(DataWrap o) {
		if(this.data > o.data)
			return 1;
		else if(this.data < o.data)
			return -1;
		else
			return 0;
	}

}
