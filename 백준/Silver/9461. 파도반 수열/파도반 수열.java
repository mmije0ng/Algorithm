import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	private static ArrayList<Long> list=new ArrayList<>();
	
	private static void dp(int idx) { //현재 인덱스
		if(idx==100) //종료 조건
			return;
		
		if(idx<=3) {
			if(idx==3)
				list.add(idx,(long)2);
			else
				list.add(idx, (long)1);
		}
			
		else //인덱스가 4이상이면 인덱스-2+인덱스-3 
			list.add(idx,(long)(list.get(idx-2)+list.get(idx-3)));
		
		dp(idx+1);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		dp(0); //미리 100개, 인덱스 99까지의 케이스를 구해놓음
		
		while(T--!=0) {
			int n=Integer.parseInt(br.readLine());
			//미리 dp에서 list의 값을 구해 놓았으니 출력만 하면 됨
			System.out.println(list.get(n-1)); //n번째 수, 인덱스 n-1번째 수 출력	
		}
		
		br.close();
	}
}