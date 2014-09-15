package leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		Map map = new HashMap();
		for (int i=0;i<numbers.length;i++){
			map.put(numbers[i], i+1);
		}
		int[] result = new int[2];
		int dif =0;
        for (int i=0;i<numbers.length;i++){
        	dif = target-numbers[i];
        	if (dif>0 && map.get(dif)!=null){
        		result[0]=i+1;
    			result[1]=(int) map.get(dif);
    			return result;
        	}
        }
        return null;
    }
	
	@Test
	public void test(){
		long pre= System.currentTimeMillis();
		TwoSum t = new TwoSum();
		int[] s = {0,4,3,0};
		int[] r = t.twoSum(s, 0);
		System.out.println(String.valueOf(r[0])+'-'+String.valueOf(r[1]));
		long post= System.currentTimeMillis();
		System.out.println(post-pre);
	}
}
