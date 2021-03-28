package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1181 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>(); //set타입에 단어 넣어주기
		
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		List<String> list = new ArrayList<>(set); //비교해야되니까 set애들 list에 넣어주기
		Collections.sort(list,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) return o1.compareTo(o2); //한번더 비교 > 오름차순
				else if (o1.length()>o2.length()) return 1; //둘이 순서 바꿔주기
				else return -1; //그대로
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
