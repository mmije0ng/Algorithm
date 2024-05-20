import java.io.*;

public class Main {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean flag =false;

        while(N--!= 0 ){
            long m = Long.parseLong(br.readLine());
            for(int i=0;i<=63;i++){
                long numX=(long)Math.pow(2,i);
                for(int j=63;j>=0;j--){
                    flag = numX + (long) Math.pow(2, j) == m;
                    if(flag) {
                        bw.write(Integer.toString(i)+" "+Integer.toString(j)+"\n");
                        break;
                    }
                }
                
                if (flag) 
                    break;
                
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}