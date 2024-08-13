package DSA.twoPointers;

public class maxAreaQ {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        maxAreaQ maq = new maxAreaQ();
        int maxArea = maq.maxArea(height);
        System.out.println(maxArea);
    }
    public int maxArea(int[] height) {
        int st = 0, end = height.length-1, area = 0;
        while(st <= end) {
            area = Math.max(area, Math.abs((end-st) * (Math.min(height[end],height[st]))));
            if (height[st] <= height[end]) {
                st++;
            }
            else {
                end--;
            }


        }
        return area;
    }
}
