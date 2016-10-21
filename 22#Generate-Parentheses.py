#coding:utf-8
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        self.res = []
        self.loop(n,n,'')
        return self.res

    def loop(self,left,right,string):
        # 表明左括号少于右括号，说明不是合理的式子
        if left>right:
            return
        if left==0 and right==0:
            self.res.append(string)

        if left>0:
            self.loop(left-1,right,string+"(")
        if right>0:
            self.loop(left,right-1,string+")")

if __name__ == "__main__":
    sp = Solution()
    print sp.generateParenthesis(3)
