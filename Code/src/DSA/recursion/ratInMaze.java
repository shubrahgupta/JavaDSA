package DSA.recursion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ratInMaze {
    public static void main(String args[])throws IOException
    {
//        Scanner sc = new Scanner(System.in);
        int N = 4;
        int[][] m = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        ArrayList<String> arr = Solution13.findPath(m,N);
        for(String i: arr) {
            System.out.println(i);
        }
        System.out.println();


    }
}

class Solution13 {
    static ArrayList<String> lit;
    public static ArrayList<String> findPath(int[][] m, int n) {
        lit = new ArrayList<>();
        StringBuilder op = new StringBuilder();
        ArrayList<List<Boolean>> visited = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            ArrayList<Boolean> row = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                row.add(false);
            }
            visited.add(row);
        }
//        System.out.println(visited);
        solve(m,0,0,op,visited);
        if (lit.isEmpty())
            lit.add("-1");
        return lit;
    }
    public static boolean isForbidden(int x, int y, int[][] m) {
        if (x < 0 || y < 0 || x > m.length-1 || y > m[0].length - 1) {
            return true;
        }
        else if (m[x][y] == 0) {
            return true;
        }
        return false;

    }
    public static void solve(int[][] m, int x, int y, StringBuilder op, ArrayList<List<Boolean>> visited) {

        if (isForbidden(x,y,m)) {
            System.out.println(x + " " + y + " is forbidden");
            return;
        }
        else if (visited.get(x).get(y)) {
            System.out.println(x + " " + y + " is visited");
            return;
        }
        else if (x == m.length-1 && y == m[0].length - 1) {
            System.out.println(x + " " + y + " is complete");
            lit.add(op.toString());
            return;
        }
        System.out.printf("Currently on : %d, %d", x, y);
        visited.get(x).set(y,true);
        System.out.println();
        ArrayList<Character> dir = new ArrayList<>(Arrays.asList('D','U','L','R'));
        for (char d: dir) {
            if (d == 'U') {
                x--;
                if (!isForbidden(x,y,m)) {
//                    visited.get(x).set(y,true);

                    op.append(d);
//                    visited.get(x).set(y,true);
                    solve(m,x,y,op,visited);
//                    visited.get(x).set(y,false);
                    x++;

                    op.deleteCharAt(op.length()-1);
//                    visited.get(x).set(y,false);
                }
                else {
                    x++;
                }


            }
            else if (d == 'D') {
                x++;
                if (!isForbidden(x,y,m)) {
//                    visited.get(x).set(y,true);
//                    x++;
                    op.append(d);
//                    visited.get(x).set(y,true);
                    solve(m,x,y,op,visited);
//                    visited.get(x).set(y,false);
                    x--;
                    op.deleteCharAt(op.length()-1);
//                    visited.get(x).set(y,false);
                }
                else {
                    x--;
                }


            }
            else if (d == 'L') {
                y--;
                if (!isForbidden(x,y,m)) {
//                    visited.get(x).set(y,true);

//                    visited.get(x).set(y,true);
                    op.append(d);
                    solve(m,x,y,op,visited);
//                    visited.get(x).set(y,false);
                    y++;
                    op.deleteCharAt(op.length()-1);
//                    visited.get(x).set(y,false);
                }
                else {
                    y++;
                }


            }
            else {
                y++;
                if (!isForbidden(x,y,m)) {
//                    visited.get(x).set(y,true);

//                    visited.get(x).set(y,true);
                    op.append(d);
                    solve(m,x,y,op,visited);
//                    visited.get(x).set(y,false);
                    y--;
                    op.deleteCharAt(op.length()-1);
//                    visited.get(x).set(y,false);
                }
                else {
                    y--;
                }


            }
        }
        visited.get(x).set(y,false);

    }
}