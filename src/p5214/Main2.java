package p5214;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
	static int N; //역의 개수
	static int K; //연결 역의 수
	static int M; // 전체 튜브 수
	static int LINK[][];
	static int MAP[][];
	static int DIST[];
	public static int minDistance() {
		for(int i=2;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				DIST[i] = Math.min(DIST[i], DIST[j]+MAP[j][i]);
			}
		}
		return DIST[N]+1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		LINK = new int[M+1][K+1];
		MAP = new int[N+1][N+1];
		DIST = new int[N+1];
		Arrays.fill(DIST, N+1);
		DIST[1] = 0;
		for(int i=1;i<=N;i++) {
			Arrays.fill(MAP[i], N+1);
		}
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=K;j++) {
				LINK[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
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
		LINK = new int[1][1];
		System.out.println(minDistance());
	}
}