package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1753 {
	
	static List<Node>[] nodeList;
	static int[] distance;
	static int INF = Integer.MAX_VALUE,V,E;
	
	static class Node implements Comparable<Node>{
		int end, weight;
		
		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		public int compareTo(Node o) {
			return this.weight - o.weight; //오름차순
		}
		
	}
	
	private static void dijkstra(int k) {
		PriorityQueue<Node> queue = new PriorityQueue<>(); //큐 생성
		boolean[] visited = new boolean[V+1];//방문여부확인
		queue.offer(new Node(k,0));
		distance[k] = 0; //시작점 0으로 넣어주기
		
		while(!queue.isEmpty()) {
			int current = queue.poll().end;
			
			if(visited[current]) continue;
			visited[current] = true;
			
			for (Node node : nodeList[current]) {
				if(distance[node.end] > distance[current] + node.weight) {
					distance[node.end] = distance[current] + node.weight;
					queue.offer(new Node(node.end,distance[node.end]));
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); //정점의 개수
		E = Integer.parseInt(st.nextToken()); //간선의 개수
		int k = Integer.parseInt(br.readLine()); //시작 정점
		
		distance = new int[V+1]; //가중치 저장해줄 배열
		nodeList = new ArrayList[V+1]; //노드를 저장할 리스트 배열
		
		Arrays.fill(distance, INF);
		
		for (int i = 1; i <= V; i++) { //초기화 arraylist배열 만들어주기 )
			nodeList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			nodeList[u].add(new Node(v,w)); //끝점이랑 값 넣어주기
		}
		
		dijkstra(k);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if(distance[i]==INF) sb.append("INF\n");
			else sb.append(distance[i]+"\n");
		}
		
		System.out.println(sb);
	}

}
