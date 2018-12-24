import java.util.Scanner;

public class sds1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		StringBuffer str;
		StringBuffer s;
		int count = 1;
		int t = scan.nextInt();
		int n;
		
		while(t>0) {
			str = new StringBuffer();
			n = scan.nextInt();
			
			for(int i=0; i<n; i++) {
				if(i==0)
					str.append(scan.next());
				else{
			
					s = new StringBuffer(scan.next());
					
					if((byte)str.charAt(0) <= (byte)s.charAt(0)) {
						str.insert(0, s);
						continue;
					}else {
						str.append(s);
						continue;
					}
				}
				
			}
			System.out.println();
			
			
			System.out.println("#"+count+" "+str);
			count++;
			t--;
		}
		
	}

}
