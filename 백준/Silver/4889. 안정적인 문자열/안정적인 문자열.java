import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int idx=1;
		
		while(true) {
			String[] exp=br.readLine().split("");
			Stack<Character> stack=new Stack<>();
			int cnt=0;
			if(exp[0].equals("-"))
				break;
			
			for(int i=0;i<exp.length;i++) {
				// {}인 경우 안정적인 문자열
				if(!stack.isEmpty() && exp[i].equals("}") && stack.peek()=='{'){
					stack.pop();
				}
				else
					stack.push(exp[i].charAt(0));
			}
			
			//스택에는 {}인 경우를 제외한 나머지 경우들이 삽입되어 있음
			while(!stack.isEmpty()) {
				//항상 길이는 짝수
				char ch2=stack.pop();
				char ch1=stack.pop();
				if(ch1==ch2) // {{ 또는 }}
					cnt++;
				else // }{ 인 경우
					cnt+=2;
			}
			
			System.out.println((idx++)+". "+cnt);
		}
		
		br.close();
	}
}