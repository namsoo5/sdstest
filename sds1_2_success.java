import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class sds1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int n;  //톨게이트통과한 차량수
		int m;  //존재할수있는 차량색상수
		int num;
		int count =1;
		int pos=0;
		boolean finish ;
		ArrayList<Integer> al;
		ArrayList<Integer> car;
		ArrayList<Integer> copy;
		while(t>0) {
			n = scan.nextInt();
			m = scan.nextInt();
			al = new ArrayList<Integer>();
			car = new ArrayList<Integer>();
			copy = new ArrayList<Integer>();
			finish = false;
			for(int i=0; i<m; i++) {
				num = scan.nextInt();
				for(int j=0; j<num; j++)
					al.add(i+1);  //차량색상저장
			}

			for(int i=0; i<n; i++) {
				car.add(scan.nextInt());			
			}

			System.out.println("al "+al);
			System.out.println("car: "+car);

			for(int i=0; i<car.size(); i++) {
				pos = i+1;
				for(int j=i; j<car.size(); j++) {
					if(copy.size()==al.size()) {
						Collections.sort(copy);
						Collections.sort(al);
						if(copy.equals(al)) {
							finish=true;
							break;
						}else {
							copy.clear();
							break;
						}
					}else if(al.contains(car.get(j))) {
						copy.add(car.get(j));
					}else {
						copy.clear();
						break;
					}
				}
				if(finish)
					break;
			}
			if(pos==car.size())
				pos=0;
			System.out.println("#"+count+" "+pos);
			count++;
			t--;
		}
	}

}
/*입력
3                                   
10 9                                 
2 0 1 0 0 0 1 0 0                       
1 2 8 7 1 3 1 1 2 5      
10 3       
2 2 2              
1 1 2 2 3 1 1 2 3 3              
3 3            
3 0 0             
1 2 3          

*/
/*출력

#1 4                                     
#2 4                                        
#3 0

*/