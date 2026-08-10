class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();

        StringBuilder currStr = new StringBuilder();
        int num = 0;
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }else if(ch == '['){
                nums.push(num);
                strings.push(currStr);

                num = 0;
                currStr = new StringBuilder();
            }else if(ch == ']'){
                int k = nums.pop();
                StringBuilder str = strings.pop();

                while(k-- > 0){
                    str.append(currStr);
                }
                currStr = str;
            }else{
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}