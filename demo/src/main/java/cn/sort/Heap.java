package cn.sort;

import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
	//E是实现Comparable接口的类，<E>具有限定实现Comparable接口为E的作用
	private ArrayList<E> list = new ArrayList<>();
	
	public Heap(){
		
	}
	
	public Heap(E []objects){
		for(int i=0;i<objects.length;i++)
		add(objects[i]);
	}
	
	public void add(E object){
		//System.out.println("add方法");
		list.add(object);
		int currentIndex = list.size()-1;
		
		while(currentIndex > 0){
			int parentIndex = (currentIndex-1)/2;
			if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0){
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
			}
			else
				break;
			currentIndex = parentIndex;
		}
	}
	
	public E remove(){
		if(list.size() == 0) return null;
		E removeObject = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		
		int currentIndex = 0;
		while(currentIndex < list.size()){
			int leftChild = currentIndex * 2 + 1;
			int rightChild = currentIndex * 2+2;
			if(leftChild >= list.size()) break;
			
			int maxIndex = leftChild;
			if(rightChild < list.size()){
				if(list.get(rightChild).compareTo(list.get(leftChild))>0)
					maxIndex = rightChild;
			}
			if(list.get(maxIndex).compareTo(list.get(currentIndex)) > 0){
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(maxIndex));
				list.set(maxIndex, temp);
			}
			else
				break;
			currentIndex = maxIndex;
		}
		return removeObject;
	}
	
	public int getSize(){
		return list.size();
	}

}
