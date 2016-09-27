#include <stdlib.h>

// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

int minimumTotal(int** triangle, int triangleRowSize, int *triangleColSizes) {
    for(int i=triangleRowSize-1;i>=1;i--){
        for(int j=0;j<i;j++){
            triangle[i-1][j] += triangle[i][j]<triangle[i][j+1]?triangle[i][j]:triangle[i][j+1];
            printf("%d\n",triangle[i-1][j]);
        }
        printf("\n");
    }
    return triangle[0][0];
}

int main(int argc, char const *argv[]) {
  /* code */
  return 0;
}
