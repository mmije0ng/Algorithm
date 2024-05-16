import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent; //부모 정점 저장

    static int find(int curr){
        if(parent[curr]==0)
            return curr;
        return parent[curr] = find(parent[curr]);
    }

    static void union(int x, int y){
        int rootA = find(x);
        int rootB = find(y);

        if(rootA<rootB)
            parent[rootB]=rootA;
        else
            parent[rootA]=rootB;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent=new int[N+1];
        List<Node> graph=new ArrayList<>();
        int sum=0;

        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine()," ");

            int start = Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int weight =Integer.parseInt(st.nextToken());
            int d= Integer.parseInt(st.nextToken());

            if(d==0) { //이미 성사된 사랑 관계면 그래프에 추가
                graph.add(new Node(start,end,weight));
                sum+=weight;
            }

            else //아닐경우 부모 노드 찾기
                union(start,end);
        }

        Collections.sort(graph); //오름차순으로 정렬

        int graphWeight=0;
        for (Node node : graph) {
            int start = node.start;
            int end = node.end;
            int weight = node.weight;

            if (find(start) != find(end)) {
                union(start, end);
                graphWeight += weight;
            }
        }

        System.out.println(sum-graphWeight); //전체 애정도의 합에서 이미 성사된 애정도의 합을 빼기
    }
}

class Node implements Comparable<Node> {
    int start,end,weight;
    Node(int start, int end, int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }

    @Override
    public int compareTo(Node node) {
        // 오름차순으로 정렬
        return Integer.compare(node.weight, this.weight);
    }
}