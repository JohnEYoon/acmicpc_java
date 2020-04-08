package p5214;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
	static int N;//총 역수
	static int K;//링크 연결 역수
	static int M;//링크 수
	static int LINK[][];
	static int MAP[][];
	public static int minDistance() {
		for(int i=1;i<=M;i++) {
			for(int j=1;j<=K;j++) {
				for(int k=1;k<=K;k++) {
					if(j==k) {
						MAP[LINK[i][j]][LINK[i][k]] = 0;
					}else {
						MAP[LINK[i][j]][LINK[i][k]] = 1;
					}
				}
			}
		}
		
		
		for(int j=1;j<=N;j++) {
			for(int k=1;k<=N;k++) {
				System.out.print(MAP[j][k]+" ");
			}
			System.out.println();
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		LINK = new int[M+1][K+1];
		MAP = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			Arrays.fill(MAP[i], Integer.MAX_VALUE);
		}
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=K;j++) {
				LINK[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minDistance();
	}
}