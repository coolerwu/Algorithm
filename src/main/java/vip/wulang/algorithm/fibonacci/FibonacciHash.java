package vip.wulang.algorithm.fibonacci;

/*
magic: 1640531527
magic(double): 2.6544357694972305E9
magic(long): 2654435769
magic(int): -1640531527
 */
public class FibonacciHash {
    public static void main(String[] args) {
        System.out.println("magic: " + 0x61c88647);
        double magicD = (1L << 32) * ((Math.sqrt(5) - 1) / 2);
        System.out.println("magic(double): " + magicD) ;
        long magicL = (long) ((1L << 32) * ((Math.sqrt(5) - 1) / 2));
        System.out.println("magic(long): " + magicL);
        int magicI = (int) magicL;
        System.out.println("magic(int): " + magicI);
    }
}
