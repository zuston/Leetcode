#include <stdlib.h>


int removeDuplicates(int* nums, int numsSize) {
    if(numsSize<=2) return numsSize;
    int flag=0;
    int index = 0;
    for(int i=1;i<numsSize;i++){
        if(flag==0&&nums[index]==nums[i]){
            flag=1;
            nums[++index] = nums[i];
        }
        if(nums[index]!=nums[i]){
            nums[++index] = nums[i];
            flag = 0;
        }
    }
    return index+1;
}

int main(int argc, char const *argv[]) {
    /* code */
    return 0;
}
