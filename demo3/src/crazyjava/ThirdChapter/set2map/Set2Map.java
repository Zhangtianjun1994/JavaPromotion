package crazyjava.ThirdChapter.set2map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Set2Map<K,V> extends HashSet<SimpleEntry<K,V>> {
	
	//清空
	public void clear(){
		super.clear();
	}
	
	//判断是否包含某个key
	public boolean containsKey(Object key){
		return super.contains(new SimpleEntry<K,V>((K) key,null));
	}
	
	public boolean containsValue(Object value){
		for(SimpleEntry<K, V> se:this){
			if(se.getValue().equals(value))
				return true;
		}
		return false;
	}
	
	public V get(Object key){
		for(SimpleEntry<K, V> se:this){
			if(se.getKey().equals(key))
				return se.getValue();
		}
		return null;
	}
	
	public V put(K key,V value){
		add(new SimpleEntry<K,V>(key,value));
		return value;
	}
	
	public void putAll(Map<? extends K,? extends V> m){
		for(K key:m.keySet()){
			add(new SimpleEntry<K,V>(key,m.get(key)));
		}
	}
	
	public V removeEntry(Object key){
		
		Iterator<SimpleEntry<K, V>> it = this.iterator();
		for(;it.hasNext();){
			SimpleEntry<K, V> se = it.next();
			if(se.getKey().equals(key)){
				V v = se.getValue();
				it.remove();
				return v;
			}
		}
		return null;
	}
	
	public int size(){
		return super.size();
	}

}
