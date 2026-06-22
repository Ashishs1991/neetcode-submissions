class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;

        int left =0;
        int right = n-1;

        Arrays.sort(people);
        int count =0;
        while(left<=right) {
            if(people[right]==limit || people[left]+people[right]>limit) {
                count++;
                right--;
            }else if(people[left]+people[right]<=limit) {
                count++;
                left++;
                right--;
            }
        }
        return count;
    }
}