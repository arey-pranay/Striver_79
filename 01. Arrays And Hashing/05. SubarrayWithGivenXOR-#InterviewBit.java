public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        int prefix = 0;

        // Initialize HashMap with a base case
        hm.put(0, 1);

        for (int num : A) {
            prefix = prefix ^ num; // update the continuous XOR of numbers till the current index
            int curr = prefix ^ B; // this is the XOR you need, to get B
            count += hm.getOrDefault(curr,0); //if you have that curr already, then add the number of subarrays that gave you that XOR, to count
            hm.put(prefix, hm.getOrDefault(prefix, 0) + 1); // update or put the prefix obtained by this subarray
        }

        return count;
    }
}
