package DSA.treeGraphs;

public class Pair<X, Y> {
    private X x;
    private Y y;

    public Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
    }

    public X getFirst() {
        return x;
    }

    public Y getSecond() {
        return y;
    }

    public void setFirst(X x) {
        this.x = x;
    }

    public void setSecond(Y y) {
        this.y = y;
    }
}
