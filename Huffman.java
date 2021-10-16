import java.util.*;
import java.io.*;
class Node
{
    int data;
    char c;
    Node left,right;
}
class MyComparator implements Comparator<Node>
{
    public int compare(Node x, Node y)
    {
        return x.data - y.data;
    }
}
public class Huffman
{
    public static void print(Node root, String s)
    {
        if (root.left==null&&root.right== null&&Character.isLetter(root.c))
        {
            System.out.println(root.c + " : " + s);
            return;
        }
        print(root.left, s + "0");
        print(root.right, s + "1");
    }
    public static void main(String[] args)
    {
        int num=6;
        char[] charArr = { 'p', 'f', 'l', 'y', 'g', 'r' };
        int[] charfreq = { 5, 11, 26, 13, 36, 51 };
        PriorityQueue<Node> temp = new PriorityQueue<Node>(num, new MyComparator());
        for (int i = 0; i < num; i++)
        {
            Node hn = new Node();
            hn.c = charArr[i];
            hn.data = charfreq[i];
            hn.left = null;
            hn.right = null;
            temp.add(hn);
        }
        Node root = null;
        while (temp.size() > 1)
        {
            Node x = temp.peek();
            temp.poll();
            Node y = temp.peek();
            temp.poll();
            Node s = new Node();
            s.data = x.data + y.data;
            s.c = '-';
            s.left = x;
            s.right = y;
            root = s;
            temp.add(s);
        }
        print(root, "");
    }
}