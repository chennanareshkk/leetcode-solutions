class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;

        // counting sum till 0 to k-1 index
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }

        // check if the first window satisfy the condition
        if(sum/k >= threshold){
            count++;
        }

        // using sliding window to check if other windows satisfies the condition
        for(int right = k; right < arr.length; right++){
            int left = arr[right - k];
            sum += arr[right] - left;
            int avg = sum/k;
            if(avg >= threshold){
                count++;
            }
        }
        
        return count;
    }
}
