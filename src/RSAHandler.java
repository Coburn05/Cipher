package src;

import java.io.*;
import java.math.*;
import java.util.*;

public class RSAHandler {
    // does ALL RSA related things
    // will break apart later
    private static long p;
    private static long q;
    private static long n; // p * q
    private static long phi; // (p-1)(q-1)
    private static long e; // 1<e<phi

    private static double gcd(double a, double h) {
        double tmp;
        while(true) {
            tmp = a % h;
            if(tmp == 0)
                return h;
            a = h;
            h = tmp;
        }
    }

    private static String encryptRSA() {
        return "-1";
    }
}
