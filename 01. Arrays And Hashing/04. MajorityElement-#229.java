// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         List<Integer> answer = new ArrayList<>();
//         HashMap<Integer, Integer> h = new HashMap<>();
//         int n = nums.length;
//         for(int i=0;i<n;i++){
//             if(h.containsKey(nums[i])){
//                 int a = h.get(nums[i]);
//                 h.put(nums[i] , a+1);
                
//             } else {
//                 h.put(nums[i],1);
//             } 
//         }
//         int nBy3 = n/3;
        // //for traversing through the hashmap, we use an entryset
        // for(Map.Entry<Integer, Integer> a : h.entrySet()) {
        //     Integer key = a.getKey();
        //     Integer value = a.getValue();
        //     if(value > nBy3){
        //     answer.add(key);
        //     }
        // }
       
//         return answer;
//     }
// }

class Solution {
    public List<Integer> majorityElement(int[] nums){
        List<Integer>ls=new ArrayList<>(2);
        int val1=nums[0]; // make the 0th element as val1
        int count1=1; // it's count1 is initially set to 1
        int val2=0; // val2 is undefined
        int count2=0; // count2 is 0
        int n=nums.length;
        for(int i=1;i<n;i++){ // start from 1st index and by the end just 
            if(nums[i]==val1) count1++; // if nums[i]==val1, then increment count1
            else if(nums[i]==val2) count2++; // if nums[i]==val2, then increment count2
            else if(count1==0){ // if count1 reset to 0, then re-assign count1
                val1=nums[i];
                count1++;
            }
            else if(count2==0){ // if count2 reset to 0, then re-assign count2
                val2=nums[i];
                count2++;
            }
            else{
                count1--; 
                count2--;
            }
        }
        if(count1!=0){  // 1 repeated element found
            int c1=0;
            for(int i=0;i<n;i++) if(val1==nums[i]) c1++; // count the exact occurences
            if(c1>n/3) ls.add(val1);
        }
        if(count2!=0){ // More repeated element found
            int c2=0;
            for(int i=0;i<n;i++) if(val2==nums[i]) c2++; //  count the exact occurences
            if(c2>n/3) ls.add(val2);
        }
        return ls;
    }
}
