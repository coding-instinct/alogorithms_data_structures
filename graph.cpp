#include<bits/stdc++.h>
using namespace std;
void listdirect()
{
  int vertex,edge;
  cout<<"Enter the number of vertices"<<endl;
  cin>>vertex;
  cout<<"Enter the number of edges "<<endl;
  cin>>edge;


  vector<int> v[vertex+1];
  cout<<"Enter the edges in space spereated pair"<<endl;

  int u,w;
  for(int i=0;i<edge;i++)
  {
    cout<<"e"<<(i+1)<<") --";
    cin>>u>>w;
    v[u].push_back(w);
  }
  cout<<"The corresponding output will be the directed graph in following adjacency list:"<<endl;
  for(int i=1;i<=vertex;i++)
  {
    cout<<i<<"-->"<<" ";
    for(int j=0;j<v[i].size();j++)
    {
      cout<<v[i][j]<<" ";
    }
    cout<<endl;
  }
}

void listundirect()
{
  int vertex,edge;
  cout<<"Enter the number of vertices"<<endl;
  cin>>vertex;
  cout<<"Enter the number of edges "<<endl;
  cin>>edge;
  vector<int> v[vertex+1];
  cout<<"Enter edges in space spereated pair"<<endl;

  int u,w;
  for(int i=0;i<edge;i++)
  {
    cout<<"e"<<(i+1)<<") --";
    cin>>u>>w;
    v[u].push_back(w);
    v[w].push_back(u);
  }
  cout<<"The corresponding output will be the  undirected graph in following adjacency list:"<<endl;
  for(int i=1;i<=vertex;i++)
  {
    cout<<i<<"-->"<<" ";
    for(int j=0;j<v[i].size();j++)
    {
      cout<<v[i][j]<<" ";
    }
    cout<<endl;
  }
}

void matrixdirect()
{
  int vertex,edge;
  cout<<"Enter the number of vertices"<<endl;
  cin>>vertex;
  cout<<"Enter the number of edges "<<endl;
  cin>>edge;

  cout<<"Enter edges in space spereated pair"<<endl;
  int mat[vertex+1][vertex+1]={0};

  int u,w;
  for(int i=0;i<edge;i++)
  {
    cout<<"e"<<(i+1)<<") --";
    cin>>u>>w;
    mat[u][w]=1;
  }
  cout<<"The corresponding output will be the directed graph in following adjacency matrix:"<<endl;
  cout<<"  ";
  for(int i=1;i<=vertex;i++)
  {cout<<"V"<<(i)<<" ";}
  cout<<endl;
  for(int i=1;i<=vertex;i++)
  {  cout<<"V"<<(i)<<" ";
    for(int j=1;j<=vertex;j++)
    {
      cout<<mat[i][j]<<"  ";
    }
    cout<<endl;
  }
}
void matrixundirect()
{
  int vertex,edge;
  cout<<"Enter the number of vertices"<<endl;
  cin>>vertex;
  cout<<"Enter the number of edges "<<endl;
  cin>>edge;
  cout<<"Enter edges in space spereated pair"<<endl;

  int mat[vertex+1][vertex+1]={0};

  int u,w;
  for(int i=0;i<edge;i++)
  {
    cout<<"e"<<(i+1)<<") --";
    cin>>u>>w;
    mat[u][w]=1;
    mat[w][u]=1;
  }
  cout<<"The corresponding output will be the  undirected graph in following adjacency matrix:"<<endl;
  cout<<"  ";
  for(int i=1;i<=vertex;i++)
  {cout<<"V"<<(i)<<" ";}
  cout<<endl;
  for(int i=1;i<=vertex;i++)
  {  cout<<"V"<<(i)<<" ";
    for(int j=1;j<=vertex;j++)
    {
      cout<<mat[i][j]<<"  ";
    }
    cout<<endl;
  }
}
void incidencedirect()
{
  int vertex,edge;
  cout<<"Enter the number of vertices"<<endl;
  cin>>vertex;
  cout<<"Enter the number of edges "<<endl;
  cin>>edge;
  cout<<"Enter edges in space spereated pair"<<endl;

  int graph[vertex+1][edge]={0};

  int u,w,edge_count=0;
  for(int i=0;i<edge;i++)
  {
    cout<<"e"<<(i+1)<<") --";
    cin>>u>>w;
    graph[u][edge_count]=1;
    edge_count++;
  }
  cout<<"The corresponding output will be the  directed graph in following incidence matrix:"<<endl;
  cout<<"  ";
  for(int j=0;j<edge;j++)
  {cout<<"E"<<(j+1)<<" ";}
  cout<<endl;
  for(int i=1;i<=vertex;i++)
  {  cout<<"V"<<(i)<<" ";
    for(int j=0;j<edge;j++)
    {
      cout<<graph[i][j]<<"  ";
    }
    cout<<endl;
  }

}
void incidenceundirect()
{
  int vertex,edge;
  cout<<"Enter the number of vertices"<<endl;
  cin>>vertex;
  cout<<"Enter the number of edges "<<endl;
  cin>>edge;
 
  cout<<"Enter edges in space spereated pair"<<endl;

  int graph[vertex+1][edge]={0};

  int u,w,edge_count=0;
  for(int i=0;i<edge;i++)
  {
    cout<<"e"<<(i+1)<<") --";
    cin>>u>>w;
    graph[u][edge_count]=1;
    graph[w][edge_count]=1;
    edge_count++;
  }
  cout<<"The corresponding output will be the  undirected graph in following incidence matrix:"<<endl;
  cout<<"  ";
  for(int j=0;j<edge;j++)
  {cout<<"E"<<(j+1)<<" ";}
  cout<<endl;
  for(int i=1;i<=vertex;i++)
  {  cout<<"V"<<(i)<<" ";
    for(int j=0;j<edge;j++)
    {
      cout<<graph[i][j]<<"  ";
    }
    cout<<endl;
  }
}
void directed()
{
  cout<<"choice 1. Using ADJACENCY LIST"<<endl;
  cout<<"choice 2. Using ADJACENCY MARTRIX"<<endl;
  cout<<"choice 3. Using INCIDENCE MARTRIX"<<endl;
  cout<<"Enter your choice---";
  int choice;
  cin>>choice;

  if(choice==1)
  {
    listdirect();
  }
  else if(choice==2)
  {
    matrixdirect();
  }
  else if(choice==3)
  {
    incidencedirect();
  }
}

void undirected()
{
  cout<<"choice 1. Using ADJACENCY LIST"<<endl;
  cout<<"choice 2. Using ADJACENCY MARTRIX"<<endl;
  cout<<"choice 3. Using INCIDENCE MARTRIX"<<endl;
  cout<<"Enter your choice---";

  int choice;
  cin>>choice;

  if(choice==1)
  {
    listundirect();
  }
  else if(choice==2)
  {
    matrixundirect();
  }
  else if(choice==3)
  {
    incidenceundirect();
  }
}
int main()
{
  cout<<"-------MENU FOR THE GRAPH-------"<<endl;
  cout<<"choice 1. For DIRECTED GRAPH"<<endl;
  cout<<"choice 2. For UNDIRECTED GRAPH"<<endl;
  cout<<"Enter your choice---";
  int choice;
  cin>>choice;

  if(choice==1)
  {
    directed();
  }
  else if(choice==2)
  {
    undirected();
  }
}
