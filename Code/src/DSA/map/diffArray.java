package DSA.map;

import java.util.*;

public class diffArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3}, nums2 = {2,4,6};
        diffArray dA = new diffArray();
        List<List<Integer>> lli = dA.findDifference(nums1, nums2);
        System.out.println(lli);
    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> lli = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for (int j : nums1) {
            s.add(j);
        }
        for (int j : nums2) {
            s.remove(j);
        }
        List<Integer> l1 = new ArrayList<>(s);
        lli.add(l1);
        s.clear();;
        for (int j : nums2) {
            s.add(j);
        }
        for (int j : nums1) {
            s.remove(j);
        }
        l1 = new ArrayList<>(s);
        lli.add(l1);

        return lli;

    }
}
