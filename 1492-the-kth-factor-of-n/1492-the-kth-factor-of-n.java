import java.util.*;
class Solution {
    public int kthFactor(int n, int k) {
        for (int factor = 1 ; factor <= n ; factor++) {
            if ( n % factor == 0) {
                k--;
                if (k == 0) return factor;
            }
        }
        return -1;
        
    }
}