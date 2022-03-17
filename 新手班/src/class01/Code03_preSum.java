package class01;

/**
 *  前缀和数组
 *  一个数组需要频繁求范围L~R直接的和
 */
public class Code03_preSum {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        PreSum preSum = new PreSum(a);
        preSum.printPreSum();
        System.out.println(preSum.sum(0, 2));
        System.out.println(preSum.sum(2, 3));
    }

    public static class  PreSum{
        private  int[] preSum;

        public PreSum(int[] arr){
            //初始化前缀数组
            int N = arr.length;
            preSum = new int[N];
            preSum[0] = arr[0];
            for (int i=1; i<N; i++){
                preSum[i] = preSum[i-1] + arr[i];
            }
        }

        public  int sum(int L, int R){
            return L==0 ? preSum[R] : preSum[R] - preSum[L-1];
        }

        public void printPreSum(){
            for (int i : preSum) {
                System.out.print( i + " ");
            }
            System.out.println();
        }
    }
}
