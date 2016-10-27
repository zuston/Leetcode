package leetcode;

/**
 * Created by zuston on 16-10-26.
 */


/**
 *
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */


public class SearchForARange {

    public static int [] res = {-1,-1};
    public static int flag = 0;

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        search(nums,left,right,target);
        if(flag!=0){
            int l = flag;
            int r = flag;
            while (l>=0){
                if (nums[l]==target){
                    l--;
                }else{
                    break;
                }
            }
            while (r<=nums.length-1){
                if (nums[r]==target){
                    r++;
                }else{
                    break;
                }
            }
            res[0] = l+1;
            res[1] = r-1;
            return res;
        }
        return res;
    }

    public static void search(int [] nums,int left,int right,int target){
        if(left>right){
            return;
        }
        int mid = (left+right)/2;
        if(nums[mid]>target){
            search(nums,left,mid-1,target);
        }
        if(nums[mid]<target){
            search(nums,mid+1,right,target);
        }
        if(nums[mid]==target){
            flag = mid;
        }
    }


    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3,3,3,4,5,5,5,5,6,6,6,6,9,9,9};
        searchRange(nums,7);
    }
}
