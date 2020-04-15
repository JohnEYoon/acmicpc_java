package p2135;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static String compress(String word) {
		int N = word.length()/2;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<word.length();j++) {
				if((j+2*i) > word.length()) {
					break;
				}
				
				if(word.substring(j, j+i).equals(word.substring(j+i, j+2*i))) {
					int count = 2;
					String temp = word.substring(j, j+i);
					boolean safe = false;
					for(int k=0;k<temp.length();k++) {
						if(Character.isAlphabetic(temp.charAt(k))) {
							safe = true;
							break;
						}
					}
					
					if(!safe) {
						break;
					}
					int beginIndex = j+i;
					int endIndex = j+2*i;
					while(endIndex+i<=word.length()) {
						if(temp.equals(word.substring(beginIndex+i, endIndex+i))) {
							beginIndex += i;
							endIndex += i;
							count++;
						}else {
							break;
						}
					}
					if( (word.substring(0, j)+count+"("+temp+")"+word.substring(endIndex)).length() < word.length() ) {
						return compress(word.substring(0, j)+count+"("+temp+")"+word.substring(endIndex));
					}
					
				}
			}
		}
		
		return word;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		word = compress(word);
		System.out.println(word.length());
	}

}
