package 스터디.스터디_SNU.Section17;

import java.util.*;
import java.util.stream.Collectors;

/*
1. 문제 풀이 시간: 초과
2. 컴퓨팅 사고
(1) 인덱스값, 장르 이름, 장르 재생횟수를 담고있는 클래스를 하나 선언합니다.
Comparable과 Comparator을 사용하여 다음과 같은 조건을 충족시킵니다.
속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
즉, 장르이름이 같은 경우는 비용이 더 큰 값이 먼저 오게 하고 그게 아니라면 맵에 담긴 값들중에서 내림차순으로 정렬을 진행합니다.
재생횟수가 같다면 인덱스값이 더 작은값이 오도록 합니다.
(2) 장르별 재생횟수를 담고 있는 map을 사용합니다
(3) 앨범을 2곡씩 수록해야하므로 이것을 체크하는 map을 하나 담아주고 2개이상을 만족하지 않는다면 해당 곡의 id값을 최종 결과값으로 담아줍니다.

3. 시간복잡도
O(N) + O(Sort)
 */
public class programmers_베스트앨범_kgh {
    public static void main(String[] args) {
        solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500});
    }
    static List<Integer> solution(String[] genres, int[] plays){
        List<SongAlbum> songList = new ArrayList<>();
        List<Integer> songBestList = new ArrayList<>();
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, Integer> albumMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            int id = i;
            String genre = genres[i];
            int play = plays[i];
            songList.add(new SongAlbum(id, genre, play));
            if(genreMap.containsKey(genre)) genreMap.put(genre, genreMap.get(genre)+play);
            else genreMap.put(genre, play);
        }
        Collections.sort(songList, new Comparator<SongAlbum>() {
            @Override
            public int compare(SongAlbum o1, SongAlbum o2) {
                // 장르 이름이 같은 경우
                if(o1.genreName.equals(o2.genreName)){
                    // 비용이 큰 순서대로
                    return Integer.compare(o2.playCount, o1.playCount);
                }
                // 장르 이름이 다른 경우
                else {
                    // 내림 차순 정렬
                    return Integer.compare(genreMap.get(o2.genreName),genreMap.get(o1.genreName));
                }
            }
        });
        for (SongAlbum songAlbum : songList) {
            if(!albumMap.containsKey(songAlbum.genreName)){
                albumMap.put(songAlbum.genreName, 1);
                songBestList.add(songAlbum.id);
            }else {
                if(albumMap.get(songAlbum.genreName) >= 2){
                    continue;
                }else {
                    albumMap.put(songAlbum.genreName, albumMap.get(songAlbum.genreName)+1);
                    songBestList.add(songAlbum.id);
                }
            }
        }
        for (Integer integer : songBestList) {
            System.out.println("integer = " + integer);
        }
        int[] answer = new int[songBestList.size()];
        for (int i = 0; i < songBestList.size(); i++) answer[i] = songBestList.get(i);
        return Arrays.stream(answer).boxed().collect(Collectors.toList());
    }
    static class SongAlbum implements Comparable<SongAlbum>{
        int id;
        String genreName;
        int playCount;

        public SongAlbum(int id, String genreName, int playCount) {
            this.id = id;
            this.genreName = genreName;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(SongAlbum o) {
            if(this.playCount == o.playCount){
                return Integer.compare(this.id, o.id);
            }else {
                return Integer.compare(o.playCount, this.playCount);
            }
        }
    }
}
