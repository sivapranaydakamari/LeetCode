class Solution {
    public String simplifyPath(String path) {
        Deque<String> dq = new ArrayDeque<>();
        String[] parts = path.split("/");
        for(String part: parts){
            if(part.isEmpty() || part.equals(".")) continue;
            else if(part.equals("..")){
                if(!dq.isEmpty()){
                    dq.pollLast();
                }
            }else dq.offerLast(part);
        }
        StringBuilder canonicalPath = new StringBuilder();
        for(String part: dq){
            canonicalPath.append("/").append(part);
        }
        return canonicalPath.length() == 0 ? "/" : canonicalPath.toString();
    }
}