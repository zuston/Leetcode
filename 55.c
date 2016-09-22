#include <stdlib.h>
#include <stdio.h>


// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

// For example:
// A = [2,3,1,1,4], return true.

// A = [3,2,1,0,4], return false.



bool canJump(int* nums, int numsSize) {
    int length = 1;
    for(int i=0;i<length&&length<numsSize;i++){
        length = nums[i]+1+i>length?nums[i]+1+i:length;
    }
    return length>=numsSize;
}

int main(int argc, char const *argv[])
{
	/* code */
	return 0;
}