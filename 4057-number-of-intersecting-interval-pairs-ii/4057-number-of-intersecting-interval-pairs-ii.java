class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        // sweep-line algorithm where we think in a vertical line of events 
        // example: [[25, 83], [48, 50], [60, 74]]
        // 25     48   50    60     74        83
        // |      |----|     |------|         |
        // |----------------------------------|
        // first we need to seperate the coordinates and sort them based in the points first if same then needs to go with event type(start or end) then the start needs to come first next end
        // then procces the events if start means increase start count and intersections else decrease the start count had the point is ended

        int n = intervals.length;
        int[][] events = new int[2 * n][2];
        int vals = 0;
        for(int i = 0; i < n; i++){
            events[vals++] = new int[]{intervals[i][0], 1};
            events[vals++] = new int[]{intervals[i][1], -1};
        }

        Arrays.sort(events, (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });
        // for(int[] event: events) System.out.println(event[0] + "," + event[1]);

        long startLeft = 0, intersections = 0;
        for(int[] event: events){
            int eType = event[1];
            if(eType == 1){
                intersections += startLeft;
                startLeft++;
            }else{
                startLeft--;
            }
        }
        return intersections;
    }
}