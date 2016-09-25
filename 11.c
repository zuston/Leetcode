#include <stdlib.h>

// 11. Container With Most Water

// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

// Note: You may not slant the container.

int maxArea(int* height, int heightSize) {
    int head=0,res=0,tail=heightSize-1;
    while(tail>head){
        int tempRes = (height[head]-height[tail]>0?height[tail]:height[head])*(tail-head);
        res = tempRes-res>0?tempRes:res;
        if(height[head]<height[tail]){
            head++;
        }else{
            tail--;
        }
    }
    return res;
}

int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}