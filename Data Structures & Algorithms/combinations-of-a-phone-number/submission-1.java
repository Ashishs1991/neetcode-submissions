class Solution {
    
    List<String> result = new ArrayList<>();
    HashMap<Integer,String> map = new HashMap<>();


    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        
        if(n==0) return result;
            map.put(2,"abc");
            map.put(3,"def");
            map.put(4,"ghi");
            map.put(5,"jkl");
            map.put(6,"mno");
            map.put(7,"pqrs");
            map.put(8,"tuv");
            map.put(9,"wxyz");

            helper(digits,0,"");
            return result;
    }

    public void helper(String digits,int index,String temp) {
        //when we have added the last

        if(temp.length()==digits.length()) {
            result.add(temp);
            return;
        }

        String chars = map.get(digits.charAt(index)-'0');

        for(char c: chars.toCharArray()) {
            helper(digits,index+1,temp+c);
        }
    }
}
