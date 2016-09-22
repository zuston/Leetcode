#include <stdlib.h>
#include <stdio.h>

//暴力解法
// int maxProfit(int* prices, int pricesSize) {
//
//     int max = 0;
//
//     for(int i=0;i<pricesSize;i++){
//
//         for(int k=i+1;k<pricesSize;k++){
//
//             max = prices[k]-prices[i]>max?prices[k]-prices[i]:max;
//
//         }
//
//     }
//
//     return max;
//
// }

int maxProfit(int *prices,int pricesSize){
    if(pricesSize<2)    return 0;
    int max=0;
    int minI = prices[0];
    for(int i=0;i<pricesSize;i++){
        max = prices[i]-minI>max?prices[i]-minI:max;
        minI = prices[i]<minI?prices[i]:minI;
    }
    return max;
}

int main(){

    return 0;

}
