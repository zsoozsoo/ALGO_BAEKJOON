package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5622 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String dial = br.readLine();
		int sum = 0;
		
		for (int i = 0; i < dial.length(); i++) {
			char c = dial.charAt(i);
			
			if (c<='C') sum += 3;
			else if (c <='F') sum += 4;
			else if (c <='I') sum += 5;
			else if (c <='L') sum += 6;
			else if (c <='O') sum += 7;
			else if (c <='S') sum += 8;
			else if (c <='V') sum += 9;
			else if (c <='Z') sum += 10;
		}
		
		System.out.println(sum);
	}
}
