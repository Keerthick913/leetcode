// Last updated: 14/07/2026, 16:15:20
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();
        for(int num : nums1)
        {
            set.add(num);
        }
        for(int num : nums2)
        {
            if(set.contains(num))
            {
                resSet.add(num);
            }
        }
        int[] res = new int[resSet.size()];
        int i = 0;
        for(int num : resSet)
        {
            res[i ++] = num;
        }
        return res;
    }
}