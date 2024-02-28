import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public int romanToInt(String s) {



            int result = 0;
            int prev = 0;

            for (int i = 0; i < s.length(); i++) {
                int curr = 0;
                switch (s.charAt(i)) {
                    case 'I':
                        curr = 1;
                        break;
                    case 'V':
                        curr = 5;
                        break;
                    case 'X':
                        curr = 10;
                        break;
                    case 'L':
                        curr = 50;
                        break;
                    case 'C':
                        curr = 100;
                        break;
                    case 'D':
                        curr = 500;
                        break;
                    case 'M':
                        curr = 1000;
                        break;

                }
                if (curr > prev) {
                    result += curr - 2 * prev;
                } else {
                    result += curr;
                }
                prev = curr;
            }

            return result;


    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        int[] rest = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            rest[i - 1] = nums[i];
        }
        List<List<Integer>> subPermutations = permute(rest);

        for (List<Integer> subPermutation : subPermutations) {
            for (int i = 0; i <= subPermutation.size(); i++) {
                List<Integer> permutation = new ArrayList<>(subPermutation);
                permutation.add(i, nums[0]);
                result.add(permutation);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // test your code here!
    }
}