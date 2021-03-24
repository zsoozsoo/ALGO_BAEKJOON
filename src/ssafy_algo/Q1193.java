package ssafy_algo;

import java.util.Scanner;

public class Q1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int num = 2;
		
		if(input==1) System.out.println(1+"/"+1);
		while(input!=1) {
			if((num*(num-1))/2>=input) {
				int base = input-(((num-1)*(num-2))/2);
			
				if(num%2==0) {
					if(base==num/2) System.out.println(num/2+"/"+num/2);
					else System.out.println((num-base)+"/"+base); break;
				}else {
					System.out.println(base+"/"+(num-base)); break;
				}
			}
			num++;
		}
	}
}
