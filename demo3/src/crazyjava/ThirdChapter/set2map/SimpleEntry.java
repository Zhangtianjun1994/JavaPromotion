package crazyjava.ThirdChapter.set2map;

import java.util.Map;

public class SimpleEntry<K, V> implements Map.Entry<K,V>,java.io.Serializable{

	private final K key;
	private V value;
	
	public SimpleEntry(K key,V value){
		this.key = key;
		this.value = value;
	}
	
	public SimpleEntry(Map.Entry<? extends K, ? extends V> entry){
		this.key = entry.getKey();
		this.value = entry.getValue();
	}
	
	
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public V setValue(V value) {
		// TODO Auto-generated method stub
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	public boolean equals(Object o){
		if(o == this){
			return true;
		}
		if(o.getClass() == SimpleEntry.class){
			SimpleEntry e = (SimpleEntry) o;
			return e.getKey()==this.value;
		}
		
		return false;
	}
	
	//¸ù¾Ýkey¼ÆËãhashcode
	public int hashCode(){
		return key == null ? 0 : key.hashCode();
	}
	
	public String toString(){
		return key+"="+value;
	}
}
