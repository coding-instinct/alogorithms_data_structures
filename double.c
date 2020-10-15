#include<stdio.h>
#include<stdlib.h>
struct node
{
	int data ;
	struct node *next;
	struct node *pre;
};
struct node *head=NULL;
void add()
{
	struct node *temp,*new;
	int da,c=1;
	printf("how many node you want to insert---- ");
	scanf("%d",&c);
	while(c--)
	{
	if (head==NULL)
	{	head=(struct node*)malloc(sizeof(struct node));
		printf("penter the data\n---");
		scanf("%d",&da);
		head->data=da;
		head->next=NULL;
		head->pre=NULL;
		temp=head;
	}
	else
	{	struct node *temp=head;
	while(temp->next!=NULL)
	{
	 temp=temp->next;
	}
	new=(struct node*)malloc(sizeof(struct node));
	printf("penter the data\n---");
	scanf("%d",&da);
	new->data=da;
	new->next=NULL;
	new->pre=temp;
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
void dup()
{
	struct node *temp=head;
	struct node *temp1=head;
	struct node *temp2,*temp3;
	while(temp!=NULL)
	{
	 while(temp1!=NULL)
	{
	 if (temp1->data==temp->data)
	 {temp2=temp1;
	  temp3=temp1;
	  temp1=temp1->pre;
	  temp2=temp2->next;
	  temp1->next=temp2;
	  temp2->pre=temp1;
	  free(temp3);
	 
	 }
	 temp1=temp1->next;
	}
	 temp=temp->next;
	 
	}
}

void revd()
{
	struct node *temp=head;
	struct node *rev;
	while(temp!=NULL)
	{
	 if (temp->next==NULL){rev=temp;}
	 temp=temp->next;
	 
	}
	while(rev!=NULL)
	{
	 printf("data->%d\n",rev->data);
	 rev=rev->pre;
	}
	
}

int main()
{
	int choice=1;
	while (choice==1)
	{
		int op;
		printf("enter the choice \n 1 for adding node\n 2 for display\n 3 for  remvoing duplicate  \n----");
		scanf("%d",&op);
		if (op==1)
		{
			add();
		}
		else if (op==2){
			display();
		}
		else{dup();}
		printf("to go to menu press 1 ");
		scanf("%d",&choice);
	}
}