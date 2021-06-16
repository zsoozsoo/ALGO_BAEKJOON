package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q10448 {
	static List<Integer> list;
	static int num, res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			num = Integer.parseInt(br.readLine());
			res = 0;
			
			list = new ArrayList<>();
			
			for (int j = 1; j < num; j++) {
				int triSum = triple(j);
				if(triSum > num) break;
				list.add(triSum);
			}
			
			permu(0,0,new int[3]);
			System.out.println(res);
		}
		
	}

	private static void permu( int start, int cur,int[] temp) {
		
		if(cur==3) {
			int sum = 0;
			for (int i = 0; i < temp.length; i++) {
				sum += temp[i];
			}
			if(sum==num) {
				res = 1;
				return;
			}
			return;
		}
		
		for (int i = start; i < list.size(); i++) {
			temp[cur] = list.get(i);
			permu(i,cur+1,temp);
		}

	}

	private static int triple(int j) {
		return j*(j+1)/2;
	}
}
