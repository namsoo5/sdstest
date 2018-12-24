import java.util.Scanner;

public class sds2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt(); //테스트수
		int n;
		int m;
		int k;
		int s;
		int karray[];//배달정보
		int marray[][];//도로정보
		int x, y;
		boolean checkarray[]; //방문정보
		int dis;
		int count=1;
		while(t>0) {
			n = scan.nextInt(); //모든마을수
			m = scan.nextInt(); //두마을연결하는도로수
			k = scan.nextInt(); //연아가배달해야하는마을수
			s = scan.nextInt(); //아르바이트하는가게있는마을번호
			dis=0;
			checkarray=  new boolean[n+1];

			karray = new int[k];
			for(int i=0; i<k; i++) {
				karray[i] = scan.nextInt();
			}

			marray = new int[m+1][m+1];
			//marray = new int[3001][3001];
			for(int i=0; i<m; i++) {
				x = scan.nextInt();
				y = scan.nextInt();

				marray[x][y] = 1;
				marray[y][x] = 1;  //양방향
			}

			int cpos = s;//현위치
			int go = 0; //배달마을
			for(int i=1; i<n+1; i++) {
				if(karray.length<=go) {
					if(marray[cpos][s]==1) {
						dis++;
						break;
					}else {
						for(int j=1; j<n+1; j++) {
							
							if(marray[j][s] == 1 && marray[cpos][j]==1) {
								dis+=2;
								cpos=karray[go];
								go++;
								break;
							}
						}
					}

				}
				else if(marray[cpos][karray[go]]==1 && !checkarray[karray[go]]) {
					
					cpos=karray[go];
					go++;
					dis++;
					continue;
				}else {
					for(int j=1; j<n+1; j++) {
						if(checkarray[j])
							continue;
						if(marray[j][karray[go]] == 1 && marray[cpos][j]==1) {
							dis+=2;
							cpos=karray[go];
							
							go++;
							break;

						}
					}
				}

			}

			System.out.println("#"+count+" "+dis);
			count++;
			t--;
			
		}

		scan.close();
	}

}

/* 입력
2
7 11 2 7
1 5 
1 2
4 5
6 1
3 4
5 3
3 6
7 6
6 2
7 2
3 1
5 7
10 13 3 9
4 5 2 
9 2
8 3
1 10
8 4
8 6
4 6
6 3
7 5
5 9
9 10
8 5
8 9
1 4
*/

/* 출력
#1 5
#2 7
*/