/**
 * Return an array of arrays of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int compInc(const void *a, const void *b){
    return *(int *)a - *(int *)b;
}
int** threeSum(int* nums, int numsSize, int* returnSize) {
    int count = 0;
    int** result = (int**)malloc(sizeof(int*)*(numsSize*(numsSize-1)*(numsSize-2))/6);
    qsort(nums,numsSize,sizeof(nums[0]),compInc);

    for(int i=0;i<numsSize-1;i++){
        int target = nums[i];
        if(i>0&&nums[i]==nums[i-1]) continue;
        int left = i+1;
        int right = numsSize-1;
        while(left<right){
            if(nums[left]+nums[right]+target>0){
                right--;
                continue;
            }
            if(nums[left]+nums[right]+target<0){
                left++;
                continue;
            }
            if(nums[left]+nums[right]+target==0){
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
