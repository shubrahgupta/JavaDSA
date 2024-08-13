package DSA.arrayString;

public class increasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = {20,100,10,12,5,13};
        increasingTripletSubsequence its = new increasingTripletSubsequence();
        boolean answer = its.increasingTriplet(nums);
        System.out.println(answer);
    }
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for(int i: nums) {
            if (i <= small) small = i;
            else if (i <= mid) mid = i;
            else return true;
        }
        return false;

    }
}
