class Solution(object):
    def threeSum(self, nums,targetR):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        size = len(nums)
        nums.sort()
        for i in range(0,size-2):
            target = nums[i]
            left = i+1
            right = size-1
            while left<right:
                if nums[left]+nums[right]+target>targetR:
                    right -= 1
                elif nums[left]+nums[right]+target<targetR:
                    left += 1
                else:
                    if [nums[i],nums[left],nums[right]] not in result:
                        result.append([nums[i],nums[left],nums[right]])
                    left += 1
        return result

    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums.sort()
        res = []
        for i in range(len(nums)):
            if i<len(nums)-2:
                tempR = self.threeSum(nums[i+1:],target-nums[i])
                if len(tempR)>0:
                    for li in tempR:
                        li.append(nums[i])
                        if li not in res:
                            res.append(li)
        return res

if __name__ == '__main__':
    so = Solution()
    so.fourSum([1,0,-1,0,-2,2],0)
