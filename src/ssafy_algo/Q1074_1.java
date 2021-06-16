package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1074_1 {

	static int r,c,num=0;
	static int N , size, result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);
				
		zet(0,0,size);
	}

	private static void zet(int row, int col, int size) {
		
		if(row==r && col == c) {
			System.out.println(result);
			System.exit(0);
		}
		
		if(r<row+size && r>=row && c<col+size && c>=col) {
			size = size/2;
			zet(row,col,size);
			zet(row,col+size,size);
			zet(row+size,col,size);
			zet(row+size,col+size,size);
		}else result += size*size;
	}
}
