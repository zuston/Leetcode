#include <stdlib.h>
#include <stdio.h>
// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.
// The matching should cover the entire input string (not partial).
// The function prototype should be:
// bool isMatch(const char *s, const char *p)
// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "a*") → true
// isMatch("aa", ".*") → true
// isMatch("ab", ".*") → true
// isMatch("aab", "c*a*b") → true

bool isMatch(char* s, char* p) {
    if(*p=='\0'){
        if(*s=='\0'){
            return true;
        }else{
            return false;
        }
    }
    if(*(p+1)!='*'){
        if(*p==*s||(*p=='.'&&*s!='\0')){
            return isMatch(s+1,p+1);
        }else{
            return false;
        }
    }else{
        while(*p==*s||(*p=='.'&&*s!='\0')){
            if(isMatch(s,p+2)){
                return true;
            }
            s++;
        }
        return isMatch(s,p+2);
    }
}

int main(int argc, char const *argv[])
{
	/* code */
	char *s = "aaa";
	char *p = "a*";
	int a = isMatch(s,p);
	printf("%d\n", a);
	return 0;
}	