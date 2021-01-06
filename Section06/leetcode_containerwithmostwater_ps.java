package week2;

/*
 * 1. 풀이시간 : 15분
 * 
 * 2. 풀이 방법 : 넓이는 길이 * 높이 이기때문에 양쪽에서 사각형을 형성하여 크기를 비교한다.
 * 				높이는 짧은 쪽을 선택하기 때문에 값이 변하는 짧은 높이에 변화를 주어 넓이 비교. 
 * 
 * time complexity: O(N)
 * space complexity : O(1)
 */


public class leetcode_containerwithmostwater_ps {
	public static void main (String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
		
	}
	
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
        	maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right-left));
        	// container 의 area 는 base (right - left) * height (작은 수 기준)
        	
        	// 긴 수를 기준으로 작은 쪽을 움직인다. 
        	if(height[left]< height[right] ) left++; 
        	else right--;
        }
        return maxArea;
    }
}
