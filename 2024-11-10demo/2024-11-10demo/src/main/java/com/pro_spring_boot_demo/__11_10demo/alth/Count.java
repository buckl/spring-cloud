package com.pro_spring_boot_demo.__11_10demo.alth;

public class Count {
    public int countKConstraintSubstrings(String S, int k) {
        char[] s = S.toCharArray();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[2];
        for (int i = 0; i < s.length; i++) {
            cnt[s[i] & 1]++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s[left] & 1]--;
                left++;
            }
            ans += i - left + 1;
        }
        return ans;
    }
}
