package com.JavaClassAssignment;

import java.util.Scanner;

class Main {

    private static int n;
    private static int[] arr;
    public static int size = 0;

    public static void maxHeapify(int arr[], int n, int i) {

        int temp;
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, n, largest);
        }
    }

    public static void minHeapify(int arr[], int n, int i) {

        int temp;
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[largest])
            largest = left;

        if (right < n && arr[right] < arr[largest])
            largest = right;

        if (largest != i) {
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            minHeapify(arr, n, largest);
        }
    }

    public static void buildMinHeap(int arr[], int n)
    {
        int start = (n / 2) - 1;
        for (int i = start; i >= 0; i--)
        {
            minHeapify(arr, n, i);
        }
    }
    public static void buildMaxHeap(int arr[], int n)
    {
        int start = (n / 2) - 1;
        for (int i = start; i >= 0; i--)
        {
            maxHeapify(arr, n, i);
        }
    }

    static void insertMinHeap(int arr[], int n)
    {
        if (size == 0)
        {
            arr[0] = n;
            size += 1;
        }
        else
        {
            arr[size] = n;
            size += 1;
            for (int i = size / 2 - 1; i >= 0; i--)
            {
                minHeapify(arr, size, i);
            }
        }
    }
    static void insertMaxHeap(int arr[], int n)
    {
        if (size == 0)
        {
            arr[0] = n;
            size += 1;
        }
        else
        {
            arr[size] = n;
            size += 1;
            for (int i = size / 2 - 1; i >= 0; i--)
            {
                maxHeapify(arr, size, i);
            }
        }
    }
    static void printHeap(int arr[], int n)
    {

        for (int i = 0; i < n; ++i)
        {
            System.out.println("\t" + arr[i]);
        }
        System.out.println("\n");
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int i,d;
        int choice,option;

        System.out.println("\tMENU");
        System.out.println("1. Min Heap");
        System.out.println("2. Max Heap");
        System.out.println("3. Array into Heap");
        System.out.println("4. Heap Sort Using Max heap and Min Heap");
        System.out.println("Enter Your Choice: ");
        choice = sc.nextInt();
        switch (choice) {

            case 1:
                System.out.print("Enter no. of Elements: ");
                n = sc.nextInt();
                arr = new int[n];
                System.out.println("Enter Elements: ");
                for(i=0;i<n;i++)
                {
                    d = sc.nextInt();
                    insertMinHeap(arr, d);
                }
                System.out.println("Array Representation of Min Heap is:" );
                printHeap(arr,size);
                break;

            case 2:
                System.out.print("Enter no. of Elements: ");
                n = sc.nextInt();
                arr = new int[n];
                System.out.println("Enter Elements: ");
                for(i=0;i<n;i++)
                {
                    d = sc.nextInt();
                    insertMaxHeap(arr, d);
                }
                System.out.println("Array Representation of Max Heap is:" );
                printHeap(arr,size);
                break;

            case 3:
                System.out.print("Enter no. of Elements: ");
                n = sc.nextInt();
                arr = new int[n];
                System.out.println("Enter Elements: ");
                for(i=0;i<n;i++)
                {
                    arr[i] = sc.nextInt();
                }
                System.out.println("Press: 1 for Min Heap or 2 for Max Heap");
                option = sc.nextInt();
                if(option==1)
                {
                    buildMinHeap(arr,n);
                }
                else
                {
                    buildMaxHeap(arr, n);
                }
                System.out.println("Array Representation of Heap is:" );
                printHeap(arr,n);
                break;

            case 4:
                System.out.print("Enter no. of Elements: ");
                n = sc.nextInt();
                arr = new int[n];
                System.out.println("Prees 1 to sort with Min Heap or 2 with Max Heap");
                option = sc.nextInt();
                System.out.println("Enter Elements: ");
                if(option == 1){
                    for(i=0;i<n;i++)
                    {
                                d = sc.nextInt();
                                insertMinHeap(arr, d);
                    }
                    for (i = size - 1; i >= 0; i--)
                    {
                        int temp;
                        temp = arr[0];
                        arr[0] = arr[i];
                        arr[i] = temp;
                        minHeapify(arr, i, 0);
                    }
                    System.out.println("Sorted Elements using Heap sort with Min Heap is:" );
                    printHeap(arr,size);
                }
                else{

                    for(i=0;i<n;i++)
                    {
                        d = sc.nextInt();
                        insertMaxHeap(arr, d);
                    }
                    for (i = size - 1; i >= 0; i--)
                    {
                        int temp;
                        temp = arr[0];
                        arr[0] = arr[i];
                        arr[i] = temp;
                        maxHeapify(arr, i, 0);
                    }
                    System.out.println("Sorted Element using Heap Sort with Max Heap is:" );
                    printHeap(arr,size);
                }
                break;

            default:
                System.out.println("WRONG CHOICE");
        }
    }
}


