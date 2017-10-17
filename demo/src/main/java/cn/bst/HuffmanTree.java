package cn.bst;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class HuffmanTree {  
	    Node treeRoot=null;  
	    HuffCode huff=new HuffCode();  
	  
	    public HuffmanTree(SortedList<Node> values){  
	  
	        while(true){  
	        
	            Node first=values.get(0);  
	            values.remove(0);  
	            Node root=first;  
	        	if(values.size()<=0){  
	                treeRoot=root;  
	                break;  
	            }
	            Node two=values.get(0);  
	            if(two!=null){  
	                values.remove(0);  
	                root=new Node(null,first.weight+two.weight);  
	                root.left=first;  
	                root.right=two;  
	                values.insertItem(root);  
	            }  
	  
	        }  
	    }  
	  
	  
	  
	    public static void main(String args[]) throws Exception{  
	        long start=new Date().getTime();  
	        SortedList<Node> list=new SortedList<Node>(SortedList.ASC);  
	        for(int i=0;i<5;i++){  
	            int value=(int)(Math.random()*100);  
	            list.insertItem(new Node(value, value));  
	          
	        }  
	  
	        long end=new Date().getTime();  
	        System.out.println("共耗时:"+(end-start));  
	        System.out.println(list);  
	        HuffmanTree ht=new HuffmanTree(list);  
	        System.out.println("霍夫曼编码");  
	        ht.show(ht.treeRoot,0);  
	  
	  
	    }  
	  
	    void show(Node node,int c){  //中序遍历
	    	

	        if(node.left!=null){  
	            huff.put(c,0);  
	            show(node.left, c + 1);  
	        }  
		       
	        if(node.value!=null)  
		          System.out.println("c的值："+c+"权重:"+node.weight+"  霍夫曼编码值:"+huff.toString().substring(0,c));  
	        
	        if(node.right!=null){  
	            huff.put(c,1);  
	            show(node.right, c + 1);  
	        }  
  

	    }  
	  
	  
	  
	  
	}  
	  
	class Node{  
	    Object value;  
	    int weight;  
	    Node left;  
	    Node right;  
	  
	    public Node(Object value,int weight){  
	        this.value=value;  
	        this.weight=weight;  
	    }  
	  
	    public boolean equals(Object obj){  
	        Node node=(Node) obj;  
	        if(node.weight==this.weight&&node.value==this.value)  
	            return true;  
	        return false;  
	    }  
	}  
	  
	class SortedList<T extends Node> extends LinkedList<T> {  
	    public static String DESC="desc";  
	    public static String ASC="asc";  
	  
	    public String sort;  
	  
	    public SortedList(String sort) throws Exception{  
	        if(sort.equals(DESC))  
	            this.sort=DESC;  
	        else if(sort.equals(ASC))  
	            this.sort=ASC;  
	        else  
	            throw new Exception("no support sort");  
	    }  
	  
	    public void insertItem(T value){  
	           int index=0;  
	           if(this.size()>0){  
	               int start=0;  
	               int end=this.size()-1;  
	               int step=0;  
	               if(start!=end)  
	                   while((end-start)!=1){  
	                        step=(end-start)/2;  
	                        if(this.get(start+step).weight>value.weight){  
	                            end=end-step;  
	                        }else if(this.get(start+step).weight<value.weight){  
	                            start=start+step;  
	                        }else{  
	                            this.add(start+step,value);  
	                            return;  
	                        }  
	                   }  
	  
	               if(value.weight>=this.get(end).weight){  
	                   index=end+1;  
	               }else if(value.weight<=this.get(start).weight){  
	                   index=start;  
	               }else  
	                   index=end;  
	           }  
	  
	           this.add(index,value);  
	  
	    }  
	  
	    public String toString(){  
	        String str="[";  
	        for(int j=0;j<this.size();j++){  
	            str+=this.get(j).weight+",";  
	        }  
	        str=str.substring(0, str.length()-1);  
	        str+="]";  
	        return str;  
	    }  
	  
	  
	  
	  
	}  
	  
	class HuffCode extends HashMap{  
	  
	    public String toString(){  
	        String str="";  
	        for(int i=0;i<this.size();i++){  
	            str+=this.get(i);  
	        }  
	        return str;  
	    }  

}
