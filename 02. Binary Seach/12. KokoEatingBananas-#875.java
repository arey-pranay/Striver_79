// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         // Calculate the sum of all bananas in the piles
//         long sum = 0;
//         for (int n : piles) {
//             sum += n;
//         }
        
//         // Compute the minimum and maximum possible eating speeds
//         // min is the ceiling of sum / h, ensuring at least `sum / h` bananas per hour
//         // max is a higher initial guess for binary search
//         int min = (int) Math.ceil((double) sum / h);
//         int max = (int) Math.ceil((double) sum / (h - piles.length + 1));
//         int mid = 0;
        
//         // Use binary search to find the minimum eating speed
//         while (min < max) {
//             // Calculate the midpoint speed
//             mid = (max + min) / 2;
//             int time = 0;
            
//             // Calculate the total hours required at the current eating speed `mid`
//             for (int i : piles) {
//                 // Use (i + mid - 1) / mid to get the ceiling of i / mid
//                 time += (i + mid - 1) / mid;
                
//                 // If the time exceeds the allowed hours `h`, break early
//                 if (time > h) {
//                     break;
//                 }
//             }
            
//             // Adjust the search range based on the total hours calculated
//             if (time > h) {
//                 // If total time exceeds `h`, increase the minimum speed
//                 min = mid + 1;
//             } else {
//                 // Otherwise, decrease the maximum speed
//                 max = mid;
//             }
//         }
        
//         //  the minimum speed that allows eating all bananas in `h` hours
//         return max;
//     }
// }

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       long sum = 0;
       int maxN = Integer.MIN_VALUE;
        for (int n : piles) {
            maxN = Math.max(maxN,n);
            sum += n;
        }
        //maxN is the general worst case where koko needs to eat at the speed of highest pile bananas per hour 

        //the min time = number of piles. for that the min speed is 1 pile per hour
        int min = (int) Math.ceilDiv(sum, h); //if all pile have avg no. of bananas then, eating 1 pile per hour implies eating this avg no. of bananas per hour
        int a = (int) Math.ceilDiv(sum, h - piles.length + 1); //when you have a lot of hours so you don't really need to eat the largest pile in  a single shot, so you can suffice even with a smaller value
        int max = Math.min(a,maxN); //take whichever value is lesser. i.e., if you have few hours or hours same as no. of piles then you need to eat largest pile bananas in 1 single shot, otherwise you can chill and eat lesser bananas per hour too, because the hours are much more than number of piles.
        int mid = 0;
        while (min < max) {
            mid = (max + min)/2;
            int time = 0;
            for (int i : piles) {
                time += (i + mid - 1)/mid;
                if (time > h) {
                    break;
                }
            }
            if (time > h) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return max;
    }
}
