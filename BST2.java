import java.util.*;
import java.time.*;
public class BST2 {
    class Node 
    {
        int key;
        Node l,r;
        Node (int data)
        {
            key = data;
            l = r = null;
        }
    }
    Node root;
    BST2 ()
    {
        root = null;
    }
    void Insert (int data)
    {
        root = InsertNon(root, data);
    }
    Node InsertNon (Node root, int data)
    {
        if (root == null)
        {
            root = new Node(data);
            return root;
        }
        if (data < root.key)
            root.l = InsertNon(root.l, data);
        else if (data > root.key)
            root.r = InsertNon(root.r, data);
        return root;
    }
    int max(Node root)
    {
        int maximum = root.key;
        while(root.r!= null)
        {
            maximum = root.r.key;
            root = root.r;
        }
        return maximum;
    }
    void Delete (int data)
    {
        root = DeleteNon(root, data);
    }
    Node DeleteNon (Node root, int data)
    {
        if (root == null)
            return root;
        if (data < root.key)
            root.l = DeleteNon (root.l, data);
        else if (data > root.key)
            root.r = DeleteNon (root.r, data);
        else 
        {
            if (root.l == null)
                return root.r;
            else if (root.r == null)
                return root.l;
            root.key = max(root.l);
            root.l = DeleteNon(root.l, root.key);
        }
        return root;
    }
    void Create (int n)
    {
        if (n != 0)
        {
            Random rnd1 = new Random();
            for (int i=1;i<=n;i++)
                Insert(rnd1.nextInt(2001));
        }
    }
    public static void main (String args[])
    {
        BST2 bstree = new BST2();
        int n = 10000;
        bstree.Create(n);
        Random rnd = new Random();
        double time1 = System.nanoTime();        
        bstree.Insert(rnd.nextInt());
        double time2 = System.nanoTime();
        double timein = (time2-time1)/1000; //in microseconds
        System.out.println("The time taken for Insertion in BST for N=2000 is " + timein + " (in microseconds)");
        double tim1 = System.nanoTime();
        bstree.Delete(rnd.nextInt(n));
        double tim2 = System.nanoTime();
        double timedel = (tim2-tim1)/1000; // in microseconds
        System.out.println("The time taken for Deletion in BST for N=2000 is " + timedel + " (in microseconds)");
    }
}