
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class sds2_1 {

	static Map<Integer, Integer> missinfo;
	static ArrayList<Integer> al;
	static int n;  //우주선수
	static int count =1;
	static int result =0;
	static Iterator<Integer> key;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long start = System.currentTimeMillis();
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();  //테스트케이스 수

		int m;  //미사일종류
		int b;  //방어막세기
		int a;
		int num;

		int result;

		while(t>0) {
			result = 0;
			al = new ArrayList<Integer>();
			missinfo = new HashMap<Integer, Integer>();
			n = scan.nextInt();
			m = scan.nextInt();
			b = scan.nextInt();


			for(int i=0; i<m; i++) {
				a = scan.nextInt();
				num = scan.nextInt();

				missinfo.put(a, num);
			}
			key = missinfo.keySet().iterator();

			while(key.hasNext()) {
				al.add(key.next());
			}

			Collections.sort(al);

			for(int i=0; i<missinfo.size(); i++) {
				if(n==0)
					break;
				if(missinfo.get(al.get(i))<=0){
					continue;
				}
	
				if(al.get(i)>=b && missinfo.get(al.get(i))>0) {
					missinfo.put(al.get(i), missinfo.get(al.get(i))-1);
					n--;
					result += al.get(i);
					
					continue;
				}else{
					for(int j=i+1; j<missinfo.size(); j++) {
					
						if(n==0)
							break;
						else if(al.get(j)>=b && (missinfo.get(al.get(j))>0)) {
							missinfo.put(al.get(j), missinfo.get(al.get(j))-1);
							n--;
							result += al.get(j);
							
							break;
						}
						else if(al.get(i)+al.get(j)>=b && missinfo.get(al.get(i))>0 &&missinfo.get(al.get(j))>0) {
							missinfo.put(al.get(i), missinfo.get(al.get(i))-1);
							missinfo.put(al.get(j), missinfo.get(al.get(j))-1);
							n--;
							result += al.get(i)+al.get(j);

							break;
						}
					}
				}
			}
			if(n>0)
				result = -1;
			long end = System.currentTimeMillis();
			System.out.println("#"+count+" "+result);
			System.out.println("실행시간:" + (double)(end-start)/1000);
			count++;
			t--;
		}
		scan.close();

	}
}
/*입력

2
2 3 10
6 1
4 1
12 2
2 4 10
3 3
5 1
1 5
10 1

*/
/*출력

#1 22
#2 -1

*/