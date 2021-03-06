/* Minimize Max Distance to Gas Station
On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], 
where N = stations.length.

Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.

Return the smallest possible value of D.

Example:

Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
Output: 0.500000
Note:

stations.length will be an integer in range [10, 2000].
stations[i] will be an integer in range [0, 10^8].
K will be an integer in range [1, 10^6].
Answers within 10^-6 of the true value will be accepted as correct.

Solution: https://leetcode.com/problems/minimize-max-distance-to-gas-station/solution/
*/

class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double lo = 0.0, hi = 1e8;
        while(lo + 1e-6 < hi) {
            double mid = lo + (hi - lo) / 2.0;
            if(possible(mid, stations, K)) {
                hi = mid;
            }else {
                lo = mid;
            }    
        }
        
        return lo;
    }
    
    private boolean possible(double D, int[] stations, int K) {
        int count = 0;
        for(int i = 0; i < stations.length - 1; i++) {
            count += (int) ((stations[i + 1] - stations[i]) / D);
        }
        
        return count <= K;
    }
}
