import java.util.*;
import java.io.*;
public class LCS
{
    int lcs1(char[] p, char[] q, int m, int n )
    {
        int L[][] = new int[m+1][n+1];
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (p[i-1] == q[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }
    int max(int a, int b)
    {   
        if (a > b)
            return a;
        else 
            return b;
    }
    public static void main(String[] args)
    {
        LCS lcs = new LCS();
        Scanner sc = new Scanner(System.in);
        String str1,str2;
        System.out.println("Enter the string 1 : ");
        str1 = sc.nextLine();
        System.out.println("Enter the string 2 : ");
        str2 = sc.nextLine();
        char p[] = str1.toCharArray();
        char q[] = str2.toCharArray();
        int m = p.length;
        int n = q.length;
        System.out.println();
        System.out.println("Length of the Longest Common Subsequence : "+lcs.lcs1( p, q, m, n ));
    }
}