import java.util.*;

class Solution {

  public ArrayList<Integer> dfsOfGraph(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs,
      boolean[] vis) {

    vis[node] = true;
    dfs.add(node);

    for (int it : adj.get(node)) {
      if (vis[it] == false) {
        dfsOfGraph(it, adj, dfs, vis);
      }
    }

    return dfs;
  }

}

public class dfs_trv {
  public static void main(String[] args) {
    int n = 8;
    int m = 8;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> dfs = new ArrayList<>();
    boolean[] vis = new boolean[n + 1];

    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<Integer>());
    }

    adj.get(1).add(2);
    adj.get(2).add(1);

    adj.get(1).add(3);
    adj.get(3).add(1);

    adj.get(2).add(5);
    adj.get(5).add(2);

    adj.get(2).add(6);
    adj.get(6).add(2);

    adj.get(3).add(4);
    adj.get(4).add(3);

    adj.get(3).add(7);
    adj.get(7).add(3);

    adj.get(4).add(8);
    adj.get(8).add(4);

    adj.get(8).add(7);
    adj.get(7).add(8);

    Solution obj = new Solution();
    System.out.println();
    System.out.println("The dfs traversal of the input graph : " + obj.dfsOfGraph(1, adj, dfs, vis));

  }
}
