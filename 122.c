// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit.
// You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
// However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

#include <stdlib.h>
#include <stdio.h>

// 设有有一个序列
// [1,2,3,4,5]
// 则多次买入卖出的最大值：4
//
// 设有一个序列：
// [2,8,1,9,18,10]
// 则多次买入卖出的最大值：23
//
//
// 对于买入卖出，无论序列如何，都应该划归为多段下的单调增序列，才能实现盈利，如第二个序列则划分为------
// [2,8]
// [1,9,18]
// 那么对于分割开的递增序列来说，最大值无疑是末减去首


int maxProfit(int* prices, int pricesSize) {
     int maxProfit = 0;
     for(int i=1;i<pricesSize;i++){
         maxProfit += prices[i]-prices[i-1]>0?prices[i]-prices[i-1]:0;
     }
     return maxProfit;
}


int main(int argc, char const *argv[]) {
    /* code */
    return 0;
}
