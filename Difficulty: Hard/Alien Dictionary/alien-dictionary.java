class Solution {
    public static List<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, int k, int[] indegree){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < k;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            topo.add(curr);
            
            for(int val : adj.get(curr)){
                indegree[val]--;
                if(indegree[val] == 0){
                    q.add(val);
                }
            }
        }
        
        return topo;
    }

    public String findOrder(String[] words) {
        Set<Character> charSet = new HashSet<>();
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                charSet.add(ch);
            }
        }

        int k = charSet.size();  

        // Map char -> index
        Map<Character, Integer> charToIndex = new HashMap<>();
        // Map index -> char
        Map<Integer, Character> indexToChar = new HashMap<>();
        int idx = 0;
        for(char ch : charSet){
            charToIndex.put(ch, idx);
            indexToChar.put(idx, ch);
            idx++;
        }

        // Build graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < k;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[k];

        for(int i = 0;i < words.length - 1;i++){
            String word1 = words[i];
            String word2 = words[i + 1];
            int len = Math.min(word1.length(), word2.length());
            boolean found = false;
            for(int j = 0;j < len;j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2){
                    int u = charToIndex.get(c1);
                    int v = charToIndex.get(c2);
                    adj.get(u).add(v);
                    indegree[v]++;
                    found = true;
                    break;
                }
            }
            
            // Edge case: prefix problem like ["abc", "ab"]
            if (!found && word1.length() > word2.length()) {
                return "";
            }
        }

        List<Integer> topo = topoSort(adj, k, indegree);
        if(topo.size() != k) return ""; // cycle detected

        StringBuilder ans = new StringBuilder();
        for(int val : topo){
            ans.append(indexToChar.get(val));
        }

        return ans.toString();
    }
}
