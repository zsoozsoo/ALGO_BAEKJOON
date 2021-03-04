package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Q15961 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //N - 벨트에 놓인 접시의 수
		int d = Integer.parseInt(st.nextToken()); //d - 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); //k - 연속 접시 수
		int c = Integer.parseInt(st.nextToken()); //c - 쿠폰 번호

		
		int[] belt = new int[N];
		int[] dish = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine()); //초밥 번호 입력
		}
		
		dish[c]++;
		
		int sum = 1; //쿠폰 넣어줬으니까
		for (int i = 0; i < k; i++) {
			if(dish[belt[i]]++ == 0) sum++; //일단 k까지만 넣어줌
		}
		
		int res= sum;
		
		for (int i = k; i < N+k; i++) { //k부터 시작
			if(--dish[belt[i-k]]==0) sum--; //앞에 있는 애들은 빼주고
			if(dish[belt[i%N]]++==0) sum++; //뒤에꼬리는 추가해주고
			if(sum > res) res = sum;
		}
		
		System.out.println(res);
	}
}
