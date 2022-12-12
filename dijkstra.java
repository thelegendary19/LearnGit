import java.util.*;

class Solution {

  public int[] dijk(int n, ArrayList<ArrayList<Pair>> adj) {
    int[] update = new int[n];
    int[] parent = new int[n];
    ArrayList<Integer> path = new ArrayList<Integer>();
    for (int i = 1; i < parent.length; i++) {
      parent[i] = i;
    }
    update[0] = 0;
    for (int i = 1; i < update.length; i++) {
      update[i] = Integer.MAX_VALUE;
    }
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.dist - y.dist);
    pq.add(new Pair(0, 0));
    int distance = 0;

    while (!pq.isEmpty()) {
      int node = pq.peek().node;
      int dist = pq.peek().dist;
      pq.remove();
      for (Pair it : adj.get(node)) {
        if (update[it.node] > update[node] + it.dist) {
          update[it.node] = update[node] + it.dist;
          pq.add(new Pair(update[it.node], it.node));
          parent[it.node] = node;

        }

      }

    }
    for (int i = 0; i < parent.length; i++) {
      System.out.print(parent[i] + " ");
    }
    System.out.println();

    return update;
  }

  public ArrayList<Integer> dijk1(int n, ArrayList<ArrayList<Pair>> adj) {
    int[] update = new int[n];
    int[] parent = new int[n];
    ArrayList<Integer> path = new ArrayList<Integer>();
    for (int i = 1; i < parent.length; i++) {
      parent[i] = i;
    }
    update[0] = 0;
    for (int i = 1; i < update.length; i++) {
      update[i] = Integer.MAX_VALUE;
    }
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.dist - y.dist);
    pq.add(new Pair(0, 0));
    int distance = 0;

    while (!pq.isEmpty()) {
      int node = pq.peek().node;
      int dist = pq.peek().dist;
      pq.remove();
      for (Pair it : adj.get(node)) {
        if (update[it.node] > update[node] + it.dist) {
          update[it.node] = update[node] + it.dist;
          pq.add(new Pair(update[it.node], it.node));
          parent[it.node] = node;

        }

      }

    }
    int nd = n-1;
    while (parent[nd] != nd) {
      path.add(nd);
      nd = parent[nd];

    }
    path.add(0);
    Collections.reverse(path);
    return path;
   
   

  }
}

class Pair {
  int dist;
  int node;

  Pair(int dist, int node) {
    this.dist = dist;
    this.node = node;
  }
}

public class dijkstra {
  public static void main(String[] args) {
    int n = 6;
    ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
    ArrayList<Integer> d = new ArrayList<Integer>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Pair>());
    }

    adj.get(0).add(new Pair(4, 2));
    adj.get(2).add(new Pair(4, 0));

    adj.get(0).add(new Pair(4, 1));
    adj.get(1).add(new Pair(4, 0));

    adj.get(1).add(new Pair(2, 2));
    adj.get(2).add(new Pair(2, 1));

    adj.get(2).add(new Pair(3, 3));
    adj.get(3).add(new Pair(3, 2));

    adj.get(2).add(new Pair(6, 5));
    adj.get(5).add(new Pair(6, 2));

    adj.get(2).add(new Pair(1, 4));
    adj.get(4).add(new Pair(1, 2));

    adj.get(4).add(new Pair(3, 5));
    adj.get(5).add(new Pair(3, 4));

    adj.get(3).add(new Pair(2, 5));
    adj.get(5).add(new Pair(2, 3));

    Solution obj = new Solution();
    int[] array = obj.dijk(n, adj);
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
    System.out.println(obj.dijk1(n, adj));
  }
}
