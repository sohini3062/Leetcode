class Solution {
    class Trie
    {
        class Node {
            boolean isWord=false;
            List<Node> child=Arrays.asList(new Node[26]);
        };
        Node root,curr;
        List<String> temp;
        
        // dfs
        
        void dfs(Node curr, String x)
        {
            if(temp.size()==3)
                return;
            if(curr.isWord)
                temp.add(x);
            for(char c='a';c<='z';c++)
            {
               if(curr.child.get(c-'a')!=null)
                   dfs(curr.child.get(c-'a'),x+c);
            }
        }
        Trie()
        {
            root=new Node();
        }
        void insert(String x)
        {
            curr=root;
            for(char c:x.toCharArray())
            {
                 if (curr.child.get(c - 'a') == null)
                            curr.child.set(c - 'a', new Node());
                curr = curr.child.get(c - 'a');
             }
            curr.isWord = true;
            
        }
   List<String> getWordsStartingWith(String prefix) {
        curr = root;
        temp = new ArrayList<String>();
    
        for (char c : prefix.toCharArray()) {
            if (curr.child.get(c - 'a') == null)
                return temp;
            curr = curr.child.get(c - 'a');
        }
        dfs(curr, prefix);
        return temp;
    }
}
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
      
        for (String w : products)
            trie.insert(w);
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.getWordsStartingWith(prefix));
        }
        return result;
    }
}