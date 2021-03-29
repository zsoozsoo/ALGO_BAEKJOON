package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q1755 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); //입력한 M받기
		int N = Integer.parseInt(st.nextToken()); //입력한 N받기
		//숫자를 텍스트로 바꿔줄 수 있게 string배열인 text에 숫자를 텍스트로 바꿔놓은거 넣어놓기
		String[] text = {"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
		
		int idx = M; //M은 입력받은 수이기 때문에 변경되면 안되기때문에 별도의 idx라는 변수에 M값 넣어주기
		String[] sArr = new String[(N-M)+1]; //정렬하기 쉽도록 숫자를 텍스트로 바꾼 값들 넣어줄 string배열 sArr 생성
		HashMap<String,Integer> map = new HashMap<>(); //숫자와 그에 맞는 텍스트 찾기 위해 HashMap 생성
		for (int i = 0; i < (N-M)+1; i++) { //M부터 N까지의 숫자들 텍스트로 바꿔주기
			String s = ""; //string s초기화
			
			if(idx<10) s = text[idx]; //만약에 한자리수면 arr[i]값이 text[arr[i]] 값과 같으므로 대입
			else {
				s = text[idx/10] + " " +text[idx%10]; //두자리수 니까 하나씩 분리해서 넣어주기
			}
			
			sArr[i] = s; //숫자를 텍스트로 바꿔준 값을 텍스트 값들 저장할 배열에 넣어줌
			map.put(s,idx); //map에 해당숫자와 그를 변환한 텍스트 넣어줌
			idx++; //M부터 N까지 다 해야하니까 1씩 증가시켜줌
		}
		
		Arrays.sort(sArr); //텍스트배열 정렬
		for (int i = 0; i < sArr.length; i++) {
			if(i>0 && i%10==0) System.out.println();
			System.out.print(map.get(sArr[i])+" "); //정렬된 텍스트 배열에 맞는 숫자 출력해주기
		}
		
		
	}

}
