package DSA.recursion;

public class print_n {

    private void print_n_rec(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        print_n_rec(n-1);
        System.out.println(n);
    }
    private void print_n_rev_rec(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        print_n_rev_rec(n-1);
    }


    public static void main(String[] args) {
        print_n obj = new print_n();
        obj.print_n_rev_rec(7);
    }
}
