import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Map<String,Integer> map=new HashMap<String, Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double total=0;
		
		while(true){
			String key=br.readLine();
			if (key == null || key.length() == 0) break;
			
			if(!map.isEmpty() && map.containsKey(key)) {
				int value=map.get(key);
				map.remove(key);
				map.put(key,++value);
			}
			
			else {
				map.put(key, 1);
			}
			total++;
		}
		
		List<String> keySet = new ArrayList<>(map.keySet());
        // 키 값으로 오름차순 정렬
        Collections.sort(keySet);

        for (String mapKey : keySet) {
        	double percent= (map.get(mapKey)/total)*100;
            System.out.println(mapKey+" "+String.format("%.4f", percent));
        }	
	}
}