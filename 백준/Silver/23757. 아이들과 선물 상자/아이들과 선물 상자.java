import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int n=Integer.parseInt(st.nextToken()); //선물 상자의 수
        int m=Integer.parseInt(st.nextToken()); //아이들의 수

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder()); //선물 상자는 최대 힙으로

        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++)
            maxHeap.add(Integer.parseInt(st.nextToken()));

        st=new StringTokenizer(br.readLine()," ");
        boolean isAll=true; //실패 성공 여부
        for(int i=0;i<m;i++){
            int top= maxHeap.poll();
            int student=Integer.parseInt(st.nextToken());

            //상자에 자신이 원하는 것보다 적은 개수의 선물이 들어있다면 실패
            if(top<student){
                isAll=false;
                break;
            }

            else{
                //앞서 선택한 상자에서도 선택이 가능하도록
                top=top-student;
                maxHeap.add(top);
            }
        }

        if(isAll)
            System.out.print(1);
        else
            System.out.print(0);

        br.close();
    }
}