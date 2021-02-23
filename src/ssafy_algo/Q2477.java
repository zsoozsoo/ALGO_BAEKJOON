package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2477 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		int[] map = new int[6];
		int w = 0,h = 0,ww=0,hh=0,sum=0;
		
		for (int i = 0; i <6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
		
			map[i] = length;
		}
		
		// 전체크기의 W,H 바뀌는것은 상관없음
		// 1,3,5 
		// 0,2,4 
		
		for (int i = 0; i < 6; i++) { // 넓은 사각형
			if(i % 2 == 0) w = Math.max(w, map[i]);
			else  h = Math.max(h, map[i]);
		}
		
		// 모듈러 연산 ( 6을 넘어가면 다시 0으로 ) // x % y ==> k // (x+y) % y ==> k //얼마를 더해도 뒤에 같으면 나머지는 같음
		// 내가 만약에 가로일때, 내 전과후 길이를 합해서 세로가 나오면 그게 바뀌는 변
		for (int i = 0; i < 6; i++) { // 작은 사각형
			if(i % 2 == 0) {
				if((map[(i+5)%6]+map[(i+1)%6])==h) ww = map[i]; 
			}else {
				if((map[(i+5)%6]+map[(i+1)%6])==w) hh = map[i];
			}
		}
		
		sum += (w*h); // 큰 사각형
		sum -= (ww*hh); //작은 사각형
		System.out.println(sum * K);
	}
}
