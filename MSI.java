package com.company;
import java.util.*;

class MSI {
public static void main(String []args) {
MSI obj=new MSI();
int arr[][]={ {0,2,0,5,0,6},
              {2,0,8,6,0,0},
              {0,8,0,3,5,0},
              {5,6,3,0,6,7},
              {0,0,5,6,0,2},
              {6,0,0,7,2,0}};
int v=6;
obj.graph(arr,v);
}
public static  void graph(int arr[][],int V)
    {
        int max=Integer.MAX_VALUE;

        int e=0;
        boolean S[]=new boolean[V];

        Arrays.fill(S,false);

        S[0]=true;

        while(V-1>e)
        {
            int min=max;
            int x=0;
            int y=0;
            for(int i = 0;i<V;i++)
            {
                if(S[i]==true)
                {
                    for(int j=0;j<V;j++)
                    {
                        if(!S[j]&& arr[i][j]!=0)
                        {
                            if(min>arr[i][j])
                            {
                                x=i;
                                y=j;
                                min=arr[i][j];

                            }
                        }
                    }
                }
            }
            System.out.println(x+"--"+y+" "+min);
            e++;
            S[y]=true;
        }
    }


}
