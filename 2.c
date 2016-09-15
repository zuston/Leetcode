#include <stdio.h>
#include <stdlib.h>


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

//  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//  Output: 7 -> 0 -> 8

typedef struct ListNode {
	int val;
	struct ListNode *next;
};

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2);

int main(){
	
	
	struct ListNode* p3= (struct ListNode *)malloc(sizeof(struct ListNode));
	p3->val = 3 ;
	p3->next = NULL;
	struct ListNode* p2= (struct ListNode *)malloc(sizeof(struct ListNode));
	p2->val = 2;
	p2->next = p3;
	struct ListNode* l1= (struct ListNode *)malloc(sizeof(struct ListNode));
	l1->val = 1;
	l1->next = p2;

	struct ListNode* z3 = (struct ListNode *)malloc(sizeof(struct ListNode));
	z3->val = 3 ;
	z3->next = NULL;
	struct ListNode* z2= (struct ListNode *)malloc(sizeof(struct ListNode));
	z2->val = 2;
	z2->next = z3;
	struct ListNode* l2= (struct ListNode *)malloc(sizeof(struct ListNode));
	l2->val = 1;
	l2->next = z2;
	

	struct ListNode *r = addTwoNumbers(l1,l2);
	while(r){
		printf("%d\n", r->val);
	}
}

struct ListNode * addTwoNumbers(struct ListNode* l1 ,struct ListNode* l2){
	struct ListNode * list1 = l1;
	struct ListNode * list2 = l2;

	// 尾插法
	struct ListNode * temp;
	struct ListNode * tail;
	struct ListNode * list = (struct ListNode *)malloc(sizeof(struct ListNode));
	tail = list;
	int value = 0;
	while(list1||list2){
		temp=(struct ListNode *)malloc(sizeof(struct ListNode));
		if(list1&&list2){
			temp->val = (list1->val+list2->val+value)%10;
			value = (list1->val+list2->val+value)/10;
			list1 = list1->next;
			list2 = list2->next;
		}else if(list1==NULL&&list2!=NULL){
			temp->val = (list2->val+value)%10;
			value = (list2->val+value)/10;
			list2 = list2->next;
		}else if(list2==NULL&&list1!=NULL){
			temp->val = (list1->val+value)%10;
			value = (list1->val+value)/10;
			list1 = list1->next;
		}
		printf("temp :%d\n", temp->val);
		
		printf("value :%d\n",value);
		tail->next = temp;
		tail = temp;
	}
	if(value!=0){
	    temp = (struct ListNode *)malloc(sizeof(struct ListNode));
	    temp -> val = value;
	    tail -> next = temp;
	    tail = temp;
	}
	tail->next = NULL;
	return list->next;
}