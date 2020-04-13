package p2468;
import java.util.*;
import java.io.*;

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
static int N;
static int MAP[][];
static int FLOOD[][];
static int MAX = Integer.MIN_VALUE;
static int MIN = Integer.MAX_VALUE;
static ArrayList<Integer> NUMBS;
static int dx[] = {0, -1, 0, 1};
static int dy[] = {-1, 0, 1, 0};
static int answer = Integer.MIN_VALUE;
static Queue<Node> Land;

public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	N = Integer.parseInt(br.readLine());
	MAP = new int[N+1][N+1];
	FLOOD = new int[N+1][N+1];
	
	for(int i=1;i<=N;i++) {
		st = new StringTokenizer(br.readLine());
		for(int j=1;j<=N;j++) {
			MAP[i][j] = Integer.parseInt(st.nextToken());
			if(MAP[i][j]>MAX) {
				MAX = MAP[i][j];
			}
			if(MAP[i][j]<MIN) {
				MIN = MAP[i][j];
			}
		}
	}
	
	for(int i=MIN-1;i<=MAX;i++) {
		safeLand(i);
	}
	
	System.out.println(answer);
}

public static void safeLand(int level) {
	int tempAnswer = 0;
	Land = new LinkedList<Node>();
	
	for(int i=1;i<=N;i++) {
		for(int j=1;j<=N;j++) {
			if(MAP[i][j]>level) {
				FLOOD[i][j] = 0;
			}else {
				FLOOD[i][j] = 1;
			}
		}
	}
	for(int i=1;i<=N;i++) {
		for(int j=1;j<=N;j++) {
			if(FLOOD[i][j] == 0) {
				Land.offer(new Node(i,j));
				FLOOD[i][j] = 1;
				tempAnswer++;
				DFS(i, j);
				//BFS();
			}
		}
	}
	if(tempAnswer > answer) {
		answer = tempAnswer;
	}
}

public static void BFS() {
	while(!Land.isEmpty()) {
		Node land = Land.poll();
		for(int k=0;k<4;k++) {
			int nx = land.x+dx[k];
			int ny = land.y+dy[k];
			if(nx>0 && nx<N+1 && ny>0 && ny<N+1) {
				if(FLOOD[nx][ny]==0) {
					FLOOD[nx][ny] = 1;
					Land.offer(new Node(nx, ny));
				}
			}
		}
		
	}
}

public static void DFS(int x, int y) {
	for(int k=0;k<4;k++) {
		int nx = x+dx[k];
		int ny = y+dy[k];
		if(nx>0 && nx<N+1 && ny>0 && ny<N+1) {
			if(FLOOD[nx][ny]==0) {
				FLOOD[nx][ny] = 1;
				DFS(nx, ny);
			}
		}
	}
}

}
