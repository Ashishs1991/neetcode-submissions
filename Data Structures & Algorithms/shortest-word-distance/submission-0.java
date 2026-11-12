class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        
        //makes -> 1,4
        //coding -> 3,7

        // makes 1 
        //coding - 3 dist = 2
        //makes - 4 dist 1
        int n = wordsDict.length;

        int index1=-1;
        int index2=-1;

        int result= Integer.MAX_VALUE;

        for(int i=0;i<n;i++) {
            if(wordsDict[i].equals(word1)) {
                index1= i;
            }else if(wordsDict[i].equals(word2)) {
                index2=i;
            }
            // System.out.println(index1 +" "+index2);
            if(index2!=-1 && index1!=-1) {
                result = Math.min(result,Math.abs(index1-index2));
            }
        }

        return result;
    }
}
