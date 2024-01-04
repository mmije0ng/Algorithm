import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> beforeCountStack=new Stack<>(); //왼쪽괄호전에 곱해야 할 숫자 k를 제외한 숫자가 몇개있는지 저장
		Stack<Integer> mulStack=new Stack<>(); //곱하기 위한 숫자 저장
		String[] exp=br.readLine().split("");
		
		int len=0; //오른쪽 괄호를 만나기 전까지 숫자가 몇개 있는지
		for(int i=0;i<exp.length;i++) {
			String s=exp[i];
			if(s.equals("(")) {
				//곱해야할 숫자 하나를 제외하고 push
				beforeCountStack.push(--len);
				//곱해야할 숫자 push
				mulStack.push(Integer.parseInt(exp[i-1]));
				len=0; //
			}
			
			else if(s.equals(")")) {
				//()안에 존재한느 숫자*곱해야 할 숫자+왼쪽괄호 전에 곱해야할 숫자를 제외한 개수
				len=len*mulStack.pop()+beforeCountStack.pop();
			}
			
			else
				len++;
		}
		
		
		System.out.println(len);
		br.close();
	}
}