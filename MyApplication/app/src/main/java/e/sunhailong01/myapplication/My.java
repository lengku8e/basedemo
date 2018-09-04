package e.sunhailong01.myapplication;

public class My{

    private static int[] arrPartition;
    /**
     * 快排
     * @param arr n元数组
     * @param lowIndex 最小index
     * @param highIndex 最大index
     * @return
     */
    public static int arrPartition(int[] arr, int lowIndex, int highIndex){
        int temp=arr[lowIndex];
        while(lowIndex<highIndex){
            while(arr[highIndex]<=temp&&highIndex>lowIndex) {
                --highIndex;
            }

            arr[lowIndex]=arr[highIndex];
            while(arr[lowIndex]>=temp&&lowIndex<highIndex) {
                ++lowIndex;
            }

            arr[highIndex]=arr[lowIndex];
        }
        arr[highIndex]=temp;
        arrPartition = arr;
        return highIndex;
    }

    /**
     *
     * @param k 前k大的数
     * @param arr 无序数组
     * @param lowIndex
     * @param highIndex
     */
    public static void getMaxK(int k, int[] arr, int lowIndex, int highIndex){
        int temp = arrPartition(arr, lowIndex, highIndex);
        if(temp == k-1){
            for (int i = 0 ; i < k;i++) {
                System.out.print("第"+i+"大的数是："+arrPartition[i]);
            }
        }else if(temp>k-1){
            getMaxK(k,arr,lowIndex,temp-1);
        }else{
            getMaxK(k,arr,temp+1,highIndex);
        }


    }


    public static void main(String[] args) {
        int[] myArr={3,1,2,5,4,7,6};
        getMaxK(3, myArr, 0,myArr.length - 1);
    }

}
