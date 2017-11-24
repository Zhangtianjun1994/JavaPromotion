package crazyjava.eleventh.redblack;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import crazyjava.eleventh.SortedBinTree.Node;

public class RedBlackTree <T extends Comparable>{

	//������������ɫ
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	
	static class Node{
		Object data;
		Node parent;
		Node right;
		Node left;
		//�ڵ�Ĭ���Ǻ�ɫ
		boolean color = BLACK;//true�����Ǻ�ɫ��false�����Ǻ�ɫ
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
	
	//�������������ڹ������������
	public RedBlackTree(){
		root = null;
	}
	
	public RedBlackTree(T o){
		root = new Node(o,null,null,null);
	}
	
	//��ӽڵ�
	public void add(T ele){
		//������ڵ�Ϊnull
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
	//����ڵ����޸�����
	private void fixAfterInsertion(Node x){
		x.color = RED;
		//ֱ��xΪ�ջ���xΪroot������x�ĸ��ڵ����ɫ���Ǻ�ɫ
		while(x != null && x != root && x.parent.color == RED){
			//��������һֱ����ѭ��
			//��x�ĸ��ڵ���x��үү�ڵ�����ӵ�ʱ��
			if(parentOf(x) == leftOf(parentOf(parentOf(x)))){
				//���������
				//��ȡx�ĸ��ڵ���ֵܽڵ�
				Node y = rightOf(parentOf(parentOf(x)));
				//case 3:x�ĸ��ڵ���ֵܽڵ��Ǻ�ɫ
				if(colorOf(y) == RED){
					//������ɫ
					setColor(y, BLACK);
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					x = parentOf(parentOf(x));
				}
				// case 4 && 5:���ֵܽڵ���ɫʹ��ɫ
				else{
					//case 4:��x�����ĸ��ڵ���Һ���,����������Ȼ�����5����
					if(x == rightOf(parentOf(x))){
						x = parentOf(x);
						rotateLeft(x);
					}
					//case 5:��ִ�������4����� ����û��ִ�����4ֱ�ӽ��룬��Ҫ��ɫ������
					setColor(parentOf(x), BLACK);//x�ĸ��ڵ�������ɫ��ɫ
					setColor(parentOf(parentOf(x)), RED);//x��үү�ڵ�����Ϊ��ɫ
					rotateRight(parentOf(parentOf(x)));//��үү�ڵ�Ϊ��������
				}
			}
			//��x�ĸ��ڵ���x��үү�ڵ���Һ��ӵ�ʱ��
			else{
				//����ֵܽڵ�
				Node y = leftOf(parentOf(parentOf(x)));
				if(colorOf(y) == RED){//case 3
					setColor(parentOf(x), BLACK);
					setColor(y, BLACK);
					setColor(parentOf(parentOf(x)),RED);
					x = parentOf(parentOf(x));
				}
				else{//case 4&&5
					//���x�����ĸ��ڵ�����ӣ�����case 4������������Ȼ��ִ��case 5��
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
		///�����ڵ�����Ϊ��ɫ
		setColor(root, BLACK);
	}
	
	
	//��ȡָ���ڵ����ɫ
	private boolean colorOf(Node node){
		return (node == null ? BLACK : node.color);
	}
	
	//��ȡָ���ڵ�ĸ��ڵ�
	private Node parentOf(Node node){
		return (node == null ? null : node.parent);
	}
	
	//δָ���ڵ�������ɫ
	private void setColor(Node node,boolean c){
		if(node != null){
			node.color = c;
		}
	}
	
	//��ȡָ���ڵ����ڵ�
	private Node leftOf(Node node){
		return (node == null ? null:node.left);
	}
	
	//��ȡָ���ڵ���нڵ�
	private Node rightOf(Node node){
		return (node == null ? null:node.right);
	}
	
	/*
	 * ִ������ת��
	 * p  r
	 * r  p
	 * q  q
	 */
	private void rotateLeft(Node p){
		if(p != null){
			Node r = p.right;
			Node q = r.left;
			//��r����ڵ�ҵ�p���нڵ���
			p.right = q;
			//r����ڵ��parentָ��p
			if(q != null){
				q.parent = p;
			}
			r.parent = p.parent;
			//����ڵ�p�Ѿ��Ǹ��ڵ�
			if(p.parent == null){
				root = r;
			}
			//���p���丸�ڵ����ڵ�
			else if(p == p.parent.left){
				p.parent.left = r;
			}else{
				p.parent.right = r;
			}
			p.parent = r;
			r.left = p;
		}
	}
	//��������
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
	
	//ʵ���������
	public List<Node> inIterator(){
		return inIterator(root);
	}
	
	public List<Node> inIterator(Node node){
		List<Node > list  = new ArrayList<Node>();
		//�۹�����������
		if(node.left != null)
			list.addAll(inIterator(node.left));
		list.add(node);
		if(node.right != null){
			list.addAll(inIterator(node.right));
		}
		return list;
	}
	

	
	//�����������
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
					//System.out.println("����"+node.leftChild.path);
				}
				if(node.right != null){
					//node.rightChild.path = node.path+"1";
					queue.offer(node.right);
				}
			}
			return list;
		}
	
	//�����Ӧ�Ľڵ�
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
	
	
	
	//ɾ���ڵ�
	public void remove(T ele){
		Node target = getNode(ele);
		if(target.left != null && target.right != null){
			//���������Ҫ�ҵ������������ֵ��Ϊ�滻�ڵ㣬��������һ���ӽڵ��û���ӽڵ�����������ֱ���ҵ��滻�ڵ�
			Node s = target.left;
			while(s.right != null){
				s = s.right;
			}
			target.data = s.data;//���滻�ڵ��е�ֵ���滻Ŀ��ڵ��ֵ
			target = s;
		}
		//�ҵ��滻�ڵ�
		Node replacement = (target.left != null ? target.left:target.right);
		//������ӽڵ㣬replacement����null
		if(replacement != null){
			replacement.parent = target.parent;
			//���target.parentΪnull����ʾtargetΪ���ڵ�
			if(target.parent == null){//ɾ���Ľڵ��Ǹ��ڵ㣬�������滻�ڵ�
				root = replacement;
			}
			else if(target.parent.left == target){
				target.parent.left = replacement;
			}else{
				target.parent.right = replacement;
			}
			//����ɾ��target
			target.right = target.left= target.parent = null;
			if(target.color = BLACK){//���ɾ�����Ǻ�ɫ�ڵ㣬��Ҫ���������
				fixAfterDeletion(replacement);
			}
		}else if(target.parent == null){//ɾ���ýڵ��Ǹ��ڵ㣬����û���滻�ڵ�
			root = null;
		}else{
			//û���滻�ڵ�������targetû�к��ӵ����
			//���ɾ���ڵ��Ǻ�ɫ����ô��Ҫ����,�ȵ���֮����ɾ��
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
	
	//ɾ���ڵ���޸������
	private void fixAfterDeletion(Node x){
		//ֱ��x��λ�գ���x����ɫΪ��ɫ
				while(x != null && colorOf(x) == BLACK){
					//���x���丸�ڵ����ڵ�
					if(x == leftOf(parentOf(x))){
						//��ȡx�ֵܽڵ�
						Node sib = rightOf(parentOf(x));
						///���sib�ڵ�Ϊ��ɫ
						if(colorOf(sib) == RED){
							setColor(sib, BLACK);
							setColor(parentOf(x), RED);
							rotateLeft(parentOf(x));
							sib = rightOf(parentOf(x));
						}
						//���sib�������ӽڵ����ɫ���Ǻ�ɫ��
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
					//���x���丸�ڵ���ҽڵ�
					else{
						Node sib = leftOf(parentOf(x));
						if(colorOf(sib) == RED){
							setColor(sib, BLACK);
							setColor(parentOf(x), RED);
							rotateRight(parentOf(x));
							sib = leftOf(parentOf(x));
						}
						//���sib�������ӽڵ����ɫ���Ǻ�ɫ��
						if(colorOf(leftOf(sib)) == BLACK && colorOf(rightOf(sib)) == BLACK){
							setColor(sib, RED);
							x = parentOf(x);
						}
						else{
							if(colorOf(rightOf(sib)) == BLACK){//��ֶ�ӽڵ�Ϊ��
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
				///�����ڵ�����Ϊ��ɫ
				setColor(x, BLACK);
	}
}
