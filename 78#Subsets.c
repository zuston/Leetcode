#include <stdlib.h>
#include <math.h>

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *columnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** subsets(int* nums, int numsSize, int** columnSizes, int* returnSize) {
    int row = pow(2,numsSize);
    printf("row = %d\n",row);
    int column = numsSize;
    printf("column = %d\n",column);
    columnSizes = (char **)malloc(sizeof(char *)*row);
    for(int i=0;i<column;i++){
        columnSizes[i] = (char *)malloc(sizeof(char)*column);
    }

    return columnSizes;
}

int main(int argc, char const *argv[]) {
    /* code */
    return 0;
}
