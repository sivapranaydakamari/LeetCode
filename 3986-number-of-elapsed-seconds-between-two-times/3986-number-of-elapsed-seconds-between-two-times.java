class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return genString(endTime) - genString(startTime);
    }
    private int genString(String time){
        int hours = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        int mins = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        int secs = (time.charAt(6) - '0') * 10 + (time.charAt(7) - '0');
        return (hours * 3600) + (mins * 60) + secs;
    }
}