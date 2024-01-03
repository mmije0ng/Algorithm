import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Person implements Comparable <Person> {
	private int doc,interview;
	
	Person(int doc, int interview){
		this.doc=doc;
		this.interview=interview;
	}
	
	int getInterview() {return interview;}
	
	@Override
	public int compareTo(Person p) {
		if(doc>p.doc)
			return 1;
		else
			return -1;
	}
}

public class Main {
	public static void main (String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());
		StringTokenizer st;
			
		for(int t=0;t<testCase;t++) {
			ArrayList<Person> list=new ArrayList<>(); 
			int n=Integer.parseInt(br.readLine());

			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine()," ");
				int doc=Integer.parseInt(st.nextToken());
				int interview=Integer.parseInt(st.nextToken());				
				
				list.add(new Person(doc,interview));
			}
			//서류 심사 순으로 정렬
			Collections.sort(list);
		
			int count=1; //뽑힌 신입사원의 수, 서류 1순위는 무조건 뽑힘
			int minInterview=list.get(0).getInterview(); //현재까지 가장 낮은 면접 순위	
			for(int i=1;i<n;i++) {
				int interview=list.get(i).getInterview(); //나의 면접 순위
		
				//나의 면접 순위가 현재까지 가장 낮은 면접 순위보다 낮아야 함 
				// -> 서류 순으로 정렬되어 있기 때문에 무조건 나의 서류 순위는 나의 앞사람보다 높기 때문
				//면접 순위 1위를 찾으면 끝 (내가 서류 순위도 높고 면접 순위도 더 높기 때문에 조건 만족X)
				if(interview<minInterview) {
					count++;
					//나의 면접 순위가 현재까지 가장 낮은 면접 순위보다 낮으면
					//나의 면접 순위가 현재까지 가장 낮은 면접 순위가 됨
					minInterview=interview;
				}
			}
			
			System.out.println(count);
		}
		
		br.close();
	}
}