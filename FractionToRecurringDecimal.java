import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0"; // zero top → zero
        StringBuilder res = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) res.append("-");

        long num = Math.abs((long)numerator), den = Math.abs((long)denominator);
        res.append(num / den);
        long rem = num % den;
        if (rem == 0) return res.toString();

        res.append(".");
        Map<Long, Integer> seen = new HashMap<>();

        while (rem != 0) {
            if (seen.containsKey(rem)) {
                res.insert(seen.get(rem), "(");
                res.append(")");
                break;
            }
            seen.put(rem, res.length());
            rem *= 10;
            res.append(rem / den);
            rem %= den;
        }
        return res.toString();
    }
}
