package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1592 { //모듈러 계산

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //인원수
		int M = Integer.parseInt(st.nextToken()); //최대 공 맞는 횟수
		int L = Integer.parseInt(st.nextToken()); //이동횟수
		
		int[] map = new int[N];
		int cnt = 0;
		int pos = 0; //현재위치
		
		while(true) { //무한반복 ( 최대횟수전까지 )
			map[pos]++;
			
			if(map[pos] == M) break;
			if(map[pos] %2 != 0) { //홀수일때
				pos = (pos+L) % N ;
			}else { //짝수
				pos = (pos-L + N) % N ; //자바는 나누기 할 때 나머지가 음수이면 음수그대로 나오니까 N을 더해줌 
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
