import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
	private static Stack<String> stack=new Stack<>(); //화학식량 계산을 위한 스택
	private static String[] exp; //화학식
	
	private static void getResult() { //스택을 이용하여 각각의 화학식량 계산
		for(int i=0;i<exp.length;i++) {
			if(exp[i].equals(")")) { //오른쪽 괄호 ) 이면
				int sum=0; //괄호 안 화학식량
				
				while(!stack.peek().equals("(")) { //왼쪽 괄호를 만날 때 까지
					sum+=Integer.parseInt(stack.pop()); //괄호 안 화학식량 계산
				}				
				stack.pop(); //왼쪽 괄호 삭제
				stack.push(Integer.toString(sum)); //화학식량을 스택에 push
			}
			
			else if(exp[i].equals("H"))
				stack.push("1");
			else if(exp[i].equals("C"))
				stack.push("12");
			else if(exp[i].equals("O"))
				stack.push("16");
			
			else {
				try { //곱해야 할 숫자인 경우
					int mulNum=Integer.parseInt(exp[i]);
					int num=Integer.parseInt(stack.pop());
					stack.push(Integer.toString(mulNum*num));
				}
				catch (NumberFormatException e) {
						stack.push("(");
				}
			}		
		}	
		
		int result=0;
		while(!stack.isEmpty())  //스택에 남아있는 화학식량 계산 (스택에 남아 있는 것은 화학식량)
			result+=Integer.parseInt(stack.pop());
		
		System.out.println(result);
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String temp=br.readLine();
		exp=temp.split("");
		
		getResult();
		
		br.close();
	}
}