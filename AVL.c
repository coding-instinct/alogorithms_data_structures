#include<stdio.h>
#include<stdlib.h>
struct node 
{
    int data;
    int height;
    struct node *left,*right;
};
int height (struct node *node)
{
    if (node == NULL)
        return 0;
    else 
        return node->height;
}

int max(int x, int y)
{
    if (x > y)
        return x;
    else 
        return y;
}
int self_balance(struct node *node)
{
    if (node == NULL)
        return 0;
    else
        return (height(node->left) - height(node->right));
}
struct node *R_rotation(struct node *node)
{
    struct node *temp1 = node->left;
    struct node *temp2 = temp1->right;
    temp1->right = node;
    node->left = temp2;
    node->height = max(height(node->left),height(node->right))+1;
    temp1->height = max(height(temp1->left),height(temp1->right))+1;
    return temp1;
}   
struct node *L_rotation(struct node *node)
{
    struct node *tmp1 = node->right;
    struct node *tmp2 = tmp1->left;
    tmp1->left = node;
    node->right = tmp2;
    node->height = max(height(node->left),height(node->right))+1;
    tmp1->height = max(height(tmp1->left),height(tmp1->right))+1;
    return tmp1;
}
struct node *new(int data)
{
    struct node *temp = (struct node *)malloc(sizeof(struct node));
    temp->data = data;
    temp->left = temp->right = NULL;
    temp->height = 1;
    return temp;
}
struct node *minNode(struct node *node)
{
    struct node *tmp = node;
    while (tmp->left != NULL)
    {
        tmp = tmp->left;
    }
    return tmp;
}
struct node *delete(struct node *root,int data)
{
    if (root == NULL)
    {
        printf("Value Is Not Found In The Tree\n");
        return root;
    }
    else if (data < root->data)
        root->left = delete(root->left,data);
    else if (data > root->data)
        root->right = delete(root->right,data);
    else
    {
        if (root->left == NULL)
        {
            struct node *temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL)
        {
            struct node *temp = root->left;
            free(root);
            return temp;
        }    
        else 
        {
            struct node *temp = minNode(root->right);
            root->data = temp->data;
            root->right = delete(root->right,temp->data);
        }
    }
    if (root == NULL)
        return root;
    root->height = 1 + max(height(root->left),height(root->right));
    int bal = self_balance(root);
    if (bal > 1 && self_balance(root->left) >= 0)
    {   
        return R_rotation(root);
    }
    else if (bal > 1 && self_balance(root->left) < 0)
    {
        root->left = L_rotation(root->left);
        return R_rotation(root);
    }
    else if (bal < -1 && self_balance(root->right) > 0)
    {
        root->right = R_rotation(root->right);
        return L_rotation(root);
    }
    else if (bal < -1 && self_balance(root->right) <= 0)
    {
        return L_rotation(root);
    }
    return root; 
}
struct node *insert(struct node *node,int data)
{
    if (node == NULL)
        return new(data);
    else if (data < node->data){
        node->left = insert(node->left,data);
    }
    else if (data > node->data)
        node->right = insert(node->right,data);
    else 
        return node;
    node->height = 1 + max(height(node->left),height(node->right));
    int bal = self_balance(node);
    if (bal > 1 && data < node->left->data)
    {   
        return R_rotation(node);
    }
    else if (bal > 1 && data > node->left->data)
    {
        node->left = L_rotation(node->left);
        return R_rotation(node);
    }
    else if (bal < -1 && data < node->right->data)
    {
        node->right = R_rotation(node->right);
        return L_rotation(node);
    }
    else if (bal < -1 && data > node->right->data)
    {
        return L_rotation(node);
    }
    else 
        return node;  
}
void pre_order(struct node *root)
{       
    if (root != NULL)
    {   
        printf("%d ",root->data);
        pre_order(root->left);
        pre_order(root->right);
    }   
}     
int main()
{
    int key,data;
    struct node *root = NULL;
    printf("To Create An AVL Tree, Enter 1\nTo Insert A Node In An AVL Tree, Enter 2\nTo Delete A Node From The Tree, Enter 3\nTo Display The AVL Tree, Enter 4\nTo Exit The Program, Enter 5\n");
    while (1)
    {
        printf("\nEnter Choice :- ");
        scanf("%d",&key);
        switch (key)
        {
            case 1 : printf("Enter the value of root node :- ");
                     scanf("%d",&data);
                     root = insert(root,data);
                     printf("Enter the value of other nodes :- ");
                     scanf("%d",&data);
                     root = insert(root,data);
                     printf("Enter the value of other nodes :- ");
                     scanf("%d",&data);
                     root = insert(root,data);
                     printf("Enter the value of other nodes :- ");
                     scanf("%d",&data);
                     root = insert(root,data);
                     printf("Enter the value of other nodes :- ");
                     scanf("%d",&data);
                     root = insert(root,data);
                     printf("Enter the value of other nodes :- ");
                     scanf("%d",&data);
                     root = insert(root,data);
                     break;
            case 2 : printf("Enter the value you want to insert in the tree :- ");
                     scanf("%d",&data);
                     root = insert(root,data);
                     break;
            case 3 : printf("Enter the value you want to delete from the tree :- ");
                     scanf("%d",&data);
                     root = delete(root,data);
                     break;
            case 4 : printf("The AVL Tree is as follows :- \n");
                     pre_order(root);
                     break;
            case 5 : printf("Thank You :)\n");
                     exit(0);
            default : printf("Wrong Choice Entered\nexit function\n\n");
                      break;
        }
    }
    return 0;
}