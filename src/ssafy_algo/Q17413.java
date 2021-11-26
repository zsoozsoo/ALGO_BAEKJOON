package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q17413 {
	public static void stackPrint(Stack stack, StringBuilder sb) {
		int size = stack.size();
		for (int j = 0; j < size; j++) {
			sb.append(stack.pop());
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		boolean flg = false;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(flg) {
				if(ch=='>') flg = false;
				sb.append(ch);
			}else {
				if(ch==' ' || ch=='<') {
					stackPrint(stack, sb);
					sb.append(ch);
					if(ch=='<') flg = true;
				}
				else {
					stack.add(ch);
				}
			}
			
			if(i==str.length()-1 && !stack.isEmpty()) {
				stackPrint(stack, sb);
			}
			
		}
		
		System.out.println(sb.toString());
	}
}
