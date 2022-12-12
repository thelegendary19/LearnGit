import java.util.*;

class Solution {

  public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s) {
    vis[node] = true;
    for (int it : adj.get(node)) {
      if (vis[it] == false) {
        dfs(it, vis, adj, s);
      }
    }
    s.push(node);
  }
  
  public int[] topo(int n, ArrayList<ArrayList<Integer>> adj) {
    boolean[] vis = new boolean[n + 1];
    Stack<Integer> s = new Stack<Integer>();
    for (int i = 0; i < n; i++) {
      if (vis[i] == false) {
        dfs(i, vis, adj, s);
      }

    }
    
    int[] ans = new int[n];
    int i = 0;
    while (!s.isEmpty()) {
      ans[i] = s.peek();
      s.pop();
      i++;

    }
    return ans;
  }
}

public class topo_dfs {
  public static void main(String[] args) {
    int n = 6;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Integer>());

    }

    adj.get(5).add(0);
    adj.get(5).add(2);
    adj.get(2).add(3);
    adj.get(3).add(1);
    adj.get(4).add(1);
    adj.get(4).add(0);

    Solution obj = new Solution();
    int nest[] = obj.topo(n, adj);
    for (int i = 0; i < nest.length; i++) {
      System.out.print(nest[i]+" ");
    }

  }
}
