#include<stdio.h>
#include<stdlib.h>
struct node
{
 int data;
 struct node *next;
};
struct node *head=NULL;
struct node *createnode(struct node*);
struct node *display(struct node*);
struct node *insertnode_end(struct node*);
struct node *insertnode_beg(struct node*);
struct node *insertnode_pos(struct node*);
struct node *insertnode_after(struct node*);
int main()
{
       int data,key;
       printf("\n...press 1 to create node....\n");
       scanf("%d",&key);
       if(key==1)
       {
              createnode(head);
              printf("linklist is created\n");
              display(head);
       }
       else
       {
         printf("you have no option go and press 1");
       }
}
    struct node *createnode(struct node *head)
    {
           struct node *ptr,*temp;
           int data,n,p,a,c;
           printf("enter the data\n");
           scanf("%d",&data);
           ptr=(struct node *)malloc(sizeof(struct node));
           ptr->data=data;
           ptr->next=NULL;
           if(head=NULL)
           {
                  ptr->next=head;
                  head=ptr;
                 temp=head;
           }
           else
           {
           head=ptr;
           temp=head;
           printf("press 1 to create more nodes or press any key to exit\n");
           scanf("%d",&n);
           while(n==1)
           {
           printf("enter the data\n");
           scanf("%d",&data);
           ptr=(struct node *)malloc(sizeof(struct node));
           ptr->data=data;
           ptr->next=NULL;
           temp->next=ptr;
           temp=temp->next;
           printf("press 1 to create more nodes or press any key to exit\n");
           scanf("%d",&n);
           }
           printf("\npress 0 to insert any data at END //////OR /////\npress 1 to insert at BEGINNING///// or////\n press 3 to insert at POSITION OF  YOUR CHOICE\n");
           scanf("%d",&a);
           if(a==0)
           {
           insertnode_end(head);
           }
           else if(a==1)
           {
                  insertnode_beg(head);
           }
           else if(a==3)
           {
                  printf("press 4 to insert data before given data//OR//\n press 5 to insert data after given data");
                  scanf("%d",&c);
           if(c==4)
           {
                  insertnode_pos(head);
                  printf("your node is inserted SUCCESFULLY");
           }
           else if(c==5)
           {
                  insertnode_after(head);
                  printf("YOUR NODE IS INERTED SUCCESSFULLY");
           }
           printf("press 2 to display..\n");
           scanf("%d",&p);
           if(p==2)
           {
           display(head);
           }
           return head;
           }
    }
 struct node*display(struct node*head)
 {
       struct node *ptr,*temp;
       temp=head;
       while(temp!=NULL)
       {
              printf("DATA=%d\n",temp->data);
              temp=temp->next;
       }
       return head;
 }
struct node *insertnode_end(struct node *head)
{
       struct node *ptr,*temp,*new_node;
       int data,n,p;
       printf("\n enter the you want to insert \n");
       scanf("%d",&n);
       new_node=(struct node *)malloc(sizeof(struct node));
       new_node->data=n;
       new_node->next=NULL;
       temp=head;
       while(temp->next!=NULL)
       {
              temp=temp->next;
              }
       temp->next=new_node;
       printf("new data is inserted at end... be happy\n\n");
       return head;

}
struct node *insertnode_beg(struct node *head)
{
       struct node *newNode;
       int data,b;
       printf("\nenter the data you want to insert\n");
       scanf("%d",&b);
       newNode=(struct node*)malloc(sizeof(struct node));
       newNode->data=b;
       newNode->next=head;
       head=newNode;
       printf("\nnew node is inserted at beginning\n");
       return head;

}

struct node *insertnode_pos(struct node *head)
{
       struct node *new_node,*ptr,*preptr,*temp;
       int data,val;
       printf("\n enter data you want to insert \n");
       scanf("%d",&data);
       printf("enter the val before you want to insert\n");
       scanf("%d",&val);
       new_node=(struct node*)malloc(sizeof(struct node));
       new_node->data=data;
       ptr=head;
       preptr=ptr;
        while(ptr->data!=val)
        {
               preptr=ptr;
               ptr=ptr->next;
        }
        new_node->next=ptr;
        preptr->next=new_node;
        printf("\nnew node is inserted\n");
        return head;

}
struct node *insertnode_after(struct node *head)
{
       struct node *ptr,*preptr,*new_node;
       int data,val;
       printf("enter data you want to insert ");
       scanf("%d",&data);
       printf("enter data after you want to insert");
       scanf("%d",&val);
       new_node=(struct node*)malloc(sizeof(struct node));
       new_node->data=data;
       preptr=head;
       ptr=preptr;
       while(preptr->data!=val)
       {
              preptr=ptr;
              ptr=ptr->next;
       }
       new_node->next=ptr;
       preptr->next=new_node;
       printf("new data is inserted\n");
       return head;
}
