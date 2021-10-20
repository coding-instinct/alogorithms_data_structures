package com.JavaClassAssignment;

import java.util.Scanner;

class Node
{
    int key, height;
    Node left, right;

    Node(int d)
    {
        key = d;
        height = 1;
    }
}

class AVLTree
{
    Node root;

    int height(Node N)
    {
        if (N == null)
            return 0;
        return N.height;
    }

    int max(int a, int b)
    {
        return (a > b) ? a : b;
    }

    Node rightRotate(Node y)
    {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x)
    {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(Node N)
    {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    Node create(Node node, int key)
    {
            return (new Node(key));
    }

    Node insert(Node node, int key)
    {
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + max(height(node.left),
                height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key)
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }


    Node minValueNode(Node node)
    {
        Node current = node;

        while (current.left != null)
            current = current.left;

        return current;
    }

    Node deleteNode(Node root, int key)
    {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteNode(root.left, key);

        else if (key > root.key)
            root.right = deleteNode(root.right, key);

        else
        {
            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else
                    root = temp;
            }
            else
            {
                Node temp = minValueNode(root.right);

                root.key = temp.key;

                root.right = deleteNode(root.right, temp.key);
            }
        }

        if (root == null)
            return root;

        root.height = max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    void preOrder(Node node)
    {
        if (node != null)
        {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }


}
public class Main{
    public static void main(String[] args)
    {
        int choice,key,flag = 1;
        Scanner scanner = new Scanner(System.in);
        AVLTree tree = new AVLTree();

        while (flag == 1) {
            System.out.println("\tMENU");
            System.out.println("1. Create");
            System.out.println("2. Insert");
            System.out.println("3. Deletion");
            System.out.println("4. Display: Preorder Traversal");
            choice = scanner.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("Enter the First Element: ");
                    key = scanner.nextInt();
                    tree.root = tree.create(tree.root, key);
                    break;
                case 2:
                    System.out.println("Enter the Element: ");
                    key = scanner.nextInt();
                    tree.root = tree.insert(tree.root, key);
                    break;
                case 3:
                    System.out.println("Enter the Element to be Deleted: ");
                    key = scanner.nextInt();
                    tree.root = tree.deleteNode(tree.root, key);
                    break;
                case 4:
                    tree.preOrder(tree.root);
                    break;
                default:
                    System.out.println("WRONG CHOICE");
            }
            System.out.println("\nWant to do More task? (0/1)");
            flag = scanner.nextInt();
        }
    }
}