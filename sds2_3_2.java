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
	//static Iterator<Integer> it ;
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
					}else if(nearx == alx.get(i) && neary > aly.get(i))
					{
						nearx = alx.get(i);
						neary = aly.get(i);
					}else if(neary == aly.get(i) && nearx < alx.get(i))
					{
						nearx = alx.get(i);
						neary = aly.get(i);
					}
					if(min.containsKey(alx.get(i))) {
						if( aly.get(min.get(alx.get(i))-1) < aly.get(i)) {
							System.out.println("현재y값: "+aly.get(i));
							continue;
						}
						min.put(alx.get(i), alp.get(i));
						continue;
					}
					min.put(alx.get(i), alp.get(i));
					key.add(alx.get(i));
					
				}
				
			}
			
			Collections.sort(key);
			System.out.print("\n#"+count);
			for(int num : key) {
				System.out.print(" "+min.get(num));
			}
			count++;
			t--;
		
		}		
		scan.close();
		long end= System.currentTimeMillis();
		System.out.println("실행시간:" + (double)(end-start)/1000);
	}
	
}
/* 입력

3            ← 총 3개의 테스트 케이스가 있다는 뜻    
4            ← 1번 케이스  
1 5  
2 4  
3 5  
4 7  
8            ← 2번 케이스  
7 3  
12 1  
2 9  
11 7  
7 2  
4 3  
9 4  
5 5  
10           ← 3번 케이스
45 62  
60 60  
21 22  
55 56  
41 9  
70 37  
68 74  
58 42  
32 68  
22 35  

*/

/*출력

#1 1 2  
#2 3 6 5 2  
#3 3 5
*/