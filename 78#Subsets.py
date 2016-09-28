class Solution(object):
    def subsets(self, nums):
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
            self.res.append(temp)
            return
        #不放
        self.loop(nums,step+1,temp)
        #放
        temp = temp+[nums[step]]
        self.loop(nums,step+1,temp)
        
