package DSA.arrayString;

public class stringCompression {
    public static void main(String[] args) {
//        char[] ch = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] ch = {'a','b','b','b','b','b','c','c','a','a','p'};
        stringCompression sc = new stringCompression();
        System.out.println(sc.compress(ch));
        System.out.println(ch);

    }


    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;
            int j = i;
            while (j < chars.length ) {
                if (currentChar == chars[j]) {
                    count++;
                    j++;
                }
                else break;

            }
            sb.append(currentChar);
            if (count > 1) {
                sb.append(count);
            }

            i = j;
        }

        System.out.println(sb);
        for (int j = 0; j < sb.length(); j++) {
            chars[j] = sb.charAt(j);
        }

        return sb.length();
    }

}
