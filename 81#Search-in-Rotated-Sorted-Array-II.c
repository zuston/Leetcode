#include <stdlib.h>

bool search(int* nums, int numsSize, int target) {
    int i=0;
    while(nums[i]<=nums[i+1]&&i<numsSize-2){
        i++;
    }
    k = i;
    return binarySearch(nums,0,i,target) || binarySearch(nums,i+1,numsSize-1,target);
}

bool binarySearch(int *nums,int start,int end,int target){
    int mid = (start+end)/2;
    while(mid)
}

int main(int argc, char const *argv[]) {
    /* code */
    return 0;
}
