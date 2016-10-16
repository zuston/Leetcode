'''
For example,
If n = 4 and k = 2, a solution is:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
'''
class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        nums=[i for i in range(1,n+1)]
        self.res =[]
        self.k=k
        self.loop(self.res,[],nums,0)
        return self.res

    def loop(self,res,temp,nums,step):
        if step==self.k:
            res.append(temp)
        else:
            for i in range(len(nums)):
                if nums[i] not in temp:
                    if i==0 and len(temp)==0:
                        self.loop(res,temp+[nums[i]],nums,step+1)
                    if i>0 :
                        if len(temp)>0 and nums[i]>temp[-1]:
                            self.loop(res,temp+[nums[i]],nums,step+1)
                        if len(temp)==0:
                            self.loop(res,temp+[nums[i]],nums,step+1)
