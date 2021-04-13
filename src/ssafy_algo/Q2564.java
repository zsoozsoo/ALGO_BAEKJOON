package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2564 {
	
	static int w,h;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken()); //가로
		h = Integer.parseInt(st.nextToken()); //세로
		int fullSize = 2*w + 2*h;// 사각형 전체 길이
		int n = Integer.parseInt(br.readLine()); //상점의 갯수
		int[] arr = new int[n]; // 사각형의 길이 넣어줄 배열
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			arr[i] = checkLoc(dir, dis);
		}
		
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		int store = checkLoc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); //상점의 사각형 길이
		for (int i = 0; i < n; i++) {
			int diff = Math.abs(store-arr[i]);//상점과 동근이의 차이 (시계방향으로)
			sum += Math.min(diff, fullSize-diff); //전체사각형의 길이에서 diff빼준거랑 둘 중에 최소 구해서 sum에 더해줌
		}
		
		System.out.println(sum);
		
	}
	
	private static int checkLoc(int dir,int dis) { //사각형의 길이 구해주기 (시계방향으로)
		int res = 0;
		switch(dir) {
		case 1: res=dis; break;
		case 2: res=(2*w)+h-dis; break;
		case 3: res=(2*w)+(2*h)-dis; break;
		case 4:	res=w+dis; break;
		}
		return res;
		
	}
}
