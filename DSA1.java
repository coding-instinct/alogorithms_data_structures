package com.JavaClassAssignment;

import java.util.*;
public class Main {

    public static void heapSort(int arr[])
    {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i=n-1; i>0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    static void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
    static void merge(int arr[], int left, int mid, int right)
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int lef[] = new int[n1];
        int righ[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            lef[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            righ[j] = arr[mid + 1 + j];

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (lef[i] <= righ[j]) {
                arr[k] = lef[i];
                i++;
            }
            else {
                arr[k] = righ[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = lef[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = righ[j];
            j++;
            k++;
        }
    }
    static void mergeSort(int arr[], int left, int right)
    {
        if (left < right) {
            int m = (left + right) / 2;

            mergeSort(arr, left, m);
            mergeSort(arr, m + 1, right);

            merge(arr, left, m, right);
        }
    }
    public static int partition(int a[], int beg, int end)
    {

        int pivot = a[end];
        int i =(beg-1);
        for(int j=beg;j<end;j++)
        {
            if(a[j]<pivot)
            {
                i++;
                int swap = a[i];
                a[i]=a[j];
                a[j]=swap;
            }
        }
        int swap = a[i+1];
        a[i+1]=a[end];
        a[end]=swap;
        return i+1;
    }
    static void quickSort(int a[], int beg, int end)
    {

        int loc;
        if(beg<end)
        {
            loc = partition(a, beg, end);
            quickSort(a, beg, loc-1);
            quickSort(a, loc+1, end);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int j,k,l,x,m;
        long sum1=0,sum2=0,sum3=0,average1,average2,average3;
        long su1=0,su2=0,su3=0,averag1,averag2,averag3;
        long s1=0,s2=0,s3=0,avera1,avera2,avera3;
        System.out.println("Enter number of elements in the heap");
        int n= sc.nextInt();
        System.out.println("Enter number of times to be runned");
        m = sc.nextInt();
        long [] call1= new long[n];
        long [] cal1= new long[n];
        long [] ca1= new long[n];
        long [] call2= new long[n];
        long [] cal2= new long[n];
        long [] ca2= new long[n];
        long [] call3= new long[n];
        long [] cal3= new long[n];
        long [] ca3= new long[n];
        Random rd = new Random();
        int[] a1 = new int[n];
        int[] a2 = new int[n];
        int[] a3 = new int[n];
        int b1[] = new int[n];
        int b2[] = new int[n];
        int b3[] = new int[n];
        int c1[] = new int[n];
        int c2[] = new int[n];
        int c3[] = new int[n];
        for(x=0;x<m;x++)
        {
            for (j = 0; j < n; j++)
            {
                a1[j] = rd.nextInt(n);
                a2[j] = rd.nextInt(n);
                a3[j] = rd.nextInt(n);
            }
            for (k = 0; k < n;k++)
            {
                b1[k]=k;
                b2[k]=k;
                b3[k]=k;
            }
            for (l = n; l >0;l--)
            {
                c1[n-l]=l;
                c2[n-l]=l;
                c3[n-l]=l;
            }
            long startTime1= System.nanoTime();
            heapSort(a1);
            long endTime1=System.nanoTime()-startTime1;
            call1 [x] = endTime1*1000;
            System.out.println("Running time for heapsort when we use a random array in micro:"+endTime1/1000);
            long startTime2 =System.nanoTime();
            heapSort(b1);
            long endTime2=System.nanoTime()-startTime2;
            call2[x] = endTime2*1000;
            System.out.println("Running time for heapsort when we use a increasing array in micro:"+endTime2/1000);
            long startTime3 =System.nanoTime();
            heapSort(c1);
            long endTime3=System.nanoTime()-startTime3;
            call3 [x] = endTime3*1000;
            System.out.println("Running time for heapsort when we use a decreasing array in micro"+endTime3/1000);
            System.out.println("");
            long startTim1 =System.nanoTime();
            mergeSort(a2,0,n-1);
            long endTim1=System.nanoTime()-startTim1;
            cal1 [x] = endTim1*1000;
            System.out.println("Running time for Mergesort when we use a random array in micro:"+endTim1/1000);
            long startTim2 =System.nanoTime();
            mergeSort(b2,0,n-1);
            long endTim2=System.nanoTime()-startTim2;
            cal2 [x] = endTim2*1000;
            System.out.println("Running time for Mergesort when we use a increasing array in micro:"+endTim2/1000);
            long startTim3 =System.nanoTime();
            mergeSort(c2,0,n-1);
            long endTim3=System.nanoTime()-startTim3;
            cal3 [x] = endTim3*1000;
            System.out.println("Running time for Mergesort when we use a decreasing array in micro:"+endTim3/1000);
            System.out.println("");
            long startTi1 =System.nanoTime();
            quickSort(a3,0,n-1);
            long endTi1 =System.nanoTime()-startTi1;
            ca1 [x] = endTi1*1000;
            System.out.println("Running time for Quicksort when we use a random array in micro:"+endTi1/1000);
            long startTi2 =System.nanoTime();
            quickSort(b3,0,n-1);
            long endTi2 =System.nanoTime()-startTi2;
            ca2 [x] = endTi2*1000;
            System.out.println("Running time for Quicksort when we use a increasing array in micro:"+endTi2/1000);
            long startTi3 =System.nanoTime();
            quickSort(c3,0,n-1);
            long endTi3 =System.nanoTime()-startTi3;
            ca3 [x] = endTi3*1000;
            System.out.println("Running time for Quicksort when we use a decreasing array in micro:"+endTi3/1000);
            System.out.println("");
        }
        for(x=0;x<m;x++)
        {
            sum1= sum1+call1[x];
            sum2= sum2+call2[x];
            sum3= sum3+call3[x];
            su1= su1+cal1[x];
            su2= su2+cal2[x];
            su3= su3+cal3[x];
            s1= s1+ca1[x];
            s2= s2+ca2[x];
            s3= s3+ca3[x];
        }
        average1=sum1/m;
        average2=sum2/m;
        average3=sum3/m;
        averag1=su1/m;
        averag2=su2/m;
        averag3=su3/m;
        avera1=s1/m;
        avera2=s2/m;
        avera3=s3/m;
        System.out.println("The average time for Heapsort when we use an random array is " +average1);
        System.out.println("The average time for Heapsort when we use an increasing array is " +average2);
        System.out.println("The average time for Heapsort when we use an decreasing array is "+average3);
        System.out.println("");
        System.out.println("The average time for Mergesort when we	use an random array is " +averag1);
        System.out.println("The average time for Mergesort when we	use an increasing array is " +averag2);
        System.out.println("The average time for Mergesort when we	use an decreasing array is "+averag3);
        System.out.println("");
        System.out.println("The average time for when Quicksort we use random array is " +avera1);
        System.out.println("The average time for when Quicksort we use increasing array is " +avera2);
        System.out.println("The average time for when Quicksort we use decreasing array is "+avera3);
    }

}


//        System.out.println("Enter number of elements in the array\n" +
//                "2000\n" +
//                "Enter number of times to be runned\n" +
//                "15\n" +
//                "The average time for Heapsort when we use an random array is 573\n" +
//                "The average time for Heapsort when we use an increasing array is 803\n" +
//                "The average time for Heapsort when we use an decreasing array is 455\n" +
//                "\n" +
//                "The average time for Mergesort when we  use an random array is 681\n" +
//                "The average time for Mergesort when we  use an increasing array is 303\n" +
//                "The average time for Mergesort when we  use an decreasing array is 732\n" +
//                "\n" +
//                "The average time for when Quicksort we use random array is 374\n" +
//                "The average time for when Quicksort we use increasing array is 6312\n" +
//                "The average time for when Quicksort we use decreasing array is 5576\n" +
//                "4000\n" +
//                "Enter number of elements in the array\n" +
//                "4000\n" +
//                "Enter number of times to be runned\n" +
//                "15\n" +
//                "The average time for Heapsort when we use an random array is 1901\n" +
//                "The average time for Heapsort when we use an increasing array is 1195\n" +
//                "The average time for Heapsort when we use an decreasing array is 686\n" +
//                "\n" +
//                "The average time for Mergesort when we  use an random array is 1616\n" +
//                "The average time for Mergesort when we  use an increasing array is 1384\n" +
//                "The average time for Mergesort when we  use an decreasing array is 2731\n" +
//                "\n" +
//                "The average time for when Quicksort we use random array is 2267\n" +
//                "The average time for when Quicksort we use increasing array is 41843\n" +
//                "The average time for when Quicksort we use decreasing array is 25156\n" +
//                "6000\n" +
//                "Enter number of elements in the array\n" +
//                "6000\n" +
//                "Enter number of times to be runned\n" +
//                "15\n" +
//                "The average time for Heapsort when we use an random array is 2315\n" +
//                "The average time for Heapsort when we use an increasing array is 1025\n" +
//                "The average time for Heapsort when we use an decreasing array is 2214\n" +
//                "\n" +
//                "The average time for Mergesort when we  use an random array is 2498\n" +
//                "The average time for Mergesort when we  use an increasing array is 1104\n" +
//                "The average time for Mergesort when we  use an decreasing array is 999\n" +
//                "\n" +
//                "The average time for when Quicksort we use random array is 1107\n" +
//                "The average time for when Quicksort we use increasing array is 58202\n" +
//                "The average time for when Quicksort we use decreasing array is 43428\n" +
//                "8000\n" +
//                "Enter number of elements in the array\n" +
//                "8000\n" +
//                "Enter number of times to be runned\n" +
//                "15\n" +
//                "The average time for Heapsort when we use an random array is 2613\n" +
//                "The average time for Heapsort when we use an increasing array is 1473\n" +
//                "The average time for Heapsort when we use an decreasing array is 1301\n" +
//                "\n" +
//                "The average time for Mergesort when we  use an random array is 2097\n" +
//                "The average time for Mergesort when we  use an increasing array is 1633\n" +
//                "The average time for Mergesort when we  use an decreasing array is 1352\n" +
//                "\n" +
//                "The average time for when Quicksort we use random array is 1394\n" +
//                "The average time for when Quicksort we use increasing array is 98109\n" +
//                "The average time for when Quicksort we use decreasing array is 63192\n" +
//                "10000\n" +
//                "Enter number of elements in the array\n" +
//                "10000\n" +
//                "Enter number of times to be runned\n" +
//                "15\n" +
//                "The average time for Heapsort when we use an random array is 2655\n" +
//                "The average time for Heapsort when we use an increasing array is 1978\n" +
//                "The average time for Heapsort when we use an decreasing array is 1612\n" +
//                "\n" +
//                "The average time for Mergesort when we  use an random array is 2705\n" +
//                "The average time for Mergesort when we  use an increasing array is 1396\n" +
//                "The average time for Mergesort when we  use an decreasing array is 12142\n" +
//                "\n" +
//                "The average time for when Quicksort we use random array is 1624\n" +
//                "The average time for when Quicksort we use increasing array is 149257\n" +
//                "The average time for when Quicksort we use decreasing array is 99277\n" +
//                "\n" +
//                "c\n" +
//                "n1=[573,1901,2315,2613,2705]\n" +
//                "n2=[681,1616,2498,2097,2634]\n" +
//                "n3=[374,2267,1107,1394,1624]\n" +
//                "\n" +
//                "a\n" +
//                "n1=[803,1195,1025,1473,1978]\n" +
//                "n2=[303,1384,1104,1633,1396]\n" +
//                "n3=[6312,41843,58202,98109,149257]\n" +
//                "\n" +
//                "b\n" +
//                "n1=[455,686,2214,1301,1612]\n" +
//                "n2=[732,2731,999,1352,12142]\n" +
//                "n3=[5576,25156,43428,63192,99277]");