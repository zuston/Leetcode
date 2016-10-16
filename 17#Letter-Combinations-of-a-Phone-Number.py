'''
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
'''

class Solution(object):
    def letterCombinations(self, digits):
        self.dict = {'2':['a','b','c'],
                '3':['d','e','f'],
                '4':['g','h','i'],
                '5':['j','k','l'],
                '6':['m','n','o'],
                '7':['p','q','r','s'],
                '8':['t','u','v'],
                '9':['w','x','y','z']
                }

        self.res=[]
        self.digits = digits
        self.length = len(self.digits)
        if self.length==0:
            return self.res
        self.loop(0,'',self.res)
        return self.res

    def loop(self,step,temp,res):
        if step==self.length:
            res.append(temp)
            return
        else:
            print self.dict[self.digits[step]]
            for letter in self.dict[str(self.digits[step])]:
                self.loop(step+1,temp+letter,res)
