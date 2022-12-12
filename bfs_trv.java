import java.util.*;

class Solution {

  public ArrayList<Integer> bfsOfGraph(int n, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> bfs) {
    boolean[] vis = new boolean[n + 1];
    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    vis[1] = true;

    while (!q.isEmpty()) {
      int node = q.poll();
      bfs.add(node);

      for (int it : adj.get(node)) {
        if (vis[it] == false) {
          vis[it] = true;
          q.add(it);
        }
      }

    }
    return bfs;
  }

}

public class bfs_trv {
  public static void main(String[] args) {
    int n = 5;
    int m = 6;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> bfs = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<Integer>());
    }

    adj.get(1).add(2);
    adj.get(2).add(1);

    adj.get(1).add(3);
    adj.get(3).add(1);

    adj.get(2).add(4);
    adj.get(4).add(2);

    adj.get(2).add(5);
    adj.get(5).add(2);

    adj.get(4).add(5);
    adj.get(5).add(4);

    adj.get(4).add(3);
    adj.get(3).add(4);

    Solution obj = new Solution();
    System.out.println();
    System.out.println("The bfs traversal for the input graph : " + obj.bfsOfGraph(n, adj, bfs));

  }
}