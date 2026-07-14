// Last updated: 14/07/2026, 16:12:34
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int totalWeight = 0;
        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
            totalWeight += w;
        }
        int left = maxWeight;
        int right = totalWeight;
        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                ans = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    private boolean canShip(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currentLoad = 0;
        
        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                daysNeeded++;     
                currentLoad = 0;
            }
            currentLoad += weight;
        }      
        return daysNeeded <= days;
    }
}