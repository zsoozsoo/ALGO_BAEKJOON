package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1074 {
	
	static int r,c,num=0;
	static int N , size, result;
	
	public static void zet(int row, int col, int size) {
		
		if( size == 2) {
			if(r<row+size && r>=row && c<col+size && c>=col) {
				if(r==row && c==col) result += 0;
				if(r==row && c==col+1) result += 1;
				if(r==row+1 && c==col) result += 2;
				if(r==row+1 && c==col+1) result += 3;
				System.out.println(result);
				System.exit(0);
			}else result += size*size;
		return;
		}
		
		size /= 2;
		zet(row,col,size);
		zet(row,col+size,size);
		zet(row+size,col,size);
		zet(row+size,col+size,size);
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);
				
		zet(0,0,size);
		
	}
}
