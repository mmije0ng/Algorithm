import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 비어있는 주차 공간들 관리, 오름차순
        Queue<Integer> queue = new ArrayDeque<>(); // 주차 대기 공간
        HashMap<Integer, Integer> map =  new HashMap<>(); // <차, 주차 인덱스>

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] weightPrices = new int[N]; // 주차 공간들의 단위 무게당 요금 배열
        for (int i = 0; i < N; i++) {
            weightPrices[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            pq.add(i);
        }   

        int[] weights = new int[M]; // 차량들의 무게
        for (int i = 0; i < M; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }
        
        // System.out.println(pq);

        int totalPrice = 0; // 하루동안 번 총 주차 요금
        // 주차가 들어오면 pq(비어있는 주차공간 인덱스 관리)에서 제거
        // 주차 빠지면 pq에 삽입
        // pq사이즈 == 0(비어 있는 주차 공간 없음) 이면 큐에 차 대기
        for (int i = 0; i < M * 2; i++) {
            int num = Integer.parseInt(br.readLine()); // 차 번호
            
            // 양수이고, 주차 공간이 있는 경우
            if (num > 0 && !pq.isEmpty()) {
                int emptyIndex = pq.poll();
                
                // 대기 차 없는 경우, num 차를 바로 주차
                if (queue.isEmpty()) {
                    map.put(num, emptyIndex);
                    totalPrice += weights[num - 1] * weightPrices[emptyIndex]; // 차량무게 * 주차공간 가격
                    // System.out.println("num = " + num);
                    // System.out.println("emptyIndex = " + emptyIndex);
                }
                    
                // 대기 차 있으면 큐에서 제거 후 주차
                else {
                    int waitingCar = queue.poll();
                    map.put(waitingCar, emptyIndex);
                    totalPrice += weights[waitingCar - 1] * weightPrices[emptyIndex];
                    // System.out.println("waitingCar = " + waitingCar);
                    // System.out.println("emptyIndex = " + emptyIndex);
                }
            }
                
            // 양수이고, 주차 공간 없는 경우 큐에서 대기
            else if (num > 0 && pq.isEmpty()) {
                queue.add(num);
                // System.out.println("공간 없어서 큐에서 대기, num = " + num);
            }
                
            // 음수일 때 주차 빠짐
            else if (num < 0){
                Integer removeIndex = map.get(-num); // 새로 비는 주차 공간
                pq.add(removeIndex);
                map.remove(-num); // 차량 삭제
                // System.out.println("주차 제거, removeIndex = " + removeIndex);

                // 대기 중인 차가 있다면, 방금 제거된 주차 공간에 삽입
                if(!queue.isEmpty()){
                    int waitingCar = queue.poll();
                    map.put(waitingCar, removeIndex);

                    if(!pq.isEmpty()){
                        pq.remove(removeIndex); // 방금 빠진 주차공간에 다시 주차했으니, 비어 있는 주차공간에서 제거 
                    }
                    
                    totalPrice += weights[waitingCar - 1] * weightPrices[removeIndex];
                    // System.out.println("waitingCar = " + waitingCar);
                    // System.out.println("removeIndex = " + removeIndex);
                }
            }

            // System.out.println(pq);
        }        

        bw.write(String.valueOf(totalPrice));
        
        bw.flush();
        bw.close();
        br.close();
    }
}