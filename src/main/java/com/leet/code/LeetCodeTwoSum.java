package com.leet.code;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCodeTwoSum {

    /**
     * 方法一：暴力法
     * 复杂度分析：
     * <p>
     * 时间复杂度：O(n^2)O(n2)
     * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n)O(n) 的时间。因此时间复杂度为 O(n^2)O(n2)。
     * <p>
     * 空间复杂度：O(1)O(1)。
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法二：两遍哈希表
     * 复杂度分析：
     * <p>
     * 时间复杂度：O(n)O(n)，
     * 我们把包含有 nn 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1)O(1) ，所以时间复杂度为 O(n)O(n)。
     * <p>
     * 空间复杂度：O(n)O(n)，
     * 所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 nn 个元素。
     */
    public static int[] towSum2(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            // 获取差值
            int complement = target - nums[i];
            // 在numsMap中寻找差值是否存在
            if (numsMap.containsKey(complement) && numsMap.get(complement) != i) {
                return new int[]{i, numsMap.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法三：一遍哈希表
     * 复杂度分析：
     *
     * 时间复杂度：O(n)O(n)，
     * 我们只遍历了包含有 nn 个元素的列表一次。在表中进行的每次查找只花费 O(1)O(1) 的时间。
     *
     * 空间复杂度：O(n)O(n)，
     * 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 nn 个元素。
     *
     */
    public static int[] towSum3(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 获取差值
            int complement = target - nums[i];
            // 在numsMap中寻找差值是否存在
            if (numsMap.containsKey(complement)) {
                return new int[]{i, numsMap.get(complement)};
            }
            // 将当前值放入集合
            numsMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] result1 = twoSum1(new int[]{3, 3}, 6);
        System.out.println("int[] result = " + Arrays.toString(result1));

        int[] result2 = towSum2(new int[]{3, 3}, 6);
        System.out.println("int[] result = " + Arrays.toString(result2));

        int[] result3 = towSum3(new int[]{3, 3}, 6);
        System.out.println("int[] result = " + Arrays.toString(result3));
    }

}
