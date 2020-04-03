package dynamic_programming.p1149;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] values;
	public static int N;
	public static long min = Long.MAX_VALUE;
	
	public static void DFS(int index, int color, long val) {
		if(index == N ) {
			if(val < min) {
				min = val;
			}
		}
		if(val >= min) {
			return;
		}
		for(int i=0;i<3;i++) {
			if(i != color) {
				DFS(index+1, i, val+values[index+1][i]);
			}
		}
		
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		values = new int[N+1][3];
		StringTokenizer st;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				values[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(0,-1,0);
		System.out.println(min);
	}

}
