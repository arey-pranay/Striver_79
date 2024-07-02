class Solution {
    public int findMin(int[] nums) {
        return nums[findBreakPoint(nums,0,nums.length-1)];
    }
    public int findBreakPoint(int[] nums, int start, int end){
        if(start==end) return start;
        int mid = start + (end-start)/2;
        if(nums[mid]>nums[end]) return findBreakPoint(nums,mid+1,end);
        return findBreakPoint(nums,start,mid);
    }
}
