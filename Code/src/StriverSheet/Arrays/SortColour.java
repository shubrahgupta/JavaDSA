package StriverSheet.Arrays;

import java.util.Arrays;

public class SortColour {
    public static void main(String[] args) {
        SortColour q = new SortColour();
        int[] nums = {2,0,2,1,1,0};
        q.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int zp = 0, op = 0, tp = nums.length-1;
        while(op <= tp) {
            if (nums[op] == 0) {
                int temp = nums[op];
                nums[op] = nums[zp];
                nums[zp] = temp;
                op++; zp++;
            }
            else if(nums[op] == 1) {
                op++;
            }
            else {
                int temp = nums[op];
                nums[op] = nums[tp];
                nums[tp] = temp;
                tp--;
            }

        }
    }
}
