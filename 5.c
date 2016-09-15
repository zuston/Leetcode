#include <stdlib.h>
#include <stdio.h>
#include <string.h>
char* longestPalindrome(char* s);
int main(){

	char *s = "ssaass";
	printf("%s\n", longestPalindrome(s));
	// printf("len:%d\n", strlen(longestPalindrome(s)));
	return 0;
}

//查找回文字符
char* longestPalindrome(char* s) {
	int len = strlen(s);
	if(len==1){
		return s;
	}
	int leftposition;
	int rightposition;
	int max = 0;
	for(int i=0;i<len;i++){
		if(i==0){
			if(s[1]==s[0]){
		    	if(max<2){
					leftposition=0;
					rightposition=1;
				}
			}
			continue;
		}
		//奇数
		int left = i-1;
		int right = i+1;
		while(left>=0&&right<len){
			if(s[left]==s[right]){
				int tempmax = right-left+1;
				if(tempmax>max){
					leftposition = left;
					rightposition = right;
					max = tempmax;
				}
				left--;
				right++;
			}else{
				break;
			}
		}

		//偶数
		left = i;
		right = i+1;
		while(left>=0&&right<len){
			if(s[left]==s[right]){
				int tempmax = right-left+1;
				if(tempmax>max){
					leftposition = left;
					rightposition = right;
					max = tempmax;
				}
				left--;
				right++;
			}else{
				break;
			}
		}
	}

	char *resstring = malloc(sizeof(char)*(max+1));
	char *res=resstring;
	for(int k=leftposition;k<=rightposition;k++){
		printf("%c\n",s[k]);
		*resstring++ = s[k];
	}

	*resstring = '\0';
	return res;
}
