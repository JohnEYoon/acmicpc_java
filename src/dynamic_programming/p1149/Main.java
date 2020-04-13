package dynamic_programming.p1149;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] values;
	public static long[][] MEMO;
	public static int N;
	public static long min = Long.MAX_VALUE;
	
	public static void DFS(int index) {
		if(index == N ) {
			for(int i=1;i<=3;i++) {
				if(MEMO[index][i]<min) {
					min = MEMO[index][i];
				}
			}	
			return;
		}
		
		for(int i=1;i<=3;i++) {
			int x1, x2;
			if(i == 1) {
				x1 = 2;
				x2 = 3;
			}else if(i==2) {
				x1 = 1;
				x2 = 3;
			}else {
				x1 = 1;
				x2 = 2;
			}
			
			MEMO[index+1][i] = Math.min(MEMO[index][x1]+values[index+1][i], MEMO[index][x2]+values[index+1][i]);
		}
		DFS(index+1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		values = new int[N+1][4];
		MEMO = new long[N+1][4];
		StringTokenizer st;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=3;j++) {
				values[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		MEMO[1][1] = values[1][1];
		MEMO[1][2] = values[1][2];
		MEMO[1][3] = values[1][3];
		
		DFS(1);
		System.out.println(min);
	}

}
