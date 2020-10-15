import java.util.*;
import java.time.*;
public class Bucket
{
    static void bucketsort (float A[], int n)
    {
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] bkt = new ArrayList[n];
        for (int i=0;i<n;i++)
            bkt[i] = new ArrayList<Float>();
        for (int i=0;i<n;i++)
        {
            int bktInd = (int)A[i]*n;
            bkt[bktInd].add(A[i]);
        }
        for (int i=0;i<n;i++)
            Collections.sort((bkt[i])); 
            //  Here you can use any other sorting algorithm also...
        int j=0;
        for (int i=0;i<n;i++)
        {
            for (int k=0, size=bkt[i].size();k<size;k++)
                A[j++] = bkt[i].get(k);    
    }
    public static void main (String args[])
    {
        int n=10000;
        float A[] = new float[n];
        Random rnd = new Random();
        for (int i=0;i<n;i++)
            A[i] = rnd.nextFloat(10001);
        double time1 = System.nanoTime();
        bucketsort(A, n);
        double time2 = System.nanoTime();
        double timediff = (time2-time1)/1000; // in microseconds
        System.out.println("\nThe Execution time taken for bucket sort algorithm is - " + timediff + "\n\n");
    }
}