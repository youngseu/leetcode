package Niuke.Square;

//数值的整数次方
//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
public class IntegerPower {
    public double Power(double base, int exponent) {
        double res = 1, cur = base;
        int exp;
        if (exponent > 0) exp = exponent;
        else if (exponent < 0) exp = -exponent;
        else return 1;
        while (exp != 0) {
            if ((exp & 1) == 1) res *= cur;
            cur *= cur;
            exp >>= 1;
        }
        return exponent >= 0 ? res : (1 / res);
    }
}
