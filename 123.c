#include <stdlib.h>

//暴力破解，可惜超时
int maxProfit(int* prices, int pricesSize) {
    int max = 0;
    int oneMax;
    int twoMax;
    for(int i=0;i<pricesSize;i++){
        oneMax = splitMaxProfit(prices,0,i-1);
        twoMax = splitMaxProfit(prices,i,pricesSize-1);
        int tempMax = oneMax+twoMax;
        max = tempMax>max?tempMax:max;
    }
    return max;
}

int splitMaxProfit(int *prices,int start,int end){
    if(end-start<=0){
        return 0;
    }
    int oneMax = 0;
    int minI = prices[start];
    for(int i=start+1;i<=end;i++){
        oneMax = prices[i]-minI>oneMax?prices[i]-minI:oneMax;
        minI = prices[i]<minI?prices[i]:minI;
    }
    return oneMax;
}

int main(int argc, char const *argv[]) {
    /* code */
    return 0;
}
