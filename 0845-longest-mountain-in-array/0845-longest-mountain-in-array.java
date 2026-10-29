class Solution {
    public int longestMountain(int[] arr) {
        int start = 0;
        int end = 0;
        int maxLength = 0;
        boolean hasUp = false, hasDown = false;
        while(end < arr.length - 1){
            if(arr[end] < arr[end + 1]){
                if(hasDown){
                    start = end;
                    hasUp = false;
                    hasDown = false;
                }
                hasUp = true;
            }else if(arr[end] > arr[end + 1]){
                if(hasUp) hasDown = true;
                else{
                    start = end + 1;
                }
            }else{
                start = end + 1;
                hasUp = false;
                hasDown = false;
            }

            if(hasUp && hasDown){
                maxLength = Math.max(maxLength, end - start + 2);
            }
            end++;
        }
        return maxLength;
    }
}