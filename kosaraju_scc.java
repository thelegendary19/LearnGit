import java.util.*;

class Solution {

  public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
    vis[node] = true;
    for (int it : adj.get(node)) {
      if (vis[it] == false) {
        dfs(it, vis, adj, st);
      }
    }
    st.push(node);
  }

  public void dfs3(int node, boolean vis[], ArrayList<ArrayList<Integer>> adjT) {

    vis[node] = true;
    for (int it : adjT.get(node)) {
      if (vis[it] == false) {
        dfs3(it, vis, adjT);
      }
    }
  }

  public int kosaraju(int n, ArrayList<ArrayList<Integer>> adj) {
    boolean[] vis = new boolean[n];
    Stack<Integer> st = new Stack<Integer>();
    for (int i = 0; i < n; i++) {
      if (vis[i] == false) {
        dfs(i, vis, adj, st);
      }
    }

    ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < n; i++) {
      adjT.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < n; i++) {
      vis[i] = false;

      for (int it : adj.get(i)) {
        adjT.get(it).add(i);
      }

    }
    // for (int i = 0; i < vis.length; i++) {
    //   System.out.print(vis[i]+" ");
    // }
    // System.out.println(st);
    // System.out.println(st.peek());
    int scc = 0;
    while (!st.empty()) {
      int node = st.peek();
      st.pop();
      if (vis[node] == false) {
        scc++;
        dfs3(node, vis, adjT);
      }

    }

    return scc;

  }

}

public class kosaraju_scc {
  public static void main(String[] args) {
    int n = 8;
    int m = 10;

    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Integer>());
    }

    adj.get(0).add(1);
    adj.get(1).add(2);
    adj.get(2).add(0);

    adj.get(2).add(3);

    adj.get(3).add(4);
    adj.get(4).add(5);
    adj.get(5).add(6);
    adj.get(6).add(4);

    adj.get(6).add(7);
    adj.get(4).add(7);

    Solution obj = new Solution();
    System.out.println();
    System.out.println("The number of strongly connected components in the input graph : " + obj.kosaraju(n, adj));

  }
}