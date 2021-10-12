package ru.stqa.ptf.sandBox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTest {

    @Test
    public void testPrime(){
        Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
    }

    @Test(enabled = false)
    public void testPrimeLong(){
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrime(n));
    }

    @Test
    public void testNonPrime(){
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE - 2));
    }
}
