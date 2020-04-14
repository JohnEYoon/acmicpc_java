package p2135;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static String compress(String word) {
		System.out.println(word);
		ArrayList<String> cands = new ArrayList<String>(); 
		int N = word.length()/2;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<word.length();j++) {
				if((j+2*i) > word.length()) {
					break;
				}
				
				if(word.substring(j, j+i).equals(word.substring(j+i, j+2*i))) {
					int count = 2;
					String temp = word.substring(j, j+i);
					if(temp.charAt(0) == ')') {
						continue;
					}
					boolean safe = false;
					for(int k=0;k<temp.length();k++) {
						if(Character.isAlphabetic(temp.charAt(k))) {
							safe = true;
							break;
						}
					}
					
					if(!safe) {
						continue;
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
						cands.add(word.substring(0, j)+count+"("+temp+")"+word.substring(endIndex));
					}
					
				}
			}
		}
		int min = 200;
		if(cands.size() != 0) {
			for(String str : cands) {
				if(str.length() < min) {
					word = str;
					min = str.length();
				}
			}
			return compress(word);
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

