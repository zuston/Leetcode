'''
For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
'''

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.res=[]
        self.loop(self.res,[],sorted(nums))
        return self.res

    def loop(self,res,temp,nums):
        if nums==[]:
            res += [temp]
        else:
            for i in range(len(nums)):
                self.loop(res,temp+[nums[i]],nums[:i]+nums[i+1:])
