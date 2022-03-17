package class01;

import java.util.Arrays;

public class Code04_RandToRand {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            int l = (int)(Math.random()*100) + 1;
            int v = (int) (Math.random()*1000) +1;
            int[] ints = genArray(l, v);
            Arrays.toString(ints);
            System.out.println("=============");
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    //返回一个[0,X)的随机小数 x，x属于[0,X)，出现的概率由原来的概率p变为p的平方
    public static double xToXPower() {
        return Math.max(Math.random(), Math.random());
//        return Math.max(Math.random(),Math.random(),Math.random());  这是把概率调成三次方，注意：要去最大值，保证上边界在要求的范围内，如果是
        //如果是Math.min(Math.random(),Math.random(),Math.random())，则概率不对
    }


    /**
     * 算法题：
     * 1. 给定函数f(),在1~5上是等概率返回一个值，不借助其他函数设计出一个函数g()等概率返回1~7的随机数
     * 思路：先转成等概率0 1生成器，在通过二进制制造出等概率的g()
     */

    public static int f() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 将f()变成等概率0 1生成器
     *
     * @return
     */
    public static int f_gen0Or1() {

        int num = 0;
        do {
            num = f();
        } while (num == 3);
        return num < 3 ? 0 : 1;
    }

    /**
     * 等概率生成0~7的随机数
     *
     * @return
     */
    public static int f_gen0To7() {

        return (f_gen0Or1() << 2) + (f_gen0Or1() << 1) + (f_gen0Or1() << 0);//0~7的随机数 左移之后相加必须加()不然值不对
    }

    /**
     * 生成1~7的等概率随机数
     *
     * @return
     */
    public static int g() {
        int num = 0;
        do {
            num = f_gen0To7();
        } while (num == 7); //转成生成0~6的等概率随机数
        return num + 1;
    }

    /**
     * 算法题：
     * 2. 给定函数x(),已固定概率p返回0或1，写出y()以等概率返回0或1
     *  思路：
     *      0 ： p
     *      1 : 1-p
     *      调用两次x()
     *      0 0  p^2
     *      1 1  p^2
     *      1 0 p(1-p)
     *      0 1 p(1-p)
     *      随机两次如果，两次结果一直则重新随机，这样得到的结果就是等概率0 1
     */
    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    public static int y(){
        int num = 0;
        do {
            num = x();
        }while (x() == num);
        return num;
    }

    /**
     * 生成一个长度随机，值随机的数组
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static int[] genArray(int maxLength, int maxValue){
        int length = (int)(Math.random()*maxLength);
        int[] ints = new int[length];
        for (int i=0; i<ints.length ; i++){
            int randValue = (int) (Math.random()*maxValue);
            ints[i] = randValue;
        }
        return ints;
    }
}
