#include <stdio.h>
#include <stdlib.h>

// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// You are given a target value to search. If found in the array return its index, otherwise return -1.

// You may assume no duplicate exists in the array.

// 对于一个翻转过的有序数组，找出翻转的点，再根据target值来进行查找

int binary_search(int start,int end,int target,int *nums){
	int mid = (start+end)/2;
	if(target==nums[mid])	return mid;
	if(end-start<0)	return -1;
	if(target<nums[mid])	return binary_search(start,mid-1,target,nums);
	if(target>nums[mid])	return binary_search(mid+1,end,target,nums);

}

int search(int* nums, int numsSize, int target) {
    int index = 0;
    while(index<numsSize-1&&nums[index]<nums[index+1]){
    	index++;
    	//此时index为临界值的下标
    }

    if(target>=nums[0]&&target<=nums[index]){
    	return binary_search(0,index,target,nums);
    }else{
    	return binary_search(index+1,numsSize-1,target,nums);
    }
}	

int main(int argc, char const *argv[])
{
	/* code */
	return 0;
}