class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        
        int n = nums1.length;
        int m = nums2.length;

        int[] res = new int[n+m];

        int index =0;
        for(int i=0;i<nums1.length;i++) {
            res[index++] = nums1[i];
        }

        for(int i=0;i<nums2.length;i++) {
            res[index++] = nums2[i];
        }

        Arrays.sort(res);
        System.out.println(Arrays.toString(res));
        if((n+m)%2==0) {
            //this is even
            int i = (n+m)/2;
            System.out.println(i);
            double x = (res[i-1] + res[i])/2.0;
            return x;
        }else {
            int i = (n+m)/2;
            System.out.println(i);
            return (double)(res[i]);
        }
    }
}
