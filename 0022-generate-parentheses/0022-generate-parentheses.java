class Solution {
    private List<String> parentheses = new ArrayList<>();

    private void generate(StringBuilder str, int openCount, int closeCount, int n){
        if(str.length() == n * 2){
            parentheses.add(str.toString());
            return;
        }

        if(openCount < n){
            str.append('(');
            generate(str, openCount + 1, closeCount, n);
            str.deleteCharAt(str.length() - 1);
        }
        if(closeCount < openCount){
            str.append(')');
            generate(str, openCount, closeCount + 1, n);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        generate(new StringBuilder(), 0, 0, n);
        return parentheses;
    }
}