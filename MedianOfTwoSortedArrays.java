class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // merge both the arrays
        int[] nums3 = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums3, 0, nums1.length);
        System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);

        // sort the concatenated array
        Arrays.sort(nums3);

        int len = nums3.length;

        // if length of array is even
        if (len % 2 == 0)
            return (nums3[len / 2] + nums3[len / 2 - 1]) / 2.0;

        // if length of array is odd
        else
            return nums3[len / 2];
    }
}
