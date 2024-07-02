// class Solution {
//     public boolean search(int[] nums, int target) {
//         int b = findBreakPointRec(nums,0,nums.length-1);
//         if (b == -1) {
//             return binarySearch(nums, target, 0, nums.length - 1);
//         } else {
//             return binarySearch(nums, target, 0, b) || binarySearch(nums, target, b + 1, nums.length - 1);
//         }
//     }

//     public int findBreakPoint(int[] arr) {
//         for (int i = 0; i < arr.length - 1; i++) {
//             if (arr[i] > arr[i + 1]) return i;
//         }
//         return -1;
//     }

//      public int findBreakPointRec(int[] nums, int start, int end){
//         if(start==end) return start;
//         // if(nums[start]==nums[end]) return findDifferent(nums,start,end, nums[start]);
//         if(nums[mid]==nums[start] && nums[end]==nums[start]){
//                     start++;
//                     end--;
//                     continue;
//         }
//         int mid = start + (end-start)/2;
//         if(nums[mid]>nums[end]) return findBreakPointRec(nums,mid+1,end);
//         return findBreakPointRec(nums,start,mid);
//     }

//     public int findDifferent(int[] nums, int start, int end, int n){
//         if(start>end) return -1;
//         if(start==end) return start;
//         int mid = start + (end-start)/2;
//         if(nums[mid]!=n) return mid;
//         int a = findDifferent(nums,start,mid,n);
//         return a == -1? findDifferent(nums,mid+1, end, n):a;
//     }

//     public boolean binarySearch(int[] nums, int target, int start, int end) {
//         if (start > end) return false;
//         int mid = start + (end - start) / 2;
//         if (nums[mid] == target) return true;
//         else if (nums[mid] > target) return binarySearch(nums, target, start, mid - 1);
//         else return binarySearch(nums, target, mid + 1, end);
//     }
// }

class Solution {
 
public boolean search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    
    while (start <= end) {
        int mid = start + (end - start) / 2;
        
        // Case 1: If the middle element is the target, return true
        if (nums[mid] == target) {
            return true;
        }
        
        // Case 2: Handle the case where there are duplicates at start and end
        if (nums[start] == nums[mid] && nums[end] == nums[mid]) {
            start++;
        } 
        // Case 3: Left half is sorted
        else if (nums[mid] >= nums[start]) {
            if (target >= nums[start] && target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } 
        // Case 4: Right half is sorted
        else {
            if (target > nums[mid] && target <= nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
    return false;
}


}
