#include<stdio.h>
#include<stdlib.h>
struct node
{
	int data ;
	struct node *next;
};
struct node *head=NULL;
void add()
{
	struct node *temp,*new;
	int da,c;
	printf("how many node you want to insert---- ");
	scanf("%d",&c);
	while(c--)
	{
	if (head==NULL)
	{	head=(struct node*)malloc(sizeof(struct node));
		printf("enter the data\n---");
		scanf("%d",&da);
		head->data=da;
		head->next=NULL;
		temp=head;
	}
	else
	{	struct node *temp=head;
	while(temp->next!=NULL)
	{
	 temp=temp->next;
	}
	new=(struct node*)malloc(sizeof(struct node));
	printf("enter the data\n---");
	scanf("%d",&da);
	new->data=da;
	new->next=NULL;
	temp->next=new;
	}
	}
}
void display()
{
	struct node *temp=head;
	while(temp!=NULL)
	{printf("data->%d\n",temp->data);
	 temp=temp->next;
	}

}
void sort()
{
	struct node *temp=head;
	struct node *temp1;
	int t;
	while(temp->next->next!=NULL)
	{temp1=temp->next;
	 while(temp1!=NULL)
	{
	 if(temp->data>temp1->data)
	 {t=temp->data;
	   temp->data=temp1->data;
	   temp1->data=t;
	  }
	  temp1=temp1->next;
	}
	temp=temp->next;
	}
	
}
struct node* binary(int v)
{
	struct node *start=head;
	struct node *end=NULL;
	struct node *mid;
	
	do
	{	mid=middle(start,end);
		if(mid==NULL)
		{return NULL;}
		if(mid->data==v)
		{return mid;}
		else if(mid->data<v)
		{start=mid->next;}
		else
			end=mid;
	}while(end==NULL || end!=start);
	return NULL;
}
struct node* middle(struct node * start,struct node * end)
{
	struct node *t1=start;
	struct node *mid=start;
	while(t1!=end)
	{
	t1=t1->next;
		if(t1!=end)
		{t1=t1->next;
		mid=mid->next;
		}
	}
	return mid;
}

int main()
{
	int choice=1;
	while (choice==1)
	{
		int op;
		printf("enter the choice \n 1 for adding node\n 2 for display\n 3 for sort item\n 4 for search  \n----");
		scanf("%d",&op);
		if (op==1)
		{
			add();
		}
		else if(op==2){
			display();
		}
		else if(op==3)
		{ sort();}
		else
		{	int v;
			struct node *t;
			printf("enter the data to find ---");
			scanf("%d",&v);
			t=binary(v);
			if(t!=NULL)
			{printf("FOUND \n");}
			else
			{printf("NOT FOUND \n");}
		}
		printf("to continue press 1---");
		scanf("%d",&choice);
	}
}