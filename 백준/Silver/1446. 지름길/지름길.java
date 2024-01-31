import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Node{
	int start,end,dis; //지름길 시작, 끝, 거리
	Node(int start, int end, int dis){
		this.start=start;
		this.end=end;
		this.dis=dis;
	}
}

public class Main {
	private static int n; //지름길 개수 
	private static int d; //고속돌의 길이(목표 정점)
	private static List<Node> graph = new ArrayList<>(); // 지름길 배열
	private static int[] distance; //최소 거리를 담은 배열
	
	private static void getMinDistance() {
		for(int i=1;i<=d;i++) {
			for(Node node:graph) {
				if(i==node.end) {
					int ndis=distance[node.start]+node.dis; //지름길 거리
					//같은 시작점을 가진 지름길 거리,(이전까지의 최소 거리+현재 정점을 거치는 거리,지름길 거리)
					distance[i]=Math.min(distance[i], Math.min(distance[i-1]+1, ndis));
				}
				
				else  //지름길이 없는 경우
					distance[i]=Math.min(distance[i], distance[i-1]+1); 			
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		n=Integer.parseInt(st.nextToken()); 
		d=Integer.parseInt(st.nextToken()); 
		distance=new int[d+1];
		for(int i=0;i<=d;i++)
			distance[i]=i;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int start=Integer.parseInt(st.nextToken()); //지름길 시작 위치
			int end=Integer.parseInt(st.nextToken()); //지름길 끝 위치
			int distance=Integer.parseInt(st.nextToken()); //지름길 거리
	
			//시작 위치가 끝 위치보다 크거나 지름길이 더 길거나 지름길 끝 정점이 목료보다 더 크점
			if((start>end) || (end-start<=distance) || end>d)
				continue;		
			
			graph.add(new Node(start,end,distance));
		}
		
		getMinDistance();
		System.out.print(distance[d]);
	}
}
