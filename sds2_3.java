import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class sds2_3 {

	static ArrayList<Pos> al;
	static ArrayList<Integer> key;
	static Map<Integer, Pos> min;
	static Iterator<Integer> it ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		int n;
		int x ,y;
		int count=1;
		int nearx;
		int neary;
		
		while(t>0) {
			al = new ArrayList<Pos>();
			key = new ArrayList<Integer>();
			min = new HashMap<Integer, Pos>();
			
			n = scan.nextInt();
			
			for(int i =0; i<n; i++) {
				x = scan.nextInt();
				y = scan.nextInt();
				
				al.add(new Pos(x,y,i+1));
			}
			
			nearx = al.get(n-1).x;
			neary = al.get(n-1).y;
			
			for(int i =0; i<al.size(); i++) {
				
				if(nearx < al.get(i).x && neary < al.get(i).y)
				{
					continue;
				}else if(nearx == al.get(i).x && neary < al.get(i).y) {
					
					continue;
				}else if(neary == al.get(i).y && nearx < al.get(i).x) {
					
					continue;
				}else {
					if(nearx > al.get(i).x && neary > al.get(i).y) {
						nearx = al.get(i).x;
						neary = al.get(i).y;
					}
					min.put(al.get(i).x, al.get(i));
				}
				
			}
			
			it = min.keySet().iterator();
			
			while(it.hasNext()) {
				key.add(it.next());
				
			}
			
			Collections.sort(key);
			System.out.print("\n#"+count);
			for(int i=0; i<key.size(); i++) {
				System.out.print(" "+min.get(key.get(i)).pos);
			}
			count++;
			t--;
		}		
		scan.close();
	}
	
	public static class Pos{
		int pos;
		int x;
		int y;
		public Pos(int x, int y, int pos) {
			this.pos = pos;
			this.x = x;
			this.y = y;
		}
	}

}
