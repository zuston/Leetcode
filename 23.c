#include <stdio.h>
#include <stdlib.h>
#include <string.h>


// *
//  * Definition for singly-linked list.
//  * struct ListNode {
//  *     int val;
//  *     struct ListNode *next;
//  * };
 
struct ListNode{
	int val;
	struct ListNode *next;
};

struct ListNode* merge(struct ListNode *l1,struct ListNode *l2){
    struct ListNode *head,*p;  
    if(l1==NULL)return l2;  
    if(l2==NULL)return l1;  
    if(l1->val > l2->val){  
        p=l2;  
        l2=l2->next;  
    }else{  
        p=l1;  
        l1=l1->next;  
    }  
    head=p;  
    while(l1!=NULL && l2!=NULL){  
        if(l1->val > l2->val){  
            p->next=l2;  
            l2=l2->next;  
        }else{  
            p->next=l1;  
            l1=l1->next;  
        }  
        p=p->next;  
    }  
    if(l1==NULL)p->next=l2;  
    else p->next=l1;  
    return head; 
}

struct ListNode* mergeKLists(struct ListNode** lists, int listsSize) {
    if(listsSize<=0)    return *lists;
	struct ListNode * p = *lists;
	lists++;
	listsSize--;
	while(listsSize){
	    printf("faf");
		p = merge(p,*lists);
		lists++;
		listsSize--;
	}
	return p;
}


int main(int argc, char const *argv[])
{
	/* code */
	
	return 0;
}