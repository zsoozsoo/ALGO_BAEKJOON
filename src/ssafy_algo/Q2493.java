package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2493 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> sequence = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		stack.push(Integer.parseInt(st.nextToken()));
		sequence.push(1);
		System.out.println(0);

		for (int i = 1; i < N; i++) {
			int result = 0;
			int num = Integer.parseInt(st.nextToken());
			while(true) {
				if(!stack.isEmpty()) {
					if(stack.peek()>num) {
						result = sequence.peek();
						stack.push(num);
						sequence.push(i+1);
						break;
					}else {
						stack.pop();
						sequence.pop();
					}
				}else {
					stack.push(num);
					sequence.push(i+1);
					break;
				}
			}
			
			System.out.println(result);
		}

	}
}
