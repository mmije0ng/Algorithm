import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Student implements Comparable<Student>{
	private int age, order;
	private String name;
	
	Student(int age, String name, int order){
		this.age=age;
		this.name=name;
		this.order=order;
	}
	
	int getAge() {return this.age;}
	int gettOrder() {return this.order;}
	String getName() {return this.name;}
	
	void printStudent() {
		System.out.println(age+" "+name);
	}
	
	@Override
	public int compareTo(Student s) {
        if (this.age < s.age) 
            return -1;
         else if (this.age > s.age) 
            return 1;
         else if (this.age == s.age) 
            return this.order < s.order ? -1 : 1;
        
        return 0;
    }
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Student> minHeap = new PriorityQueue<>(); //최소힙
		
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int age=Integer.parseInt(st.nextToken());
			String name=st.nextToken();
			
			minHeap.add(new Student(age,name,i));
		}
		
		while(!minHeap.isEmpty()) {
			Student student=minHeap.remove();
			student.printStudent();
		}
	}
}