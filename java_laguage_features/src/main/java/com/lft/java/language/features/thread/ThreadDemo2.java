package com.lft.java.language.features.thread;

import java.math.BigDecimal;

public class ThreadDemo2 {
    private static final BigDecimal FOUR = BigDecimal.valueOf(4);
    // rounding mode to use during pi computation
    private static final int roundingMode = BigDecimal.ROUND_HALF_EVEN;
    private static BigDecimal result;

    public static void main(String[] args)
    {
        Runnable r = () ->
        {
            result = computePi(50000);
        };
        Thread t = new Thread(r);
        t.start();
        try
        {
            t.join();
        }
        catch (InterruptedException ie)
        {
            System.out.println(1);
// Should never arrive here because interrupt() is never
// called.
        }
        System.out.println(result);
    }
    public static BigDecimal computePi(int digits)
    {
        int scale = digits + 5;
        BigDecimal arctan1_5 = arcTangent(5, scale);
        BigDecimal arctan1_239 = arcTangent(239, scale);
        BigDecimal pi = arctan1_5.multiply(FOUR).
                subtract(arctan1_239).multiply(FOUR);
        return pi.setScale(digits, BigDecimal.ROUND_HALF_UP);
    }


    public static BigDecimal arcTangent(int inverseX, int scale)
    {
        BigDecimal result, numer, term;
        BigDecimal invX = BigDecimal.valueOf(inverseX);
        BigDecimal invX2 = BigDecimal.valueOf(inverseX * inverseX);
        numer = BigDecimal.ONE.divide(invX, scale, roundingMode);
        result = numer;
        int i = 1;
        do
        {
            numer = numer.divide(invX2, scale, roundingMode);
            int denom = 2 * i + 1;
            term = numer.divide(BigDecimal.valueOf(denom), scale,
                    roundingMode);
            if ((i % 2) != 0)
                result = result.subtract(term);
            else
                result = result.add(term);
            i++;
        }
        while (term.compareTo(BigDecimal.ZERO) != 0);
        return result;
    }
}
