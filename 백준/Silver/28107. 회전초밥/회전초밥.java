import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 손님이 먹은 초밥 개수를 저장하는 리스트 (초기값 0)
        List<Integer> list = new ArrayList<>(Collections.nCopies(N, 0));

        // 손님이 원하는 (손님번호, 초밥번호) 저장 소팅 PQ
        PriorityQueue<Customer> customerPq = new PriorityQueue<>();

        // N명의 손님 정보 입력
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            st = new StringTokenizer(line, " ");
            int k = Integer.parseInt(st.nextToken()); // 각 손님이 원하는 초밥 수 (사용 안함)

            // 원하는 초밥 번호들을 PQ에 추가
            for(int j=0; j<k; j++){
                int sushi = Integer.parseInt(st.nextToken());
                customerPq.add(new Customer(i, sushi));
            }
        }

        // 초밥 M개 입력
        PriorityQueue<Integer> sushiPq = new PriorityQueue<>();
        String line = br.readLine();
        st = new StringTokenizer(line, " ");
        for(int i=0; i<M; i++)
            sushiPq.add(Integer.parseInt(st.nextToken()));

        while(!sushiPq.isEmpty()){
            int sushi = sushiPq.poll();

            // 손님이 먹은 초밥은, 다른 손님의 선호도에 있어도 다시 먹을 수 없음
            // 손님이 먹은 초밥은 다른 손님의 선호도 목록에서 제거
            while (!customerPq.isEmpty() && customerPq.peek().sushi < sushi) {
                customerPq.poll();
            }

            if (!customerPq.isEmpty() && customerPq.peek().sushi == sushi) {
                Customer customer = customerPq.poll();
                list.set(customer.number, list.get(customer.number) + 1);
            }
        }

        for(int cnt : list){
            bw.write(cnt + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 스시 오름차순 → 스시 같으면 손님 번호 오름차순
    public static class Customer implements Comparable<Customer>{
        int number;
        int sushi;

        Customer(int number, int sushi){
            this.number= number;
            this.sushi = sushi;
        }

        @Override
        public int compareTo(Customer o){
            if(this.sushi == o.sushi){
                return this.number - o.number;
            }
            return this.sushi - o.sushi;
        }
    }
}
