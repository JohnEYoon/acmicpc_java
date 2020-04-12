package p2468;
import java.util.*;
import java.io.*;

class Node{
	int x;
	int y;
	int id;
	
	public Node(int x, int y, int id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.id = 0;
	}
}


public class Main {
	static int N;
	static int MAP[][];
	static int FLOOD[][];
	static int MAX = Integer.MIN_VALUE;
	static ArrayList<Integer> NUMBS;
	static int dx[] = {0, -1, 0, 1};
	static int dy[] = {-1, 0, 1, 0};
	
	public static void printMap() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				System.out.print(FLOOD[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		MAP = new int[N+1][N+1];
		FLOOD = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
				if(MAP[i][j] > MAX) {
					MAX = MAP[i][j];
				}
			}
		}
		BFS();
		
	}
	
	private static void BFS() {
		int countMax = Integer.MIN_VALUE;
		for(int i=1;i<MAX;i++) {
			NUMBS = new ArrayList<Integer>();
			Queue<Node> Land = new LinkedList<Node>();
			int newId = 1;
			//System.out.println("level"+i+": ");
			for(int j=1;j<=N;j++) {
				Arrays.fill(FLOOD[j], 0);
				for(int k=1;k<=N;k++) {
					if(MAP[j][k] > i) {
						Land.add(new Node(j,k,newId));
						FLOOD[j][k] = newId++;
					}
				}
			}
			//printMap();
			while(!Land.isEmpty()){
				Node land = Land.poll();
				int id = land.id;
				
				if(FLOOD[land.x][land.y]!=id) {
					continue;
				}
				for(int d=0;d<4;d++) {
					int newX = land.x+dx[d];
					int newY = land.y+dy[d];
					if(newX>0 && newX<N+1 && newY>0 && newY<N+1) {
						if(FLOOD[newX][newY] != 0) {
							if(FLOOD[newX][newY] > id) {
								FLOOD[newX][newY] = id;
								Land.offer(new Node(newX, newY, id));
							}
						}
					}
				}
			}
			
			for(int j=1;j<=N;j++) {
				for(int k=1;k<=N;k++) {
					if(FLOOD[j][k] > 0 && !NUMBS.contains(FLOOD[j][k])) {
						NUMBS.add(FLOOD[j][k]);
					}
				}
			}
			//System.out.println(NUMBS.size());
			if(NUMBS.size()>countMax) {
				countMax= NUMBS.size();
			}
			//printMap();
		}
		
		 
		 
		System.out.println(countMax);
	}

}
