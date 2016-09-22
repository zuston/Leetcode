#include <stdlib.h>
#include <stdio.h>

int jump(int* nums, int numsSize) {

    int i=0;

    int step=0;

    int flag=0;

    while(i<numsSize-1){

        if(nums[i]>=numsSize-i-1){

            return step+1;

        }

        int max=0;

        for(int k=i+1;k<=i+nums[i]&&k<numsSize;k++){

            if(nums[k]+k-i-1>=max){

                max = nums[k]+k-i-1;

                flag = k;

            }

        }

        // printf("a[%d] value is %d,choose the position is %d\n",i,nums[i],flag);

        step++;

        i = flag;

    }

    return step;

}

int main(){
    return 0;
}
