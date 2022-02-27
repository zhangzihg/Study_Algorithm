package class01;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 打印整数的二进制
 * int 类型打印出对应32位
 * long 类型打印出对应的64位
 *
 * 1.负数定义成取反加一就是为了底层的 + - *  / 运算能走一套逻辑
 * 2.负数最小值取反加一得到的相反数还是自己
 */
public class Code01_PrintB {
    public static void main(String[] args) {
        int i = 6676666;
//        System.out.println(Integer.toString(i, 2));
        System.out.println("======================");
        printBinary(i);
        /*  0111 1111 1111 1111 1111 1111 1111 1111
            所以整形表示的最大的数是 2^31-1; java中的int是有符号的，既能表示正又能表示负，所以第32位为符号位，剩余的31
            位几乎一半给了整数，一半给了负数；int的范围是 -2^31~2^31-1；负数最小能到第31位上，正数最大只能把30位占满变成1

        *   负数的表示：最高位是符号位，其他位数取反加一后的值就是负数的表示
        * -1的二进制： 1111 1111 1111 1111 1111 1111 1111 1111
        * 所以int的最小值二进制表示为： 1000 0000 0000 0000 0000 0000 0000 0000   取反加一后的值为-2^31
        *
        * 1000 0000 0000 0000 0000 0000 0000 0000
        * 0000 0000 0000 0000 0000 0000 0000 0000
        *
        * 上面抛开符号位来说都是十进制的0，由于在java中把0000 0000 0000 0000 0000 0000 0000 0000  分在了非负领域，而 1000 0000 0000 0000 0000 0000 0000 0000
         在负数领域表示了最小值所以由于0的存在导致正数的最大值少了一个；
        * */
        printBinary(Integer.MAX_VALUE);
        printBinary(-1);
        printBinary(Integer.MIN_VALUE);

        System.out.println("=======右移==========");

        int a = 1024;
        printBinary(a);
        printBinary(a >> 1); //带符号右移，最高位用符号位补
        printBinary(a >>> 1); // 不带符号位右移，最高位用0来补
        System.out.println("-----------");
         a = Integer.MIN_VALUE;
        printBinary(a);
        printBinary(a >> 1);
        printBinary(a >>> 1);
        System.out.println("================");

        /*
        *   负号也可以用 取反加一 进行表达
        *
        *   负数最小值取反加一得到的相反数还是自己，因为正数的最大值比负数的最小值的绝对值小，所以
        * 正数会有一一对应的负数，而负数的最小值没有对应的正数
        * */
        int b = 5;
        int b1 = -b;
        int b2 = ~b + 1;
        System.out.println(b);
//        System.out.println(b1);
        System.out.println(b2);
        System.out.println("------------");

        int c = Integer.MIN_VALUE;
        int c1 = ~c + 1;
        int c2 = -c;
        System.out.println(c);
        System.out.println(c1);
        System.out.println(c2);
    }

    /**
     * 打印出int类型的32位二进制
     * 解决思路：
     * 计算机底层的数字都是二进制表示的，只要利于 1&1=1 1&0=0 的与运算即可完成
     *
     * @param num
     */
//    @SuppressWarnings("all")
    public static void printBinary(Object num) {
        int bitCounts = 31;
        if (num instanceof Long) {
            bitCounts = 63;
            long num1 = (Long) ((Long) num).longValue();

            for (int i = bitCounts; i >= 0; i--) {
                if ((i + 1) % 4 == 0) {
                    System.out.print(" ");
                }
                // 注意这里如果传入的是long类型，1L << i 一定要加L,不然程序不对
                System.out.print((num1 & (1L << i)) == 0 ? "0" : "1");
            }

            System.out.println();

        } else if (num instanceof Byte) {
            bitCounts = 7;
            byte num1 = (Byte) ((Byte) num).byteValue();

            for (int i = bitCounts; i >= 0; i--) {
                if ((i + 1) % 4 == 0) {
                    System.out.print(" ");
                }
                System.out.print((num1 & (1 << i)) == 0 ? "0" : "1");
            }

            System.out.println();
        } else if (num instanceof Character) {
            bitCounts = 15;
            char num1 = (Character) ((Character) num).charValue();

            for (int i = bitCounts; i >= 0; i--) {
                if ((i + 1) % 4 == 0) {
                    System.out.print(" ");
                }
                System.out.print((num1 & (1 << i)) == 0 ? "0" : "1");
            }

            System.out.println();
        } else if (num instanceof Integer) {
            int num1 = (Integer) ((Integer) num).intValue();

            for (int i = bitCounts; i >= 0; i--) {
                if ((i + 1) % 4 == 0) {
                    System.out.print(" ");
                }
                System.out.print((num1 & (1 << i)) == 0 ? "0" : "1");
            }

            System.out.println();
        } else {
            System.out.println("请输入一个正整数！");
        }
    }

}
