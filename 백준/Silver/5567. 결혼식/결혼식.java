import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int v,length;
	Node(int v, int length){
		this.v=v;
		this.length=length;
	}
}

public class Main {
    private static int n;
    private static LinkedList<Integer>[] graph;
    private static boolean visited[];
    private static int ans=0;

    private static void bfs(int v){
        visited[v]=true;
        Queue<Node>queue=new LinkedList<>();
        queue.add(new Node(v,0));
        
        while(!queue.isEmpty()) {
        	Node node=queue.poll();
        	int vertex=node.v;
        	int length=node.length;
        	
        	for(int i=0;i<graph[vertex].size();i++) {
        		int w=graph[vertex].get(i); //인접리스트의 정점
        		if(!visited[w] && length<2) { //방문되지 않았고 친구관계가 2이하일 때(친구 또는 친구의 친구)
        			visited[w]=true;
        			ans++;
        			int len=length+1;
        			queue.add(new Node(w,len));
        		}
        	}
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        graph=new LinkedList[n+1];
        visited=new boolean[n+1];
        int len=Integer.parseInt(br.readLine());
        for(int i=0;i<n+1;i++){
            graph[i]=new LinkedList<>();
        }

        for(int i=0;i<len;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int idx=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            graph[idx].add(v);
            graph[v].add(idx);
        }

        bfs(1);
        System.out.println(ans);

        br.close();
    }
}