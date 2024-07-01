public class Solve {
    public int[] findTwoElement(int[] arr, int n) {
        // Expected sum and sum of squares
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSumSq = (long) n * (n + 1) * (2 * n + 1) / 6;
        
        // Actual sum and sum of squares
        long actualSum = 0;
        long actualSumSq = 0;
        
        for (int num : arr) {
            actualSum += num;
            actualSumSq += (long) num * num;
        }
        
        // Equations to solve
        long diff = expectedSum - actualSum; // missing - duplicate
        long sumDiff = (expectedSumSq - actualSumSq) / diff; // missing + duplicate
        
        // Solving for missing and duplicate
        int missing = (int) (sumDiff + diff) / 2;
        int duplicate = (int) sumDiff - missing;
        
        return new int[]{duplicate, missing};
    }
}
