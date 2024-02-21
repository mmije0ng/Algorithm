import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Stack <Integer> stack=new Stack<>(); //숫자를 담는 스택
		String s=br.readLine();
		
		boolean isString=true;
		for(int i=s.length()-1;i>=0;i--) {
			char c=s.charAt(i);
			if(c=='x') {
				stack.push(0);
			}
			
			else if(c=='g') {
				//g뒤에가 문자열이 아님
				if(stack.size()<1) {
					isString=false;
				}
				
				else {
					//gS는 함수 문자열이니 +1
					int count=stack.pop();
					stack.push(++count);
				}
			}
			
			else { //f
				//f뒤에가 문자열이 아님
				if(stack.size()<2) {
					isString=false;
				}
				
				else {
					//fST는 함수 문자열이니 S T 중 더 작은 값
					int count1=stack.pop();
					int count2=stack.pop();
					stack.push(Math.min(count1, count2));
				}
			}
		}
		
		if(isString && stack.size()==1)	
			System.out.print(stack.peek());		
		else
			System.out.print(-1);
	}
}