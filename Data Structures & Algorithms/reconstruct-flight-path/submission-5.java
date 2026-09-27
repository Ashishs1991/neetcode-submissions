class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        //Create an ADJ list
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, key -> new PriorityQueue<>()).offer(to);        }

        /*
        The condtion of Lexo addition so what i was thinking is to have it 
        like a PriorityQueue which will only add in a Lexo format 
        the destination part   
        I have to start from JFK so we have to add that in PQ
        **/

        LinkedList<String> result = new LinkedList<>();
        
        buildItn("JFK",graph,result);
        return result;
    }

    public void buildItn(String from,HashMap<String, PriorityQueue<String>> graph, LinkedList<String> result ) {
         PriorityQueue<String> destinations = graph.get(from);
         while(destinations!=null && !destinations.isEmpty()) {
            String newDest = destinations.poll();
            //doing dfs
            buildItn(newDest,graph,result);
         }

         result.addFirst(from);
    }
}
