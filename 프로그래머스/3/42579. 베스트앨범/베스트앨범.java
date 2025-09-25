import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> genreTotalMap = new HashMap<>(); // <장르, 총 재생 횟수>, {pop=3100, classic=1450}

        
        HashMap<String, ArrayList<Integer>> genreMap = new HashMap<>(); // <장르, 고유번호>, {pop=[4, 1], classic=[3, 0, 2]}
        
        for (int i = 0; i < genres.length; i++) {
            genreTotalMap.put(genres[i], genreTotalMap.getOrDefault(genres[i], 0) + plays[i]);
            genreMap.putIfAbsent(genres[i], new ArrayList<>());
            genreMap.get(genres[i]).add(i); // 고유번호(i)를 추가
        }
        System.out.println(genreTotalMap);
        
        // 각 장르별 노래 정렬
        for (String genre : genreMap.keySet()) {
            Collections.sort(genreMap.get(genre), (a, b) -> {
                if (plays[a] == plays[b]) {
                    return a - b; // 고유번호 오름차순
                }
                return plays[b] - plays[a]; // 재생 횟수 내림차순
            });
        }
        
        // 장르별 총합 정렬 [pop, classic]
        List<String> sortedGenres = genreTotalMap.entrySet()
            .stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // 총 재생 횟수 내림차순
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        System.out.println(sortedGenres);
        System.out.println(genreMap);

        // 장르별 상위 2곡 추가
        for (String genre : sortedGenres) {
            List<Integer> songs = genreMap.get(genre);
            for (int j = 0; j < Math.min(2, songs.size()); j++) {
                answer.add(songs.get(j));
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
