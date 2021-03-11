package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int num = 0, num2=0 ,result = 0 ;
		
		if(input == 1) result = 1;
			while(input != 1) {
				num2 = ((num*num)+num)/2;
				if((6*num2)+2 <=input && (6*((num2+1)+num))+1>=input) {
					result = num +2; break;
				}
				num++;
			}
		System.out.println(result);
		
	}
}
