// // class Solution {
// //     public List<List<Integer>> threeSum(int[] nums) {
// //         HashSet<List<Integer>> s = new HashSet<>();
// //         Arrays.sort(nums);
// //         int sz = nums.length;
// //         int i = 0;
// //         while(i<sz){
// //             int j = i+1;
// //             int k = sz-1;
// //             while(j<k){
// //                 if(nums[i]+nums[j]+nums[k]==0) {
// //                     List<Integer> l = new ArrayList<>();
// //                     l.add(nums[i]); l.add(nums[j]); l.add(nums[k]);
// //                     s.add(l);
// //                     j++;
// //                     k--;
// //                 } else if (nums[i]+nums[j]+nums[k]>0){
// //                     k--;
// //                 } else j++;
// //             }
// //             i++;
// //         }
// //         List<List<Integer>> ans = new ArrayList<>();
// //         for(List<Integer> l : s) ans.add(l);
// //         return ans;
// //     }
// // }

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         // 1. fix 1 element while looping array
//         // 중복 방지 - Set 사용
//         Set<List<Integer>> set = new HashSet<>();
//         Arrays.sort(nums);

//         // 2. do 2sum with fixed 1 element, where target = 0;
//         for (int i = 0; i < nums.length - 2; i++) {
//             // 생각 못함 - 중복방지 코드 추가 - runtime 줄임
//             if (i > 0 && nums[i] == nums[i-1]) continue;
//             int min = i + 1;
//             int max = nums.length - 1;
            
//             while (min < max) {
//                 int sum = nums[i] + nums[min] + nums[max];
//                 if (sum == 0) {
//                     set.add(Arrays.asList(nums[i], nums[min], nums[max]));
//                     min++;
//                     max--;
//                 } else if (sum < 0) {
//                     min++;
//                 } else {
//                     max--;
//                 }
//             }
//         } 
//         return new ArrayList<>(set);
//     }
// }
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            twoSum(-nums[i], nums, i + 1, list);
        }

        return list;
    }

    private void twoSum(int target, int[] nums, int startIndex, List<List<Integer>> list) {
        int i = startIndex;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
                continue;
            }

            if (nums[i] + nums[j] > target) {
                j--;
                continue;
            }

            list.add(Arrays.asList(-target, nums[i], nums[j]));
            i++;
            j--;

            while (j > i && nums[j] == nums[j + 1]) {
                j--;
            }
        }
    }
}
