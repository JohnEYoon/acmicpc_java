package p2493;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
		static int N;
		static int towers[];
		static int get[];
	
	public static void raider() {	
		for(int i=N; i>=2;i--) {
			int height = towers[i];
			for(int j=i-1;j>=1;j--) {
				if(height <= towers[j]) {
					get[i] = j;
					break;
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		towers = new int[N+1];
		get = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=N;i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}

		raider();
		
		for (int i=1 ; i<=N ; i++) {
			//System.out.println(get[i]+" ");
			bw.write(get[i]+" ");
		}
		//bw.write("\n");
	}

}