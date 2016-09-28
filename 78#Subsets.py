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
        self.loop(nums,step+1,temp)
        temp = temp+[nums[step]]
        self.loop(nums,step+1,temp)
        
