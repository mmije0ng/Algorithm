import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Column implements Comparable<Column>{
	int location,height;
	Column(int location,int height){
		this.location=location;
		this.height=height;
	}
	
	@Override
	public int compareTo(Column o) {
		return location-o.location;
	}
}

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Column> list=new ArrayList<>();
		
		int size=Integer.parseInt(br.readLine());
		int maxHeight=0; //전체에서 가장 높은 기둥 높이	
		int maxIndex=0;
		for(int i=0;i<size;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int location=Integer.parseInt(st.nextToken());
			int height=Integer.parseInt(st.nextToken());
				
			list.add(new Column(location,height));
		}
		Collections.sort(list);
		
		for(int i=0;i<size;i++) {
			if(list.get(i).height>maxHeight) {
				maxHeight=list.get(i).height;
				maxIndex=i;
			}	
		}
		
		int res=0;
		int height=list.get(0).height; //현재 최고 기둥 높이
		int index=0; //현재 최고 기둥 높이가 속하는 인덱스
		
		//최고 기둥 왼쪽 면적
		for(int i=0;i<=maxIndex;i++) {
			//내 기둥 높이가 현재까지 최고 기둥 높이보다 더 높다면
			if(list.get(i).height>height) {
				res+=(list.get(i).location-list.get(index).location)*height; //(나보다 높은 기둥 좌표-현재 최고 기둥 좌표)*현재 최고 기둥 높이
				index=i;
				height=list.get(i).height; //현재 최고 기둥 높이 변경	
			}
		}
		
		res+=maxHeight; //최고 기둥 높이 면적
		height=0;
		index=0;
		int idx=0;
		
		//최고 기둥 오른쪽 면적
		for(int i=size-1;i>=maxIndex;i--) {
			if(list.get(i).height>height) {
				res+=(list.get(index).location-list.get(i).location)*height;
				height=list.get(i).height; //현재 최고 기둥 높이 변경	
				index=i;
				idx=i;
			}
		}
		
		res+=(list.get(idx).location-list.get(maxIndex).location)*list.get(idx).height;
		
		System.out.println(res);
		
		br.close();
	}
}