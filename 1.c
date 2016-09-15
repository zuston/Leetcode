#include <stdio.h>

int* twoSum(int* nums, int numsSize, int target);


int main(){

	int array[] = {3,2,4};
	int *res = twoSum(array,3,6);
	printf("%d\n%d",res[0],res[1] );
}

int* twoSum(int* nums, int numsSize, int target){
	int *cursor = nums;
	int count = 0;
	int *res = malloc(sizeof(int)*2);
	while(count<numsSize){
		int son_count = count+1;
		int *son_cursor = cursor;
		while(son_count<numsSize){
			int current_value = *cursor;
			int next_value = *++son_cursor;
			if(current_value+next_value==target){
				int *r = malloc(sizeof(int)*2);
				r[0] = count;
				r[1] = son_count;
				printf("[%d,%d]",count,son_count);
				return r;
			}
			son_count++;

		}
		cursor++;
		count++;
	}
	return res;
}






