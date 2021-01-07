/*
 * 1. 풀이시간 : 1시간 초과
 * 2. 풀이방법 : 숫자에 해당하는 문자열을 map에 넣고, 해당 숫자를 key값으로 문자열을 불러와 처리하는 형식
                재귀를 사용해서 digits의 크기만큼 depth를 들어감. 그 이후 한 depth씩 빠져나오면서 다시 재귀호출을 함
 * 3. 예상 시간복잡도 : ??
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> lettersMap = new HashMap<Integer, String>();  //숫자에 해당하는 문자 배열을 넣는 map
        List<String> result = new ArrayList<String>();
        char[] num = new char[digits.length()];
        //digits를 문자 하나씩 자르기
        for(int i=0; i<digits.length(); i++){
            num[i] = digits.charAt(i);
        }
        
        //digits 값이 없을 경우 빈 값이 출력
        if(digits.isEmpty())
            return result;
        
        //번호에 맞는 문자들 mapping
        String[] collections = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i=0; i<digits.length(); i++){   //digits=23 <- 2, 3
            lettersMap.put(i, collections[num[i]-'0']);
        }
        
        combination(lettersMap, result, 0, digits.length(), "");
        return result;
    }
    
    public static void combination(HashMap<Integer, String> lettersMap, List<String> result, int start, int end, String letter){
        //가장 마지막 depth까지 오면 리스트에 결과값 담음
        if(start == end){
            result.add(letter);
            return;
        }
        
        String item = lettersMap.get(start);
        for(int i=0; i<item.length(); i++){
            letter += item.charAt(i);
            combination(lettersMap, result, start+1, end, letter);  //재귀 호출
            letter = letter.substring(0,letter.length()-1);     //substring(0,0) -> 0위치부터 0전까지 문자열 발췌이므로 공백이 나옴!!
        }
    }
}