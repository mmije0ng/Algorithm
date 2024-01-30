import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		Deque<String> deque=new ArrayDeque<>(); //문자를 담을 덱
		Stack<Integer> stack=new Stack<>(); //1,2 숫자를 담을 스택
		
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int num=Integer.parseInt(st.nextToken());
			if(num==1) { //1번이면 맨 뒤에 추가
				String s=st.nextToken();
				deque.addLast(s); //덱 맨 뒤에 추가
				
				stack.push(num); //스택에 순서(숫자) 추가
			}
			
			else if(num==2) {//2번이면 맨 앞에 추가
				String s=st.nextToken();
				deque.addFirst(s); //덱 맨 앞에 추가
				
				stack.push(num); //스택에 순서(숫자) 추가
			}
			
			else { //3번이면 가장 나중에 추가된 문자 제거	
				if(!deque.isEmpty()) { //빈 문자열일 때 3번이면 아무런 동작을 하지 않음
					int stackNum=stack.pop();
					if(stackNum==1) //1이면 맨 뒤 제거
						deque.pollLast();
					
					else //2이면 맨 앞 제거
						deque.pollFirst();						
				}
			}
		}
		
		StringBuilder sb=new StringBuilder();
		if(deque.isEmpty()) //빈 문자열이면 0을 출력
			sb.append(0);
		else {
			while(!deque.isEmpty())
				sb.append(deque.pollFirst());
		}
		System.out.println(sb.toString());
		
		br.close();
	}
}