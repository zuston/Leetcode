'''
For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
'''

class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        size = len(nums)
        nums.sort()
        for i in range(0,size-2):
            target = 0-nums[i]
            left = i+1
            right = size-1
            while left<right:
                if nums[left]+nums[right]>target:
                    right -= 1
                elif nums[left]+nums[right]<target:
                    left += 1
                else:
                    if [nums[i],nums[left],nums[right]] not in result:
                        result.append([nums[i],nums[left],nums[right]])
                    left += 1
        return result
