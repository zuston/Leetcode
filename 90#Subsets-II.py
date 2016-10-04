
# Given a collection of integers that might contain duplicates, nums, return all possible subsets.
#
# Note: The solution set must not contain duplicate subsets.
#
# For example,
# If nums = [1,2,2], a solution is:
#
# [
#   [2],
#   [1],
#   [1,2,2],
#   [2,2],
#   [1,2],
#   []
# ]


class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.res = []
        self.temp=[]
        self.loop(sorted(nums),0,self.temp)
        return self.res

    def loop(self,nums,step,temp):
        if step==len(nums):
            if temp not in self.res:
                self.res.append(temp)
            return
        self.loop(nums,step+1,temp)
        temp = temp+[nums[step]]
        self.loop(nums,step+1,temp)
