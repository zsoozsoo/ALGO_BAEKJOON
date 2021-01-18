package Step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine().toUpperCase();

		int[] arr = new int[26];
		int max = 0, idx = 0;
		boolean multi = false;

		for (int i = 0; i < word.length(); i++) {
			arr[word.charAt(i) - 'A']++;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0 && max < arr[i]) {
				max = arr[i];
				idx = i;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (max == arr[i] && idx != i) {
				multi = true;
			}
		}

		if (multi == false) {
			System.out.println((char) (idx + 'A'));
		}else{
			System.out.println("?");
		}
	}
}
