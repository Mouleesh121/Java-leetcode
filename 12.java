class Solution {
    public int reverse(int x) {
        int INT_MAX = 2147483647, INT_MIN = -2147483648;
        int reversed_x = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (reversed_x > INT_MAX / 10 || (reversed_x == INT_MAX / 10 && pop > 7)) return 0;
            if (reversed_x < INT_MIN / 10 || (reversed_x == INT_MIN / 10 && pop < -8)) return 0;
            reversed_x = reversed_x * 10 + pop;
        }
        return reversed_x;
    }
}
