package ap_assignment03;

public class word {
	protected class node {
		private String myWord;
		private int count;
		node next;
		
		node () {
			myWord=null;
			count=0;
			next=null;
		}
		
		node (String w) {
			myWord=w;
			count=0;
			next=null;
		}
	}
	
	node head;
	
	word(){
		head = new node();
	}
	
	word (String w){
		head = new node();
		head.myWord = w;
		head.count = 1;
	}
	
	public void addWord (String w) {
		if (head!=null) {
			head=new node(w);
		} else {
			node current = head;
			while (current.next!=null) {
				if (current.myWord==w) {
					current.count++;
					return;
				}
				current = current.next;
			}
			current.next=new node(w);
		}
		
	}
	
	public String getWord(String w) {
		node current = head;
		String temp = null;
		while (current.next!=null) {
			if (current.myWord==w)
				temp = current.myWord;
			current = current.next;
		}
		return temp;
	}
	
	public int getCount(String w) {
		node current = head;
		int num = 0;
		while (current.next!=null) {
			if (current.myWord==w)
				num = current.count;
			current = current.next;
		}
		return num;
	}
	
	public void incCount (String w) {
		node current = head;
		while (current.next!=null) {
			if (current.myWord==w)
				current.count++;
			current = current.next;
		}
	}
	
	public void displayWords() {
		node current = head;
		while (current.next!=null) {
			System.out.println(current.myWord);
			System.out.println(current.count);
			current = current.next;
		}
	}
	
}
