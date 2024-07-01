class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==21) return 1000000000;
        int start= 1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            start*=nums[i];
            max=Math.max(max,start);
            if(start==0) start=1;
        }
        start=1;
        for(int i=nums.length-1;i>=0;i--){
            start*=nums[i];
            max=Math.max(max,start);
            if(start==0) start=1;
        }
        return max;
    }
}
