package cn.collection.queue;

public class TestPriority {

	public static void main(String args[]){
		patient p1 = new patient("zxl1",2);
		patient p2 = new patient("zxl2",6);
		patient p3 = new patient("zxl3",1);
		patient p4 = new patient("zxl4",10);
		patient p5 = new patient("zxl5",12);
		
		MyPriorityQueue<patient> priority = new MyPriorityQueue<patient>();
		
		priority.enqueue(p1);
		priority.enqueue(p2);
		priority.enqueue(p3);
		priority.enqueue(p4);
		priority.enqueue(p5);
		
		while(priority.getSize() > 0)
			System.out.println(priority.dequeue());
		
	}
	
	public static class patient implements Comparable<patient>{
		private String name;
		private int priority;
		
		public patient(String name,int priority){
			this.name = name;
			this.priority = priority;
		}
		
		public String toString(){
			return name+"(priority:"+this.priority+")";
		}
		

		@Override
		public int compareTo(patient o) {
			// TODO Auto-generated method stub
			return this.priority-o.priority;
		}
	}
			
}
