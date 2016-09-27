#include <stdlib.h>

// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
// For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
// the contiguous subarray [4,-1,2,1] has the largest sum = 6.

int maxSubArray(int* nums, int numsSize) {
    int sum[numsSize-1];
    int max=nums[0];
    sum[0]=nums[0];
    for(int i=1;i<numsSize;i++){
        if(nums[i]>0){
            if(sum[i-1]<0){
                sum[i] = nums[i];
            }else{
                sum[i] = sum[i-1]+nums[i];
            }
        }else{
            if(sum[i-1]>0){
               if(sum[i-1]+nums[i]>nums[i]){
                   sum[i] = sum[i-1]+nums[i];
               }else{
                   sum[i] = nums[i];
               }
            }else{
                sum[i] = nums[i];
            }
            // sum[i] = nums[i];
        }
        max = max>sum[i]?max:sum[i];
        printf("max:%d\n",max);
    }
    return max;
}

int main(int argc, char const *argv[]) {
  /* code */
  return 0;
}
