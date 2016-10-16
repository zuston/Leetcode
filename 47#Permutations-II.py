'''
For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
'''
class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.res=[]
        self.loop2(self.res,[],sorted(nums))
        return self.res

    def loop(self,res,temp,nums):
        if nums==[]:
            if temp not in res:
                res.append(temp)
        else:
            for i in range(len(nums)):
                self.loop(res,temp+[nums[i]],nums[:i]+nums[i+1:])

    def loop2(self,res,temp,nums):
        if nums==[]:
            res.append(temp)
        else:
            for i in range(len(nums)):
                if i>0 and nums[i]==nums[i-1]:
                    continue
                self.loop(res,temp+[nums[i]],nums[:i]+nums[i+1:])
