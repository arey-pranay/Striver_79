# Arrays and Hashing

### 1. Next Permutation
  - Find the breaking point from left, i. Start from last and keep coming back till you find a j such that arr[j]>arr[i].
  - Swap the jth and ith element. Reverse everything after i.

### 2. Three Sum
  - Sort the array given to you. If nums[i] and nums[i-1] are different, then call twoSum on -nums[i],nums,i+1,list. -nums[i] is your target for twoSum.
  - Put i at passed index, j at end. while(i<j) sum<target i++, sum>target j--, otherwise add in list and i++ j--. and while(nums[j]>nums[j+1]) j--

### 3. Maximum Subarray (Kadane's Algorithm) 
  - O(n)- current =0; i=0; maxi = Integer.MIN_VALUEKeep traversing and if current += a[i]. maxi update. if (current <0) current =0;
  - Return maxi.

### 4. Majority Element (more than n/3). ( Also do Moore's voting algo for more than n/2 ) 
  - There can max be 2 such elements. Use Moore's algo for 2 elements.  if(nums[i]==val1) count1++; and same for 2.
  - if count1 reset to 0, then re-assign count1. At the end, increment count and if it reaches n/3 then add it to list.

### 5. SubArray with given XOR ✨
  - https://www.youtube.com/watch?v=eZr-6p0B7ME
  - Use HashMap to store the different XOR prefixes that you get along with their number of occurences. Update count accordingly by getOrDefault() from the hashmap.

### 6. Missing and Repeating ✨
  - https://chatgpt.com/share/670061e3-3341-4d82-8c8c-fd2257183619
  - Sum of nums give a-b and sum of squares of nums give a2 - b2. (Expected - Actual). Use math after this. Amazing wow.

### 7. Count Inversions 🤯

### 8. Maximum Product Subarray 
  - Product from front to back. 0 to n. when product = 0, reset it to 1. max=Math.max(max,product)
  - Product from back to front. n to 0. when product = 0, reset it to 1. max=Math.max(max,product)

# Binary Search

### 9. Search in rotated array
  - Find the breakPoint by returning i where arr[i] > arr[i+1]. If b == -1, search the full array with binary search.
  - Else return (binary search from 0 to b || then b+1 to nums.length-1) . In that if start > end return false, else recursively keep calling binarySearch.

### 10. Find Min in rotated array
  - Use iterative binarysearch. If found then return true. Then first check if start, end and mid are same, if yes then do start++ or end--.
  - if(nums[mid] >= nums[start]) it means that left half is sorted. if target between start and mid, then end=mid-1. else start=mid+1. Else do same for checking right half.

### 11. Find Peak Element
  - An element which breaks the sorted order. In every call of bs if(nums[mid+1]<nums[mid]) it means that the peak was broken somewhere before mid, so call with (nums,start,mid)
  - Otherwise call with (nums,mid+1,end).

### 12. 
