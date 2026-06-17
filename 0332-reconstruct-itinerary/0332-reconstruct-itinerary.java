class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets)
        {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k-> new ArrayList<>()).add(to);
        }
        for(List<String> destinations : graph.values())
        {
            Collections.sort(destinations);
        }
        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK",graph,itinerary);
        return itinerary;
        
    }
    private static void dfs(String airport,Map<String,List<String>> graph,LinkedList<String> itinerary)
    {
        List<String> destinations = graph.get(airport);
        while(destinations != null && !destinations.isEmpty())
        {
            String next = destinations.remove(0);
            dfs(next,graph,itinerary);
        }
        itinerary.addFirst(airport);
    }
}