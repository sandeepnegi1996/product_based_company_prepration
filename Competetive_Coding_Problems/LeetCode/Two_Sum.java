import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

//1. BruteForce Approach
/*
class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        int result[]=new int[2];
        Arrays.fill(result, 0);
        int difference=0;
        for (int i = 0; i < nums.length-1; i++) {
            difference=target-nums[i];

            for (int j = i+1; j < nums.length; j++) {

                if (difference==nums[j]) {
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
       return result;  
    }
}
*/
//2. Using Hashing
//The problem which is arrising is that when I am searching for the difference value that value is searched from the starting 
//but I want it to be searched from the next element

// class Solution {
    
//     public int[] twoSum(int[] nums, int target) {
//         int result[]=new int[2];
//         Arrays.fill(result, 0);
//         int difference=0;
//         Hashtable<Integer,Integer> map=new Hashtable<>();

//         for (int i = 0; i < nums.length; i++) {
//             map.put(i, nums[i]);  
//         }

//         for (int i = 0; i < nums.length; i++) {
//                 //find the value corresponding to particular key in java
//                 //Query1 

//                 if (nums[i]>target) {
//                     continue;
                    
//                 }
//                 else {
//                 difference=target-nums[i];
//                 if (map.containsValue(difference)) {
//                     result[0]=i;
                 
//                     for ( Map.Entry<Integer,Integer> entry:map.entrySet()) {
//                         if (difference==entry.getValue()) {
//                             result[1]=entry.getKey();
//                             break;   
//                         }
//                     }
//                     break;   
//                 }

//             }
//         }
// //            System.out.println(result[0]+"  "+result[1]);

//        return result;  
//     }
// }


class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int complement=0;
        for (int i = 0; i < nums.length; i++) {
            complement=target-nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement),i};
                
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};

    }
}


class test{
    public static void main(String[] args) {
        Solution s1=new Solution();
        int nums[]={3,2,4};
        int target=9;
        int results[]=new int[2];
        results=s1.twoSum(nums,9);
        for (int i : results) {
            System.out.println(i);
            
        }

        //System.out.println("hello world");
    }
}