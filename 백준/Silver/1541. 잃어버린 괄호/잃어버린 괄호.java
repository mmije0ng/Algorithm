import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp=br.readLine();
		String[] tokens=exp.split("-"); //-를 기준으로 식을 나눔
		int sum=0;
		
		for(int i=0;i<tokens.length;i++) {
			String[] plusTokens=tokens[i].split("\\+"); //+가 있다면 +의 수식을 계산
			if(plusTokens.length>0) {
				int plusSum=0;
				for(int j=0;j<plusTokens.length;j++) {
					plusSum+=Integer.parseInt(plusTokens[j]);
				}
				tokens[i]=Integer.toString(plusSum);
			}
			
			if(i==0)
				sum=Integer.parseInt(tokens[i]);
			else
				sum-=Integer.parseInt(tokens[i]);
		}
		
		System.out.println(sum);
	}
}
