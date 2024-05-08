import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hearSet = new HashSet<>();
        List<String> hearSeaList = new ArrayList<>();

        for(int i=0;i<n;i++)
            hearSet.add(br.readLine());

        for(int i=0;i<m;i++){
            String name= br.readLine();
            // 보도 못한 사람이 듣도 못한 사람 리스트에서 존재한다면
            // HashSet의 contains가 List의 conatins보다 높은 성능
            if(hearSet.contains(name))
                hearSeaList.add(name);
        }
        Collections.sort(hearSeaList);

        System.out.println(hearSeaList.size()); // 듣보잡의 수
        for(String name: hearSeaList)
            System.out.println(name); // 명단
    }
}