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


// Say you have an array for which the ith element is the price of a given stock on day i.
// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
// Input: [7, 1, 5, 3, 6, 4]
// Output: 5
//
// max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

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
