class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for(int i = 0; i <= rowIndex; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }
                else{
                    int val = arr.get(i-1).get(j-1)+arr.get(i-1).get(j);
                    row.add(val);
                }
            }
            arr.add(row);
        }
        return arr.get(rowIndex);
    }
}