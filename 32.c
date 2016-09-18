#include <stdio.h>
#include <stdlib.h>

// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

// For "(()", the longest valid parentheses substring is "()", which has length = 2.

// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

int longestValidParentheses(char* s) {
    int len = strlen(s);
    char stack[len];
    int pos[len];
    int top=0;
    int i=0;
    int temp=0;
    int max=0;
    while(*s!='\0'){
        if(*s=='('){
            stack[top] = *s;
            pos[top] = i;
            i++;
            top++;
        }else{
            if(i==0){
                stack[top] = *s;
                pos[top] = i;
                i++;
                top++;
            }else{
                printf("i\t%d\n",i );
                printf("top\t%d\n",top );
                if(stack[top-1]=='('){
                    if(top==1){
                        //重点
                        temp = i+1;
                        printf("temp is %d\n",temp);
                    }else{
                        temp = i-pos[top-2];
                    }
                    max = max>=temp?max:temp;
                    top--;
                    i++;
                }else{
                    stack[top] = *s;
                    pos[top] = i;
                    i++;
                    top++;
                }
            }
        }
        s++;
    }
    return max;
}


int main(int argc, char const *argv[])
{
	/* code */
	printf("%d\n", longestValidParentheses("((()()"));
	return 0;
}