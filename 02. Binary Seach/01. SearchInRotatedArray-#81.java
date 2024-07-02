class Solution {
    public boolean search(int[] nums, int target) {
        int b = findBreakPoint(nums);
        if (b == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        } else {
            return binarySearch(nums, target, 0, b) || binarySearch(nums, target, b + 1, nums.length - 1);
        }
    }

    public int findBreakPoint(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return i;
        }
        return -1;
    }

    public boolean binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) return false;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) return true;
        else if (nums[mid] > target) return binarySearch(nums, target, start, mid - 1);
        else return binarySearch(nums, target, mid + 1, end);
    }
}
