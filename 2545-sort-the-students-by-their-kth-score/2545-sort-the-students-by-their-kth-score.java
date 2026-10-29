class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int n = score.length;
        int[][] temp = new int[n][];
        mergeSort(score, temp, 0, n - 1, k);
        return score;
    }
    private static void mergeSort(int[][] score, int[][] temp, int low, int high, int k){
        if(low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(score, temp, low, mid, k);
        mergeSort(score, temp, mid + 1, high, k);

        merge(score, temp, low, mid, high, k);
    }

    private static void merge(int[][] score, int[][] temp, int low, int mid, int high, int k){
        int i = low, j = mid + 1, p = low;
        while(i <= mid && j <= high){
            if(score[i][k] >= score[j][k]){
                temp[p++] = score[i++];
            }else{
                temp[p++] = score[j++];
            }
        }
        while(i <= mid){
            temp[p++] = score[i++];
        }

        while(j <= high){
            temp[p++] = score[j++];
        }

        for(int x = low; x <= high; x++){
            score[x] = temp[x];
        }

    }
}