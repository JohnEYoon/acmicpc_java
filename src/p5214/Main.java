package p5214;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;//총 역수
	static int K;//링크 연결 역수
	static int M;//링크 수
	static int MAP[][];
	static int VISIT[];
	static int MIN;
	static boolean found = false;
	public static void minDistance(int distance, int location) {
		if(location == N) {
			if(distance < MIN) {
				MIN=distance;
				found = true;
				return;
			}
		}else if(distance+1 < MIN) {
			for(int i=1;i<=M;i++) {
				if(VISIT[i] == 0) {
					boolean contains = false;
					for(int j=1;j<=K;j++) {
						if(MAP[i][j] == location) {
							contains = true;
							break;
						}
					}
					if(contains) {
						VISIT[i] = 1;
						for(int j=1;j<=K;j++) {
							if(MAP[i][j] != location) {
								minDistance(distance+1, MAP[i][j]);
							}
						}
						VISIT[i] = 0;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		MIN = M+1;
		MAP = new int[M+1][K+1];
		VISIT = new int[M+1];
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=K;j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minDistance(1,1);
		if(!found) {
			MIN = -1;
		}
		System.out.println(MIN);
	}
}
