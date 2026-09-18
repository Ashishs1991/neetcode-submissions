class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        for(String s: deadends) {
            visited.add(s);
        }

        if(visited.contains("0000")) return -1;
        
        q.offer("0000");
        visited.add("0000");

        int turns = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0;i<size;i++) {
                String lock = q.poll();
                if(lock.equals(target)) return turns;

                for(String next: children(lock)) {
                    if(!visited.contains(next)) {
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }

            turns++;
        }

        return -1;
    }

    private List<String> children(String lock) {
        List<String> result = new ArrayList<>();

        for(int i=0;i<4;i++) {
            char[] arr = lock.toCharArray();
            arr[i] = (char) (((arr[i]-'0'+1)%10)+'0');

            result.add(new String(arr));

            arr = lock.toCharArray();
            arr[i] = (char) (((arr[i] - '0' - 1 + 10) % 10) + '0');

            result.add(new String(arr));
        }

        return result;

    }
}