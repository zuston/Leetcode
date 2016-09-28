#include <stdlib.h>

bool binarySearch(int *nums,int start,int end,int target){
    while(end>=start){
        int mid = (end+start)/2;
        if(nums[mid]==target){
            return true;
        }
        if(nums[mid]<target){
            start = mid+1;
        }
        if(nums[mid]>target){

            end = mid-1;
        }
    }

    return false;
}

bool search(int* nums, int numsSize, int target) {
    int i=0;
    while(nums[i]<=nums[i+1]&&i<numsSize-2){
        i++;
    }
    printf("splir point=%d\n",i);
    return binarySearch(nums,0,i,target) || binarySearch(nums,i+1,numsSize-1,target);
}

int main(int argc, char const *argv[]) {
    /* code */
    return 0;
}
