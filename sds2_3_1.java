import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class sds2_3 {


	static ArrayList<Integer> key;
	static ArrayList<Integer> alx;
	static ArrayList<Integer> aly;
	static ArrayList<Integer> alp;

	static Map<Integer, Integer> min;
	static Iterator<Integer> it ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start= System.currentTimeMillis();
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		int n;
		int x=0 ,y=0;
		int count=1;
		int nearx;
		int neary;
		
		while(t>0) {

			alx = new ArrayList<Integer>();
			aly = new ArrayList<Integer>();
			alp = new ArrayList<Integer>();
			key = new ArrayList<Integer>();
			
			min = new HashMap<Integer, Integer>();
			
			n = scan.nextInt();
			
			for(int i =0; i<n; i++) {
				x = scan.nextInt();
				y = scan.nextInt();
				

				alx.add(x);
				aly.add(y);
				alp.add(i+1);
			}

			nearx  =x;
			neary = y;
			
			for(int i =0; i<alx.size(); i++) {
				
				if(nearx < alx.get(i) && neary < aly.get(i))
				{
					continue;
				}else if(nearx == alx.get(i) && neary < aly.get(i)) {
					
					continue;
				}else if(neary == aly.get(i) && nearx < alx.get(i)) {
					
					continue;
				}else {
					if(nearx > alx.get(i) && neary > aly.get(i)) {
						nearx = alx.get(i);
						neary = aly.get(i);
					}
					min.put(alx.get(i), alp.get(i));
				}
				
			}
			
			it = min.keySet().iterator();
			
			while(it.hasNext()) {
				key.add(it.next());
			}
			
			Collections.sort(key);
			System.out.print("\n#"+count);
			for(int i=0; i<key.size(); i++) {
				System.out.print(" "+min.get(key.get(i)));
			}
			count++;
			t--;
		
		}		
		scan.close();
		long end= System.currentTimeMillis();
		System.out.println("실행시간:" + (double)(end-start)/1000);
	}
	
}
