import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        boolean isNotPrime[] = new boolean[1299710]; //true이면 합성수, false이면 소스
        for(int i=2; i<1299710; i++)
            for(int j=i; i*j>2 && i*j<1299710; j++)
                isNotPrime[i*j] = true;

        while (T--!=0){
            int k = Integer.parseInt(br.readLine());

            if(isNotPrime[k]){ //k가 합성수이면
                //k보다 작은 가장 가까운 소수 찾기
                int start=k;
                while(true){
                    if(!isNotPrime[--start])
                        break;
                }

                //k보다 큰 가장 가까운 소수 찾기
                int end=k;
                while(true){
                    if(!isNotPrime[++end])
                        break;
                }

                System.out.println(end-start);
            }

            else
                System.out.println(0);
        }
    }
}
