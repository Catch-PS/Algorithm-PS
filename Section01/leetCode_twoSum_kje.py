Python 3.9.0 (v3.9.0:9cf6752276, Oct  5 2020, 11:29:23) 
[Clang 6.0 (clang-600.0.57)] on darwin
Type "help", "copyright", "credits" or "license()" for more information.
>>> class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        ret = []
        for first in range(len(nums)) :
            for second in range(first+1,len(nums)) :
                if nums[first] + nums[second] == target :
                    return [first, second]