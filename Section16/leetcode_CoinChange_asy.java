package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode_CoinChange {
	static List<Integer> resultList;

	public static void main(String[] args) {
//		int[] coins = { 1, 3, 5, 6, 9 };
//		int amount = 17;
		int[] coins = { 1, 2, 5 };
		int amount = 11;
//		int[] coins = { 1 };
//		int amount = 0;
//		int[] coins = { 2 };
//		int amount = 3;
//		int[] coins = { 1 };
//		int amount = 1;
//		int[] coins = { 1 };
//		int amount = 2;
//		int[] coins = {1,2147483647};
//		int amount = 2;
		
		int result = 0;
		resultList = new ArrayList<Integer>();

		if (amount == 0) {
			resultList.add(0);
		}

		for (int i = coins.length - 1; i >= 0; i--) {
			if ((amount - coins[i]) == 0) {
				result++;
				resultList.add(result);
				break;
			}
//			amount -= coins[i];
			if(amount - coins[i] >= 0) {
				result++;
				backtraking(coins, i, amount - coins[i], result);
			}
		}
		if(resultList.isEmpty()) {
			resultList.add(-1);
		}
		
		Collections.sort(resultList);
		System.out.println(resultList.get(0));
	}

	private static void backtraking(int[] coins, int index, int amount, int result) {
		if (amount == 0) {
			resultList.add(result);
			return;
		}

		for (int i = coins.length - 1; i >= 0; i--) {
			int minusCoin = coins[i];
			if ((amount - coins[i]) >= 0) {
//				System.out.println(coins[i]);
//				amount -= minusCoin;
				result++;
				backtraking(coins, i, amount - coins[i], result);
				result--;
			}
		}
	}

}
