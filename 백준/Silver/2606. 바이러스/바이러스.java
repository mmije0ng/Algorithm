import java.util.Scanner;

class Graph{
	private boolean isVertex;
	private boolean isVisited;
	
	Graph(boolean isVertex, boolean isVisited){
		this.isVertex=isVertex;
		this.isVisited=isVisited;
	}
	
	Graph(){
		this(false,false);
	}
	
	void setVertex(boolean isVertex) {
		this.isVertex=isVertex;
	}
	
	void setVisited(boolean isVisited) {
		this.isVisited=isVisited;
	}
	
	boolean getVertex() {return isVertex;}
	boolean getVisited() {return isVisited;}
}

public class Main {
	private static Graph[][] graph;
	private static int count=0;
	
	private static void dfs(int v, int size) {
		graph[v][v].setVisited(true);
		count++;
		
		for(int i=0;i<size;i++) {
			if(!graph[i][i].getVisited() && graph[v][i].getVertex())
				dfs(i,size);
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int size=scanner.nextInt();
		graph=new Graph[size][];
		for(int i=0;i<size;i++) 
			graph[i]=new Graph[size];
		
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				graph[i][j]=new Graph();
		
		int vertexCount=scanner.nextInt();
		for(int i=0;i<vertexCount;i++) {
			int start=scanner.nextInt();
			int end=scanner.nextInt();
			
			graph[start-1][end-1].setVertex(true);
			graph[end-1][start-1].setVertex(true);
		}		
		
		dfs(0,size);
		System.out.println(count-1);
		
		scanner.close();
	}
}