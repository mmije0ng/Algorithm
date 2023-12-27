import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		HashMap<String, Integer> map=new HashMap<>();
		int max=0; //가장 많이 팔린 책의 개수 
		
		while(n--!=0) {
			String key=br.readLine();
			map.put(key, map.getOrDefault(key,0)+1);
			max=Math.max(max, map.get(key));
		}
		
		List<String> maxKeyList=new ArrayList<>(); //가장 많이 팔린 책들을 저장
		for(String key:map.keySet()) {
			//key의 value값과 max값이 같으면 가장 많이 팔린 책이니 리스트에 저장
			if(map.get(key)==max)
				maxKeyList.add(key);
		}
		//가장 많이 팔린 책이 여러 개일 경우 사전 순으로 제목 정렬
		Collections.sort(maxKeyList);
		
		System.out.println(maxKeyList.get(0));
	}
}