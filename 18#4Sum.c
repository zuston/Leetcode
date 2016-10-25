#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <math.h>

int compInc(const void *a, const void *b){
    return *(int *)a - *(int *)b;
}
int** threeSum(int* nums, int numsSize, int* returnSize，int tar) {
    int count = 0;
    int** result = (int**)malloc(sizeof(int*)*(numsSize*(numsSize-1)*(numsSize-2))/6);
    qsort(nums,numsSize,sizeof(nums[0]),compInc);

    for(int i=0;i<numsSize-1;i++){
        int target = nums[i];
        if(i>0&&nums[i]==nums[i-1]) continue;
        int left = i+1;
        int right = numsSize-1;
        while(left<right){
            if(nums[left]+nums[right]+target>tar){
                right--;
                continue;
            }
            if(nums[left]+nums[right]+target<tar){
                left++;
                continue;
            }
            if(nums[left]+nums[right]+target==tar){
                result[count] = (int*)malloc(sizeof(int)*3);
                result[count][0] = nums[i];
                result[count][1] = nums[left];
                result[count][2] = nums[right];
                count ++;
                left++;
                continue;
            }
        }
    }
    *returnSize = count;
    printf("%d\n",*returnSize);
    for(int j=0;j<count;j++){
        for(int i=0;i<3;i++){
            printf("%d,",result[j][i]);
        }
        printf("\n");
    }

    return result;
}

int** fourSum(int* nums, int numsSize, int target, int* returnSize) {
  qsort(nums,numsSize,sizeof(nums[0]),compInc);
  /*
  待补充
  */
  
}

int main(int argc, char const *argv[]) {
  /* code */

  return 0;
}
