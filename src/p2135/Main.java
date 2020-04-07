package p2135;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static String RLE(String word) {
		int N = word.length();
		String temp;
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				if((N-j)<(j-i)) {
					break;
				}
				if(word.charAt(i) == word.charAt(j)) {
					if(word.substring(i, j).equals(word.substring(j, 2*j-i))) {
						temp = word.substring(i,j);
						int count = 2;
						int startIdx = 2*j-i;
						int length = j-i;
						int endIdx = startIdx + length;
						while(true) {
							if(endIdx>N) {
								endIdx -= length;
								break;
							}else {
								if(temp.equals(word.substring(startIdx, endIdx))){
									count++;
									startIdx += length;
									endIdx += length;
								}else {
									endIdx -= length;
									break;
								}
							}
						}
						
						if((word.substring(0, i)+count+"("+word.substring(i, j)+")"+word.substring(endIdx)).length() <= word.length() ) {
							return word.substring(0, i)+count+"("+RLE(word.substring(i, j))+")"+RLE(word.substring(endIdx));
						}
						return word.substring(0, endIdx)+RLE(word.substring(endIdx));
					}
				}
			}
		}
		return word;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		System.out.println(RLE(word));
	}

}
