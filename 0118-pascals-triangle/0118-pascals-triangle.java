class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0; i<=numRows-1; i++){
            ArrayList<Integer> innerArr = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    innerArr.add(1);
                }
                else{
                    int val = arr.get(i-1).get(j-1)+arr.get(i-1).get(j);
                    innerArr.add(val);
                }
            }
            arr.add(innerArr);
        }
        return arr;
    }
}