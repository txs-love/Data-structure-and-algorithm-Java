package org.LeetCode;

/**
 * 给定两个大的小分别为m和n的正序（从小到大）数组 nums1和 nums2
 * 请你找出并返回这两个正序数组的中位数。
 */
public class Code4 {
    public static void main(String[] args) {
        Code4 code = new Code4();
        int []m = new int[]{4,2,19};
        int []n = new int[]{1};
        double ans = code.findMedianSortedArrays(m, n);
        System.out.println(ans);

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //将两个数组合并,两个有序数组合并以后在查看元素奇数还是偶数进行相交;
        int nums[];
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        //下面是有一个数组为0的两种情况;
        if (m == 0) {   //数组nums1为空的情况下面;
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n==0){  //数组nums2为空的情况下面;
            if (m % 2 ==0){
                return (nums1[m/2-1] +nums1[m/2]) / 2.0;
            }else {
                return nums1[m/2];
            }
        }
        int count = 0;
        int i=0,j=0;
        while (count!=(m+n)){
            if (i==m){
                while (j!=n){
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j==n){
                while (i!=m){
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i]<nums2[j]){
                nums[count++] = nums1[i++];
            }else {
                nums[count++] = nums2[j++];
            }
        }
        if (count % 2==0){
            return (nums[count/2-1] + nums[count/2])/2.0;
        }else {
            return nums[count/2];
        }
    }

}
