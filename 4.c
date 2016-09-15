#include <stdio.h>
#include <stdlib.h>

int main(){
    return 1;
}
double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    int res[nums1Size+nums2Size];
    int count = 0;
    int s1 = 0;
    int s2 = 0;
    while(s1<nums1Size&&s2<nums2Size){
        res[count] = (*nums1>=*nums2)?*nums2:*nums1;
        if(*nums2>=*nums1){
            nums1++;
            s1++;
        }else{
            nums2++;
            s2++;
        }
        count++;
    }
    printf("s1:%d,s2:%d\n",s1,s2);
    printf("count:%d\n",count);
    if(s1==nums1Size){
        while(s2<nums2Size){
            res[count] = *nums2++;
            count++;
            s2++;
        }
        // printf("%d\n",res[3]);
        int s = nums1Size + nums2Size;
        if(s%2==0){
            printf("%d,%d",res[s/2-1],res[s/2]);
            float r = (1.0*res[s/2-1]+1.0*res[s/2])/2;
            return r;
        }else{
            return 1.0*res[s/2];
        }
    }
    if(s2==nums2Size){
        while(s1<nums1Size){
            res[count] = *nums1++;
            count++;
            s1++;
        }
        // printf("%d\n",res[3]);
        int s = nums2Size + nums1Size;
        if(s%2==0){
            printf("%d,%d",res[s/2-1],res[s/2]);
            float r = (1.0*res[s/2-1]+1.0*res[s/2])/2;
            return r;
        }else{
            return 1.0*res[s/2];
        }
    }
    return 0;
}