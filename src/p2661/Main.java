package p2661;

import java.util.Scanner;

public class Main {
	static int N;
	static boolean found = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		DFS(0,"0");
		
	}
	
	public static void DFS(int index, String numb) {
		if(index == N) {
			System.out.println(numb.substring(1));
			found = true;
		}else {
			for(int i=1;i<=3;i++) {
				if(i != Integer.parseInt(String.valueOf(numb.charAt(index)))) {
					if(found) {
						return;
					}
					if(isPossible(numb+i, index+1)){
						DFS(index+1, numb+i);
					}
				}
			}
			
		}
	}
	
	public static boolean isPossible(String numb, int index) {
		for(int i=1;i<index/2;i++) {
			for(int j=i+1;j<=index/2;j++) {
				int length = j-i;
				if((j+length)>index+1) {
					break;
				}
				if(numb.charAt(i) == numb.charAt(j)) {
					if(numb.substring(i, j).equals(numb.substring(j, j+length))) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
