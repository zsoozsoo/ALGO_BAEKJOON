package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1244 {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int light = Integer.parseInt(br.readLine()); //스위치 개수
		int[] arr = new int[light+1];
		arr[0] = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < light+1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int num = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < num; tc++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st2.nextToken());
			int idx = Integer.parseInt(st2.nextToken());
			
			if(gender==1) {
				for (int i = idx; i < light+1; i++) {
					if(i%idx==0) arr[i]^=1;
				}
			}else if(gender==2) {
				int key=0;
				for (int i = 1; i < light+1; i++) {
					if(idx-i>=1 && idx+i<light+1 && arr[idx-i]==arr[idx+i]) continue;
					else {
						key = i; break;
					}
				}
				
				if(key!=0) {
				for (int i = idx-(key-1); i < idx+key; i++) {
					arr[i] ^= 1;
				}
				}
			}
		}
		
		for (int i = 1; i < light+1; i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0) System.out.println();
		}
 
		
	}
}
