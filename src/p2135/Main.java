package p2135;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static boolean compressionCheck(String word) {
		for(int i=0;i<word.length()-1;i++) {
			int length = 0;
			for(int j=i+1;j<word.length();j++) {
				length = j-i;
				if(length+j > word.length()) {
					break;
				}
				if(word.charAt(i) == word.charAt(j)) {
					if(word.substring(i, j).equals(word.substring(j, j+length))){
						String temp = word.substring(i, j);
						int startIdx = j;
						int endIdx = j+length;
						int count = 2;
						while(endIdx+length<=word.length()) {
							if(temp.equals(word.substring(startIdx+length, endIdx+length))) {
								startIdx += length;
								endIdx += length;
								count++;
							}else {
								break;
							}
						}
						if(word.length() > (word.substring(0, i)+count+"("+temp+")"+word.substring(endIdx)).length()) {
							return true;
						}else {
							return false;
						}
					}
				}
			}
			
		}
		return false;
	}
	
	public static String RLE(String word) {
		for(int i=0;i<word.length()-1;i++) {
			int length = 0;
			for(int j=i+1;j<word.length();j++) {
				length = j-i;
				if(length+j > word.length()) {
					break;
				}
				if(word.charAt(i) == word.charAt(j)) {
					if(word.substring(i, j).equals(word.substring(j, j+length))){
						String temp = word.substring(i, j);
						int startIdx = j;
						int endIdx = j+length;
						int count = 2;
						while(endIdx+length<=word.length()) {
							if(temp.equals(word.substring(startIdx+length, endIdx+length))) {
								startIdx += length;
								endIdx += length;
								count++;
							}else {
								break;
							}
						}
						if(word.length() > (word.substring(0, i)+count+"("+temp+")"+word.substring(endIdx)).length()) {
							return word.substring(0, i)+count+"("+temp+")"+RLE(word.substring(endIdx));
						}else {
							return word.substring(0, endIdx)+RLE(word.substring(endIdx));
						}
					}
				}
			}
			
		}
		return word;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		while(compressionCheck(word)) {
			word = RLE(word);
		}
		System.out.println(word);
		System.out.println(word.length());
	}

}
