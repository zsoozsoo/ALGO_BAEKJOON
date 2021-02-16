package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2839 {
	public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	int five = 0, three=0;
		
	while( N>=0 && N%5!=0) {
			N -= 3;
			three++;
	}
		
	if(N<0) System.out.println(-1);
	else {
		five = N/5;
		System.out.println(five+three);
		}
		
	}
}
