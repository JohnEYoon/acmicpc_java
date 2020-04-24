package p1759;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int cand;
	static int use;
	static char alpha[];
	static char answ[];
	static int vCount = 0;
	static int cCount = 0;
	static char vowels[] = {'a', 'e', 'i', 'o', 'u'};
	
	public static boolean isVowel(char alphabet) {
		for(int i=0;i<5;i++) {
			if(alphabet == vowels[i]) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void BT(int idx) {
		//System.out.println("idx: "+ idx);
		if(idx == use) {
			if(vCount > 0 && cCount >1) {
				for(int i=1;i<=use;i++) {
					System.out.print(answ[i]);
				}
				System.out.println();
			}
		}else {
			for(int i=idx+1;i<=cand;i++) {
				if(isPossible(idx+1, alpha[i])) {
					if(isVowel(alpha[i])) {
						vCount++;
					}else {
						cCount++;
					}
					//System.out.println("i:"+i);
					
					answ[idx+1] = alpha[i];
					BT(idx+1);
					
					if(isVowel(alpha[i])) {
						vCount--;
					}else {
						cCount--;
					}
				}
			}
		}
		
	}
	
	public static boolean isPossible(int idx, char cand) {
		for(int i=1;i<idx;i++) {
			if(cand == answ[i]) {
				return false;
			}
			if(cand < answ[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		use = Integer.parseInt(st.nextToken());
		cand = Integer.parseInt(st.nextToken());
		
		alpha = new char[cand+1];
		answ = new char[use+1];
		
		st = new StringTokenizer(br.readLine()); 
		for(int i=1; i<=cand; i++) {
			alpha[i] = st.nextToken().toCharArray()[0];
		}
		Arrays.sort(alpha);
		BT(0);

	}

}
