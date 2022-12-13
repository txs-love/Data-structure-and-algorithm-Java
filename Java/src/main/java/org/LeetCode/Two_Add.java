package org.LeetCode;

public class Two_Add {
    public static void main(String[] args) {
        Two_Add two = new Two_Add();
        int [] arr = new int[]{2,3,6,1};
        int [] ans = two.twoSum(arr,9);
        System.out.println(ans);

    }
    public int[] twoSum(int[] num, int target) {
        for (int i=0;i< num.length;i++){
            for (int j=i+1;j< num.length;j++){
                if (num[i]+num[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}
