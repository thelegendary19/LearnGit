import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
  public int primOfGraph(int n, ArrayList<ArrayList<Node>> adj, int src) {
    int sum = 0;
    boolean vis[] = new boolean[n];
    PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
    pq.add(new Node(0, src, -1));
    while (!pq.isEmpty()) {
      if (vis[pq.peek().nd] == false) {
        int weight = pq.peek().wt;
        int element = pq.peek().nd;
        int pt = pq.peek().parent;
        pq.remove();
        vis[element] = true;
        sum += weight;
        for (Node it : adj.get(element)) {
          if (vis[it.nd] == false) {
            pq.add(it);
          }

        }
      } else {
        pq.remove();
      }

    }

    return sum;
  }

  public ArrayList<Pair> primPath(int n, ArrayList<ArrayList<Node>> adj, int src, ArrayList<Pair> path) {
    int sum = 0;
    boolean vis[] = new boolean[n];
    PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
    pq.add(new Node(0, src, src));
    while (!pq.isEmpty()) {
      if (vis[pq.peek().nd] == false) {
        int weight = pq.peek().wt;
        int element = pq.peek().nd;
        int pt = pq.peek().parent;
        pq.remove();
        vis[element] = true;
        sum += weight;
        path.add(new Pair(element, pt));
        for (Node it : adj.get(element)) {
          if (vis[it.nd] == false) {
            pq.add(it);
          }

        }
      } else {
        pq.remove();
      }

    }

    return path;
  }
}

class Pair {
  int nd;
  int parent;

  Pair(int nd, int parent) {
    this.nd = nd;
    this.parent = parent;
  }
}

class Node {
  int wt;
  int nd;
  int parent;

  Node(int wt, int nd, int parent) {
    this.wt = wt;
    this.nd = nd;
    this.parent = parent;
  }
}

public class prim {
  public static void main(String[] args) {
    int n = 5;
    ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
    ArrayList<Pair> path = new ArrayList<Pair>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Node>());
    }

    adj.get(0).add(new Node(2, 1, 0));
    adj.get(1).add(new Node(2, 0, 1));

    adj.get(0).add(new Node(6, 3, 0));
    adj.get(3).add(new Node(6, 0, 3));

    adj.get(3).add(new Node(8, 1, 3));
    adj.get(1).add(new Node(8, 3, 1));

    adj.get(1).add(new Node(5, 4, 1));
    adj.get(4).add(new Node(5, 1, 4));

    adj.get(1).add(new Node(3, 2, 1));
    adj.get(2).add(new Node(3, 1, 2));

    adj.get(4).add(new Node(7, 4, 4));
    adj.get(2).add(new Node(7, 4, 2));

    Solution obj = new Solution();
    System.out.println("Minimum spanning cost : " + obj.primOfGraph(n, adj, 0));
    ArrayList<Pair> ans = obj.primPath(n, adj, 0, path);
    for (int i = 1; i < ans.size(); i++) {
      System.out.println(ans.get(i).nd + "---" + ans.get(i).parent);
    }

  }
}
