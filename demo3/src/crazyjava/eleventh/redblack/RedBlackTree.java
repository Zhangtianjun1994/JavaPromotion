package crazyjava.eleventh.redblack;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import crazyjava.eleventh.SortedBinTree.Node;

public class RedBlackTree <T extends Comparable>{

	//定义红黑树的颜色
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	
	static class Node{
		Object data;
		Node parent;
		Node right;
		Node left;
		//节点默认是黑色
		boolean color = BLACK;//true代表是黑色，false代表是红色
		public Node(Object data,Node parent,Node left,Node right){
			this.data = data;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		
		public String toString(){
			return "[data="+data+",color="+color+"]";
		}
		
		public boolean equals(Object obj){
			if(this == obj)
				return true;
			if(obj.getClass() == Node.class){
				Node node = (Node)obj;
				if(node.data.equals(this.data)&&node.parent==this.parent
						&&node.left ==this.left&& node.right ==this.right)
					return true;
			}
			return false;
		}
	}
	
	private Node root;
	public Node getRoot(){
		return root;
	}
	
	//两个构造器用于构建排序二叉树
	public RedBlackTree(){
		root = null;
	}
	
	public RedBlackTree(T o){
		root = new Node(o,null,null,null);
	}
	
	//添加节点
	public void add(T ele){
		//如果根节点为null
		if(root == null){
			root = new Node(ele,null,null,null);
		}else{
			Node current = root;
			Node parent = null;
			int cmp = 0;
			do{
				parent = current;
				cmp = ele.compareTo((T) current.data);
				if(cmp > 0){
					current = current.right;
				}
				else{
					current = current.left;
				}
			}while(current!=null);
			Node newNode = new Node(ele,parent,null,null);
			if(cmp > 0){
				parent.right = newNode;
			}else{
				parent.left = newNode;
			}
			fixAfterInsertion(newNode);
		}
	}
	//插入节点后的修复工作
	private void fixAfterInsertion(Node x){
		x.color = RED;
		//直到x为空或者x为root，或者x的父节点的颜色不是红色
		while(x != null && x != root && x.parent.color == RED){
			//满足条件一直进行循环
			//当x的父节点是x的爷爷节点的左孩子的时候
			if(parentOf(x) == leftOf(parentOf(parentOf(x)))){
				//分三种情况
				//获取x的父节点的兄弟节点
				Node y = rightOf(parentOf(parentOf(x)));
				//case 3:x的父节点的兄弟节点是红色
				if(colorOf(y) == RED){
					//重新上色
					setColor(y, BLACK);
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					x = parentOf(parentOf(x));
				}
				// case 4 && 5:当兄弟节点颜色使黑色
				else{
					//case 4:当x是他的父节点的右孩子,进行左旋，然后按情况5处理
					if(x == rightOf(parentOf(x))){
						x = parentOf(x);
						rotateLeft(x);
					}
					//case 5:当执行完情况4后进入 或者没有执行情况4直接进入，需要着色和右旋
					setColor(parentOf(x), BLACK);//x的父节点重新着色黑色
					setColor(parentOf(parentOf(x)), RED);//x的爷爷节点重新为红色
					rotateRight(parentOf(parentOf(x)));//以爷爷节点为中心右旋
				}
			}
			//当x的父节点是x的爷爷节点的右孩子的时候
			else{
				//获得兄弟节点
				Node y = leftOf(parentOf(parentOf(x)));
				if(colorOf(y) == RED){//case 3
					setColor(parentOf(x), BLACK);
					setColor(y, BLACK);
					setColor(parentOf(parentOf(x)),RED);
					x = parentOf(parentOf(x));
				}
				else{//case 4&&5
					//如果x是他的父节点的左孩子，按照case 4：进行右旋，然后执行case 5：
					if(x == leftOf(parentOf(x))){
						x = parentOf(x);
						rotateRight(x);
					}
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					rotateLeft(parentOf(parentOf(x)));
				}
			}
		}
		///将根节点设置为黑色
		setColor(root, BLACK);
	}
	
	
	//获取指定节点的颜色
	private boolean colorOf(Node node){
		return (node == null ? BLACK : node.color);
	}
	
	//获取指定节点的父节点
	private Node parentOf(Node node){
		return (node == null ? null : node.parent);
	}
	
	//未指定节点设置颜色
	private void setColor(Node node,boolean c){
		if(node != null){
			node.color = c;
		}
	}
	
	//获取指定节点的左节点
	private Node leftOf(Node node){
		return (node == null ? null:node.left);
	}
	
	//获取指定节点的有节点
	private Node rightOf(Node node){
		return (node == null ? null:node.right);
	}
	
	/*
	 * 执行如下转换
	 * p  r
	 * r  p
	 * q  q
	 */
	private void rotateLeft(Node p){
		if(p != null){
			Node r = p.right;
			Node q = r.left;
			//将r的左节点挂到p的有节点上
			p.right = q;
			//r的左节点的parent指向p
			if(q != null){
				q.parent = p;
			}
			r.parent = p.parent;
			//如果节点p已经是根节点
			if(p.parent == null){
				root = r;
			}
			//如果p是其父节点的左节点
			else if(p == p.parent.left){
				p.parent.left = r;
			}else{
				p.parent.right = r;
			}
			p.parent = r;
			r.left = p;
		}
	}
	//右旋操作
	private void rotateRight(Node p){
		if(p != null){
			Node l = p.left;
			Node q = l.right;
			
			p.left = q;
			if(q != null){
				q.parent = p;
			}
			l.parent = p.parent;
			if(p.parent == null){
				root = l;
			}else if(p == p.parent.left){
				p.parent.left = l;
			}else{
				p.parent.right = l;
			}
			p.parent = l;
			l.right = p;
		}
	}
	
	//实现中序遍历
	public List<Node> inIterator(){
		return inIterator(root);
	}
	
	public List<Node> inIterator(Node node){
		List<Node > list  = new ArrayList<Node>();
		//帝国处理左子树
		if(node.left != null)
			list.addAll(inIterator(node.left));
		list.add(node);
		if(node.right != null){
			list.addAll(inIterator(node.right));
		}
		return list;
	}
	

	
	//广度优先搜索
	public List<Node> breadthFirst(Node root){
			Queue<Node> queue = new ArrayDeque<Node>();
			List<Node> list = new ArrayList<Node>();
			if(root != null){
				queue.offer(root);
				//root.path="";
			}
			while(!queue.isEmpty()){
				Node node = queue.poll();
				list.add(node);
				if(node.left != null){
					//node.leftChild.path=node.path+"0";
					queue.offer(node.left);
					//System.out.println("测试"+node.leftChild.path);
				}
				if(node.right != null){
					//node.rightChild.path = node.path+"1";
					queue.offer(node.right);
				}
			}
			return list;
		}
	
	//获得相应的节点
	public Node getNode(T ele){
			Node p = root;
			while(p!= null){
				int cmp = ele.compareTo((T) p.data);
				if(cmp > 0)
					p = p.right;
				else if(cmp < 0)
					p= p.left;
				else
					return p;
			}
			return null;
		}
	
	
	
	//删除节点
	public void remove(T ele){
		Node target = getNode(ele);
		if(target.left != null && target.right != null){
			//这种情况需要找到左子树的最大值作为替换节点，其他当有一个子节点和没有子节点的情况，可以直接找到替换节点
			Node s = target.left;
			while(s.right != null){
				s = s.right;
			}
			target.data = s.data;//拿替换节点中的值来替换目标节点的值
			target = s;
		}
		//找到替换节点
		Node replacement = (target.left != null ? target.left:target.right);
		//如果有子节点，replacement不是null
		if(replacement != null){
			replacement.parent = target.parent;
			//如果target.parent为null，表示target为根节点
			if(target.parent == null){//删除的节点是根节点，但是有替换节点
				root = replacement;
			}
			else if(target.parent.left == target){
				target.parent.left = replacement;
			}else{
				target.parent.right = replacement;
			}
			//彻底删除target
			target.right = target.left= target.parent = null;
			if(target.color = BLACK){//如果删除的是黑色节点，需要调整红黑树
				fixAfterDeletion(replacement);
			}
		}else if(target.parent == null){//删除得节点是根节点，但是没有替换节点
			root = null;
		}else{
			//没有替换节点的情况，target没有孩子的情况
			//如果删除节点是黑色，那么需要调整,先调整之后再删除
			if(target.color == BLACK){
				fixAfterDeletion(target);
			}
			if(target.parent != null){
				if(target == target.parent.left){
					target.parent.left = null;
				}
				else if(target.parent.right == target){
					target.parent.right = null;
				}
				target.parent = null;
			}
		}
		
	}
	
	//删除节点后修复红黑树
	private void fixAfterDeletion(Node x){
		//直到x部位空，且x的颜色为黑色
				while(x != null && colorOf(x) == BLACK){
					//如果x是其父节点的左节点
					if(x == leftOf(parentOf(x))){
						//获取x兄弟节点
						Node sib = rightOf(parentOf(x));
						///如果sib节点为红色
						if(colorOf(sib) == RED){
							setColor(sib, BLACK);
							setColor(parentOf(x), RED);
							rotateLeft(parentOf(x));
							sib = rightOf(parentOf(x));
						}
						//如果sib的两个子节点的颜色都是黑色的
						if(colorOf(leftOf(sib)) == BLACK && colorOf(rightOf(sib)) == BLACK){
							setColor(sib, RED);
							x = parentOf(x);
						}
						else{
							if(colorOf(rightOf(sib)) == BLACK){
								setColor(leftOf(sib), BLACK);
								setColor(sib, RED);
								rotateRight(sib);
								sib = rightOf(parentOf(x));
							}
							setColor(sib, colorOf(parentOf(x)));
							setColor(parentOf(x), BLACK);
							setColor(rightOf(sib), BLACK);
							rotateLeft(parentOf(x));
							//x= root;
						}
					}
					//如果x是其父节点的右节点
					else{
						Node sib = leftOf(parentOf(x));
						if(colorOf(sib) == RED){
							setColor(sib, BLACK);
							setColor(parentOf(x), RED);
							rotateRight(parentOf(x));
							sib = leftOf(parentOf(x));
						}
						//如果sib的两个子节点的颜色都是黑色的
						if(colorOf(leftOf(sib)) == BLACK && colorOf(rightOf(sib)) == BLACK){
							setColor(sib, RED);
							x = parentOf(x);
						}
						else{
							if(colorOf(rightOf(sib)) == BLACK){//近侄子节点为红
								setColor(rightOf(sib), BLACK);
								setColor(sib, RED);
								rotateLeft(sib);
								sib = leftOf(parentOf(x));
							}
							setColor(sib, colorOf(parentOf(x)));
							setColor(parentOf(x), BLACK);
							setColor(leftOf(sib), BLACK);
							rotateRight(parentOf(x));
							//x= root;
						}
					}
				}
				///将根节点设置为黑色
				setColor(x, BLACK);
	}
}
