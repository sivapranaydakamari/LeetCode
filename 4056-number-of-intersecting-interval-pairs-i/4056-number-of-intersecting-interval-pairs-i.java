class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int intersections = 0;
        for(int i = 1; i < intervals.length; i++){
            for(int left = 0; left < i; left++){
                if(intervals[i][0] <= intervals[left][1]) intersections++;
            }
        }
        return intersections;
    }
}