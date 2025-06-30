import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    // 최대 힙 (중간값 이하)
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    // 최소 힙 (중간값 초과)
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    int N = Integer.parseInt(br.readLine());
    for(int i=0; i<N; i++){
      int number = Integer.parseInt(br.readLine());

      // 첫번째 숫자이면 최대힙에 추가
      if(maxHeap.isEmpty())
        maxHeap.offer(number);
      // 중간값보다 크면 최소힙에 저장
      else if(maxHeap.peek() < number){
        minHeap.offer(number);
      }
      // 중간값보다 작거나 같으면 최대힙의 중간값 교체
      // 최대힙에 먼저 저장하고, 최대힙의 루트를 최소힙으로 이동
      else {
        maxHeap.offer(number);
        minHeap.offer(maxHeap.poll());
      }

      // 힙 크기 조정 (최대힙이 항상 최소힙보다 같거나 1 많아야 함)
      // 최소힙(중간값 이후 수 저장) 사이즈가 더 크면 중간값 이동
      if(minHeap.size() > maxHeap.size()){
        maxHeap.offer(minHeap.poll());
      }
      
      bw.write(String.valueOf(maxHeap.peek())); // 중간값은 최대힙의 루트
      bw.newLine();
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
