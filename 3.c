#include <stdlib.h>
#include <stdio.h>

int lengthOfLongestSubstring(char* s);

int main(){
	return 0;
}

// Given "abcabcbb", the answer is "abc", which the length is 3.

// Given "bbbbb", the answer is "b", with the length of 1.

// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

int lengthOfLongestSubstring(char *s){
	int lengthOfLongestSubstring(char* s){
    int length = strlen(s);
    if(length==1){
        return 1;
    }
    int max = 0;
    for(int i=0;i<length;i++){
        int m = 1;
        int flag = 0;
        for(int j=i+1;j<length;j++){
           int k = i;
           while(k<j){
               if(s[k]==s[j]){
                //   printf("i:%d,j:%d,k:%d\n",i,j,k);
                   m = j-i;
                   flag = 1;
                   break;
               }
    
               k++;
           }
           if(k==j){
               m=j-i+1;
           }
           if(flag==1){
               break;
           }
        }
        max = (max>m)?max:m;
    }
    return max;
}
}