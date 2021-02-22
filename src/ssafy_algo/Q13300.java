package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13300 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] student = new int[7][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int ban = Integer.parseInt(st.nextToken());
			
			student[ban][gender] ++;
		}
		
		int cnt = 0;
		for (int i = 1; i < 7; i++) {
			
			cnt += Math.ceil((double)student[i][0]/K);
			cnt += Math.ceil((double)student[i][1]/K);
//			if(student[i][0]%K==0) cnt += student[i][0]/K;
//			else cnt += (student[i][0]/K)+1;	
//			
//			if(student[i][1]%K==0) cnt += student[i][1]/K;
//			else cnt += (student[i][1]/K)+1;
		}
		
		System.out.println(cnt);
	}
}
