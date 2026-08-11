class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length, n = nums2.length;
        int totalLeft = (m + n + 1) / 2; 
        
        int lo = 0, hi = m;
        
        while (lo <= hi) {
            int partition1 = (lo + hi) / 2;       
            int partition2 = totalLeft - partition1; 
            int left1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int right1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            
            int left2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int right2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
            
            if (left1 <= right2 && left2 <= right1) {
                // Correct partition found
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                } else {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
            } else if (left1 > right2) {
                
                hi = partition1 - 1;
            } else {
              
                lo = partition1 + 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted, or invalid input");
    }
}