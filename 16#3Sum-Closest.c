#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <math.h>

int compInc(const void *a, const void *b){
    return *(int *)a - *(int *)b;
}

int threeSumClosest(int* nums, int numsSize, int target) {
  int res = nums[0]+nums[1]+nums[2];
  int closet = res;
  if(abs(res-target)==0){
    return res;
  }
  qsort(nums,numsSize,sizeof(nums[0]),compInc);

  for(int i=0;i<numsSize-2;i++){
    int left = i+1;
    int right = numsSize-1;
    while(left<right){
      int summ = nums[i]+nums[left]+nums[right];
      if(abs(summ-target)<abs(closet-target)){
        closet = summ;
      }
      if(summ<=target){
        left++;
      }else{
        right--;
      }
    }
  }
  return closet;
}

int main(int argc, char const *argv[]) {
  /* code */

  return 0;
}
