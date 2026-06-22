class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int nums2ArrayLargestPointer = n - 1;
        int nums1ArrayLargestPointer = m - 1;
        int nums1ArrayLastPointer = m + n - 1;

        while (nums2ArrayLargestPointer >= 0) {

            if (nums1ArrayLargestPointer >= 0 &&
                nums1[nums1ArrayLargestPointer] > nums2[nums2ArrayLargestPointer]) {

                nums1[nums1ArrayLastPointer--] =
                    nums1[nums1ArrayLargestPointer--];

            } else {

                nums1[nums1ArrayLastPointer--] =
                    nums2[nums2ArrayLargestPointer--];
            }
        }
    }
}