package DSA.map;
import java.util.*;

public class uniqueNumberOfOccurences {
    public static void main(String[] args) {
        int[] arr = {1,2};
        uniqueNumberOfOccurences q = new uniqueNumberOfOccurences();
        System.out.println(q.uniqueOccurrences(arr));
    }
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i: arr) {
            if (m.containsKey(i)) {
                m.put(i, m.get(i)+1);
            }
            else {
                m.put(i, 1);
            }

        }
        System.out.println(m);
        Set<Integer> s = new HashSet<>(m.values());
        System.out.println(s);
        return s.size() == m.keySet().size();
    }
}
