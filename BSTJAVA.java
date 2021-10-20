package com.JavaClassAssignment;

import java.util.Scanner;

class BSTNode
{
    BSTNode left, right;
    int data;

    public BSTNode(int n)
    {
        left = null;
        right = null;
        data = n;
    }
    // I have used setLeft for Setting Left Node
    public void setLeft(BSTNode n)
    {
        left = n;
    }
    // I have used setRight for Setting right Node
    public void setRight(BSTNode n)
    {
        right = n;
    }
    // I have used getters here using my OOP Knowledge
    public BSTNode getLeft()
    {
        return left;
    }
    public BSTNode getRight()
    {
        return right;
    }
    public int getData()
    {
        return data;
    }
}

class BST
{
    public static BSTNode root;

    public BST()
    {
        root = null;
    }
    // I have used this Function to Check whether the Tree is Empty or not
    public boolean isEmpty()
    {
        return root == null;
    }
    // I have used below Functions for CASE:1 ----Creation
    public void create(int data)
    {
        root = insert(root, data);
    }
    private BSTNode create(BSTNode node, int data)
    {
        if(node != null) {
            System.out.println("Tree is Already Created");
        }
        else {
            node = new BSTNode(data);
        }
        return node;
    }
    //I have Used this Function for CASE 2: ----Display: preorder traversal
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(BSTNode r)
    {
        if (r != null)
        {
            System.out.print(r.getData() +" ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }
    // I have used this Function for CASE 3: ----Insertion
    public void insert(int data)
    {
        root = insert(root, data);
    }
    private BSTNode insert(BSTNode node, int data)
    {
        if (node == null)
            node = new BSTNode(data);
        else
        {
            if (data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }
    //I have Used this Function for CASE 4: ----Deletion
    public void delete(int k)
    {
        if (isEmpty())
            System.out.println("Tree Empty");
        else
        {
            root = delete(root, k);
            System.out.println(k + " deleted from the tree");
        }
    }
    private BSTNode delete(BSTNode root, int k)
    {
        BSTNode p, p2, n;
        if (root.getData() == k)
        {
            BSTNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null)
            {
                p = rt;
                return p;
            }
            else if (rt == null)
            {
                p = lt;
                return p;
            }
            else
            {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData())
        {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        }
        else
        {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }
    // I have used below Function for CASE 5: ----Height
    public int height(BSTNode r) {
        if (r == null)
            return 0;
        else {
            int lDepth = height(r.left);
            int rDepth = height(r.right);

            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
    // I have Used below Functions for CASE 6: ----Nodes Counting
    public int countNodes() {
        return countNodes(root);
    }
    private int countNodes(BSTNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    //I have Used this Function for CASE 7: ----Inorder traversal
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(BSTNode r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            System.out.print(r.getData() +" ");
            inorder(r.getRight());
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BST bst = new BST();
        System.out.println("Binary Search Tree Test\n");
        char ch;

        do {
            System.out.println("\nBinary Search Tree Operations\n");
            System.out.println("1. Creation ");
            System.out.println("2. Display: Preorder Traversal");
            System.out.println("3. Insertion");
            System.out.println("4. Deletion");
            System.out.println("5. Height");
            System.out.println("6. Node count");
            System.out.println("7. Inorder Traversal");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter First Element of the Tree");
                    bst.create(scan.nextInt());
                    break;
                case 2:
                    System.out.print("\nPre order : ");
                    bst.preorder();
                    break;
                case 3:
                    System.out.println("Enter element to insert");
                    bst.insert(scan.nextInt());
                    break;
                case 4:
                    System.out.println("Enter element to delete");
                    bst.delete(scan.nextInt());
                    break;
                case 5:
                    System.out.println("Height of Tree is: " + bst.height(BST.root));
                    break;
                case 6:
                    System.out.println("Nodes = " + bst.countNodes());
                    break;
                case 7:
                    System.out.print("\nIn order : ");
                    bst.inorder();
                    break;

                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }

}


