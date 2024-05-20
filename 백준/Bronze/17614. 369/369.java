import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt =0;

        for (int i=3;i<=N;i++){
            String stringN = Integer.toString(i);
            for (int j=0;j<stringN.length();j++){
                char charN = stringN.charAt(j);
                if(charN=='3' || charN=='6' ||charN=='9')
                    cnt++;
            }
        }

        bw.write(Integer.toString(cnt));

        bw.flush();
        bw.close();
        br.close();
    }
}