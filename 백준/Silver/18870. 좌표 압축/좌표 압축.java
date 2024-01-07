import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int size=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
	
		int[] list=new int[size]; //정렬을 위한 리스트
		for(int i=0;i<size;i++) {
			list[i]=Integer.parseInt(st.nextToken());
		}
		int[] cloneList=list.clone(); //중복을 포함한 원본 숫자 저장, 얕은 복사
		Arrays.sort(list); //list 정렬
	
		HashMap<Integer,Integer> map=new HashMap<>(); //중복을 제거하기 위한 map
		int index=0; //중복을 제외한 인덱스
		for(int number:list) {
			//중복이 아닌 경우에 map에 (숫자, 인덱스) 저장, 중복일 경우에는 최초 숫자, 인덱스 쌍 저장
			if(!map.containsKey(number)) 
				map.put(number,index++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int key:cloneList) 
			sb.append(map.get(key)).append(' ');
		System.out.println(sb);
		
		br.close();
	}
}