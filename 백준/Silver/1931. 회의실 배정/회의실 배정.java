import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Comparator;

public class Main {
	public static int[] stroe=new int[501];
	
	public static void main(String[] args) throws IOException  {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Vector<Pair> v=new Vector<Pair>();
		
		int n=Integer.parseInt(bf.readLine()); //회의의 수
		for(int i=0;i<n;i++) {
			String s=bf.readLine();
			StringTokenizer st=new StringTokenizer(s);
			
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			
			v.add(new Pair(start,end));
		}
		
		Collections.sort(v, new Comparator<Pair>() {
			public int compare(Pair pair1, Pair pair2) {
				if(pair1.getEnd()< pair2.getEnd())
					return -1;
				
				else if(pair1.getEnd() ==  pair2.getEnd()) 
					return Integer.compare(pair1.getStart(), pair2.getStart());
				
				else return 2;
			}
		} 
		);
		
		int count=0;
		int end=v.get(0).getEnd();
		
		for(int i=1;i<v.size();i++){
			if(v.get(i).getStart()>=end) {
				end=v.get(i).getEnd();				
				count++;
			}
		}
		
		System.out.println(count+1);
	}	
}

class Pair {
	private int start,end;
	
	Pair(int start, int end){
		this.start=start;
		this.end=end;
	}
	
	int getStart() {return start;}
	int getEnd() {return end;}
}