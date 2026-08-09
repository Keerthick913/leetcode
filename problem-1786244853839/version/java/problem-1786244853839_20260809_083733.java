// Last updated: 09/08/2026, 08:37:33
1class Solution {
2    public double minPrice(int[] prices, int[] discounts) {
3        Arrays.sort(prices);
4        Arrays.sort(discounts);
5        double total = 0.0;
6        int n = prices.length;
7        int m = discounts.length;
8        for(int i = 0; i < n; i++){
9            int price  = prices[n - 1-i];
10            if(i < m){
11                int discount = discounts[m - 1 - i];
12                total += price * (100.0 - discount) / 100.0;
13            }
14            else{
15                total += price;
16            }
17        }
18        return total;
19    }
20}