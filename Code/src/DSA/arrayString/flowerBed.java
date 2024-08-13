package DSA.arrayString;

public class flowerBed {
    public static void main(String[] args) {
        int[] flowerBed = new int[]{1,0,0,0,1};
        int n = 2;
        flowerBed f = new flowerBed();
        boolean bb = f.canPlaceFlowers(flowerBed, n);
        System.out.println(bb);
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        if (flowerbed.length == 1 && flowerbed[0] == 0) return true;
        else if (flowerbed.length == 1 && flowerbed[0] == 1) return false;
        if (flowerbed[1] == 0 && flowerbed[0] == 0) {n--;flowerbed[0] = 1;}
        if (flowerbed[flowerbed.length-1] == 0 && flowerbed[flowerbed.length-2] == 0) {n--;flowerbed[flowerbed.length-1] = 1;}
        for(int i = 1; i < flowerbed.length-1; i++) {
            if (flowerbed[i] == 0) {
                if (flowerbed[i-1] == 0 && (flowerbed[i+1] == 0)) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}
