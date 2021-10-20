package com.JavaClassAssignment;

import java.util.*;
import java.util.Scanner;

public class Main
{
    int vert;
    static int[][] matrix;
    public Main(int vert)
    {
        this.vert = vert;
        matrix = new int[vert][vert];
    }
    public static void addEdgeDirected1(ArrayList<ArrayList<Integer>>adj, int u,int v)
    {
        adj.get(u).add(v);
    }
    public static void addEdgeUndirected1(ArrayList<ArrayList<Integer>>adj,int u,int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public void addEdgeDirected2(int u,int v)
    {
        matrix[u][v]=1;
    }
    public void addEdgeUndirected2(int u,int v)
    {
        matrix[u][v]=1;
        matrix[v][u]=1;
    }

    public static void addEdgeDirected3(int u, int v, int j){

        matrix[u][j] = 1;
        matrix[v][j] = -1;
    }
    public static void addEdgeUndirected3(int u, int v, int j){
        matrix[u][j] = 1;
        matrix[v][j] = 1;
    }
    public static void printGraph1(ArrayList<ArrayList<Integer>>adj)
    {
        for(int i=0;i<adj.size();i++)
        {
            System.out.println("\n Adjacency list of vertex " + i);
            for(int j=0;j<adj.get(i).size();j++)
            {
                System.out.println("->"+adj.get(i).get(j));
            }
            System.out.println( );
        }
    }
    public void printGraph2(int v)
    {
        System.out.print("    ");
        for(int i=1;i<v+1;i++){
            System.out.print("V" + (i) + " ");
        }
        System.out.println("------------------------------------------------");
        for(int i=0;i<v;i++)
        {

            System.out.print("V" + (i+1) + " | ");
            for(int j=0;j<v;j++)
            {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.print("------------------------------------------------");
    }
    public void printGraph3(int vr, int n3){

        System.out.print("    ");
        for(int i=1;i<n3+1;i++){
            System.out.print("E" + (i) + " ");
        }
        System.out.println("------------------------------------------------");
        for(int i=0;i<vr;i++)
        {

            System.out.print("V" + (i+1) + " | ");
            for(int j=0;j<n3;j++)
            {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.print("------------------------------------------------");
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\tMENU");
        System.out.println("1. Directed & Adjacent List");
        System.out.println("2. Directed & Adjacent Matrix");
        System.out.println("3. Undirected & Adjacent List");
        System.out.println("4. Undirected & Adjacent Matrix");
        System.out.println("5. Directed & Incidence Matrix");
        System.out.println("6. Undirected & Incidence List");

        int choice = scanner.nextInt();

        if(choice==1)
        {

            System.out.println("Enter the number of vertices");
            int vr=scanner.nextInt();
            ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>(vr);
            for(int i=0;i<vr;i++)
            {
                adj.add(new ArrayList<Integer>());
            }
            System.out.println("Enter the number of entries");
            int n3=scanner.nextInt();
            for(int j=0;j<n3;j++)
            {
                System.out.println("Enter the first vertex");
                int u=scanner.nextInt();
                System.out.println("Enter the second vertex");
                int v=scanner.nextInt();
                addEdgeDirected1(adj,u,v);
            }
            printGraph1(adj);

        }
        else if(choice==2)
        {
            System.out.println("Enter the number of vertices");
            int vr=scanner.nextInt();
            Main g = new Main(vr);

            System.out.println("Enter the number of entries");
            int n3=scanner.nextInt();
            for(int j=0;j<n3;j++)
            {
                System.out.println("Enter the first vertex");
                int u=scanner.nextInt();
                System.out.println("Enter the second vertex");
                int v=scanner.nextInt();
                g.addEdgeDirected2(u,v);
            }
            g.printGraph2(vr);

        }
        else if(choice==3)
        {
            System.out.println("Enter the number of vertices");
            int vr = scanner.nextInt();
            ArrayList<ArrayList<Integer>>adj=new ArrayList<ArrayList<Integer>>(vr);
            for(int i=0;i<vr;i++)
            {
                adj.add(new ArrayList<Integer>());
            }
            System.out.println("Enter the number of entries");
            int n3=scanner.nextInt();
            for(int j=0;j<n3;j++)
            {
                System.out.println("Enter the first vertex");
                int u=scanner.nextInt();
                System.out.println("Enter the second vertex");
                int v=scanner.nextInt();
                addEdgeUndirected1(adj,u,v);
            }
            printGraph1(adj);
        }
        else if(choice == 4)
        {
            System.out.println("Enter the number of vertices");
            int vr = scanner.nextInt();
            Main g = new Main(vr);

            System.out.println("Enter the number of entries");
            int n3 = scanner.nextInt();
            for(int j=0;j<n3;j++)
            {
                System.out.println("Enter the first vertex");
                int u=scanner.nextInt();
                System.out.println("Enter the second vertex");
                int v=scanner.nextInt();
                g.addEdgeUndirected2(u,v);
            }
            g.printGraph2(vr);
        }

        else if(choice == 5){
            System.out.println("Enter the number of vertices");
            int vr = scanner.nextInt();
            Main g = new Main(vr);

            System.out.println("Enter the number of entries");
            int n3 = scanner.nextInt();
            for(int j=0;j<n3;j++)
            {
                System.out.println("Enter the first vertex");
                int u = scanner.nextInt();
                System.out.println("Enter the second vertex");
                int v = scanner.nextInt();
                g.addEdgeDirected3(u,v,j);
            }
            g.printGraph3(vr, n3);
        }

        else if(choice == 6){

            System.out.println("Enter the number of vertices");
            int vr = scanner.nextInt();
            Main g = new Main(vr);

            System.out.println("Enter the number of entries");
            int n3 = scanner.nextInt();
            for(int j=0;j<n3;j++)
            {
                System.out.println("Enter the first vertex");
                int u=scanner.nextInt();
                System.out.println("Enter the second vertex");
                int v=scanner.nextInt();
                g.addEdgeUndirected3(u,v,j);
            }
            g.printGraph3(vr, n3);
        }
        else{
            System.out.println("Wrong Option");
        }
    }
}
