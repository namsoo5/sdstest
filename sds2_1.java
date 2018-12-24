
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class sds2_1 {

	static List<Integer> missinfo;
	static int n;  //우주선수
	static int count =1;
	static int result =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long start = System.currentTimeMillis();
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();  //테스트케이스 수
		
		int m;  //미사일종류
		int b;  //방어막세기
		
		int a;
		int num;
		
		while(t>0) {
			missinfo = new ArrayList<Integer>(20000);
			n = scan.nextInt();
			m = scan.nextInt();
			b = scan.nextInt();

			for(int i=0; i<m; i++) {
				a = scan.nextInt();
				num = scan.nextInt();

				for(int j=0; j<num; j++) {
					missinfo.add(a); //미사일 위력만저장
				}
			}
			Collections.sort(missinfo);  //오름차순
			Collections.reverse(missinfo);  //내림차순

			broke(b, missinfo.size());
			//System.out.println("#"+count+" "+result);
			t--;
			count++;
			missinfo = null;
		}      

		scan.close();
		long end = System.currentTimeMillis();

		System.out.println("실행시간:" + (double)(end-start)/1000);
	}


	static void broke(int b, int size) {
	
		result=0;
		int a1= -1;
		int a2= -1;
		
			
		for(int i=size-1; i>=0; i--) {
			if( missinfo.get(0)+missinfo.get(1)<b) {
				result = -1;
				System.out.println("#"+count+" "+result);
				return;
			}
			if(n>0) {
				
				if(a1 == missinfo.get(i) || missinfo.get(i)==-1)  //전과같은수면 스킵
					continue;

				a1 = missinfo.get(i);
				System.out.println("a1: "+a1);
				if(a1>=b) {
					missinfo.set(i, -1);
					n--; 
					result += a1;
					continue;
				}else {
					for(int j=i-1; j>=0; j--) {
						if(n<=0)
							break;

						if(i==j || a1 == missinfo.get(j) || a2 == missinfo.get(j) || missinfo.get(j)==-1) {
							if(a1 + missinfo.get(j)<b)
								continue;
						}
						a2 = missinfo.get(j);
						System.out.println("a2: "+a2);
						if(a2>=b) {
							missinfo.set(j, -1);
							n--; 
							result += a2;
							break;
						}
						else if(a1+a2>=b) {
							missinfo.set(i, -1);
							missinfo.set(j, -1);
							n--; 
							result += (a1+a2);
							break;
						}
						System.out.println("result: "+result);

					}
				}
			}else
				break;
		}
		if(n>0)
			result = -1;

		System.out.println("#"+count+" "+result);
	}


}
