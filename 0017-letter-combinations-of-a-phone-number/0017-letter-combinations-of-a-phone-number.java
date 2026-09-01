class Solution {
    String[] letters_map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> combinations = new ArrayList<>();
    private void letterCombinationsOfDigits(String digits, int i, int end, List<String> ds){
        if(i == end){
            String combination = String.join("", ds);
            combinations.add(combination);
            return;
        }
        int digit = digits.charAt(i) - '0';
        String letters = letters_map[digit];
        for(int j = 0; j < letters.length(); j++){
            ds.add("" + letters.charAt(j));
            letterCombinationsOfDigits(digits, i + 1, end, ds);
            ds.remove(ds.size() - 1);
        }

    }
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        List<String> ds = new ArrayList<>();
        letterCombinationsOfDigits(digits, 0, digits.length(), ds);
        return combinations;
    }
}