import java.util.*;
import java.io.*;
public class krushkal 
{
      class Edge implements Comparable<Edge>
      {
            int src, dest, weight;
            public int compareTo(Edge compareEdge)
            {
                  return this.weight - compareEdge.weight;
            }
      };
      int V, E;
      Edge edge[];
      krushkal(int v, int e)
      {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i)
                  edge[i] = new Edge();
      }
      int find(int subsets[], int i)
      {
            if (subsets[i] != i)
                  subsets[i] = find(subsets, subsets[i]);
            return subsets[i];
      }
      void KruskalMST()
      {
            Edge output[] = new Edge[V];
            int e = 0;
            int i = 0;
            for (i = 0; i < V; ++i)
                  output[i] = new Edge();
            Arrays.sort(edge);
            int parent[] = new int[V];
            for (int v = 0; v < V; ++v)
                  parent[v] = v;
            i = 0;
            while (e < V - 1)
            {
                  Edge next_edge = new Edge();
                  next_edge = edge[i++];
                  int x = find(parent, next_edge.src);
                  int y = find(parent, next_edge.dest);
                  if (x != y)
                  {
                        output[e++] = next_edge;
                        parent[x]=y;
                  }
            }
            int minimumCost = 0;
            for (i = 0; i < e; ++i)
            {
                  System.out.println(output[i].src + " -- " + output[i].dest + " => " + output[i].weight);
                  minimumCost += output[i].weight;
            }
            System.out.println("Minimum Cost : " + minimumCost);
      }
      public static void main(String[] args)
      {
            int V,E;
            System.out.println("Enter the no. of vertex and edge in the graph : ");
            Scanner sc=new Scanner(System.in);
            V=sc.nextInt();
            E=sc.nextInt();
            krushkal graph = new krushkal(V, E);
            System.out.println("Enter the source, destination and the weight of the each vertex :");
            for(int i=0;i<E;i++)
            {
                  graph.edge[i].src = sc.nextInt();
                  graph.edge[i].dest = sc.nextInt();
                  graph.edge[i].weight = sc.nextInt();
            }
            long start = System.nanoTime();
            graph.KruskalMST();
            long end = System.nanoTime();
            long microseconds = (end - start) / 1000;
            System.out.println("Execution time : "+microseconds+" microseconds");
      }
}