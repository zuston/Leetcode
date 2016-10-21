class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        res = nums[0]+nums[1]+nums[2]
        closet = res
        if abs(res-target)==0:
            return res
        nums.sort()
        size = len(nums)
        for i in range(size):
            left = i+1
            right = size-1
            while left<right:
                summ = nums[i]+nums[left]+nums[right]
                if abs(summ-target)<abs(closet-target):
                    closet = summ
                if summ <= target:
                    left += 1
                else:
                    right -= 1
        return closet
