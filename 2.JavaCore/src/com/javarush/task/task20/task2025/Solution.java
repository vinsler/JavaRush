package com.javarush.task.task20.task2025;

import java.math.BigInteger;
import java.net.Inet4Address;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {
    public static ArrayList <Long> armstrngNum = new ArrayList<Long>();

    static {
        armstrngNum.add(1L);
        armstrngNum.add(2L);
        armstrngNum.add(3L);
        armstrngNum.add(4L);
        armstrngNum.add(5L);
        armstrngNum.add(6L);
        armstrngNum.add(7L);
        armstrngNum.add(8L);
        armstrngNum.add(9L);
        armstrngNum.add(153L);

        armstrngNum.add(370L);
        armstrngNum.add(371L);
        armstrngNum.add(407L);
        armstrngNum.add(1634L);
        armstrngNum.add(8208L);
        armstrngNum.add(9474L);
        armstrngNum.add(54748L);
        armstrngNum.add(92727L);
        armstrngNum.add(93084L);
        armstrngNum.add(548834L);

        armstrngNum.add(1741725L);
        armstrngNum.add(4210818L);
        armstrngNum.add(9800817L);
        armstrngNum.add(9926315L);
        armstrngNum.add(24678050L);
        armstrngNum.add(24678051L);
        armstrngNum.add(88593477L);
        armstrngNum.add(146511208L);
        armstrngNum.add(472335975L);
        armstrngNum.add(534494836L);

        armstrngNum.add(912985153L);
        armstrngNum.add(4679307774L);
        armstrngNum.add(32164049650L);
        armstrngNum.add(32164049651L);
        armstrngNum.add(40028394225L);
        armstrngNum.add(42678290603L);
        armstrngNum.add(44708635679L);
        armstrngNum.add(49388550606L);
        armstrngNum.add(82693916578L);
        armstrngNum.add(94204591914L);

        armstrngNum.add(28116440335967L);
        armstrngNum.add(4338281769391370L);
        armstrngNum.add(4338281769391371L);
        armstrngNum.add(21897142587612075L);
        armstrngNum.add(35641594208964132L);
        armstrngNum.add(35875699062250035L);
    }

    public static long[] getNumbers(long N) {
        long[] tresult = new long[46];
        int cx = 0;
        LocalTime tm = LocalTime.now();

        for (Long Ax : armstrngNum) {
            if (N > Ax) {
                tresult[cx] = Ax;
                cx++;
            } else {
                break;
            }
        }

        long [] result = new long[cx];
        cx = 0;

        for (cx = 0; cx < result.length; cx++) {
            result[cx] = tresult[cx];
        }

        /*for (int i = 1; i < N; i++){
            if (armstrngNum.contains(i)) {
                result[cx] = i;
                cx++;
                System.out.println(i);
            }
        }*/

        System.out.println(LocalTime.now().minusSeconds(tm.toSecondOfDay()));
        return result;
    }

    public static Long getTrue(long number, int digits){
        long result = -1;
        switch (digits) {
            case 1 : {
                result = number;
                break;
            }
            case 2 : {
                result = Math.round(Math.pow(number % 10, 2) +
                        Math.pow(number / 10, 2)
                );
                break;
            }
            case 3 : { // 370
                result = Math.round(
                        Math.pow(number % 10, 3) +
                                Math.pow((number / 10) % 10, 3) +
                                Math.pow((number / 100) , 3)
                );
                break;
            }
            case 4: { // 123 4
                result = Math.round(
                        Math.pow(number % 10, 4) +
                                Math.pow((number / 10) % 10, 4) +
                                Math.pow((number / 100) % 10, 4) +
                                Math.pow((number / 1000) , 4)
                );
                break;
            }
            case 5: { // 1234 5
                result = Math.round(
                        Math.pow(number % 10, 5) +
                                Math.pow((number / 10) % 10, 5) +
                                Math.pow((number / 100) % 10, 5) +
                                Math.pow((number / 1000) % 10, 5) +
                                Math.pow((number / 10000) , 5)
                );
                break;
            }
            case  6: {
                result = Math.round(
                        Math.pow(number % 10, 6) +
                                Math.pow((number / 10) % 10, 6) +
                                Math.pow((number / 100) % 10, 6) +
                                Math.pow((number / 1000) % 10, 6) +
                                Math.pow((number / 10000) % 10, 6) +
                                Math.pow((number / 100000) , 6)
                );
                break;
            }
            case  7: {
                result = Math.round(
                        Math.pow(number % 10, 7) +
                                Math.pow((number / 10) % 10, 7) +
                                Math.pow((number / 100) % 10, 7) +
                                Math.pow((number / 1000) % 10, 7) +
                                Math.pow((number / 10000) % 10, 7) +
                                Math.pow((number / 100000) % 10, 7) +
                                Math.pow((number / 1000000) , 7)
                );
                break;
            }
            case  8: {
                result = Math.round(
                        Math.pow(number % 10, 8) +
                                Math.pow((number / 10) % 10, 8) +
                                Math.pow((number / 100) % 10, 8) +
                                Math.pow((number / 1000) % 10, 8) +
                                Math.pow((number / 10000) % 10, 8) +
                                Math.pow((number / 100000) % 10, 8) +
                                Math.pow((number / 1000000) % 10, 8) +
                                Math.pow((number / 10000000) , 8)
                );
                break;
            }
        }
        return result;
    }




//9 223 372 036 854 775 807
    public static void main(String[] args) {

        long [] l = getNumbers(32164049652L);

        for (long j : l) {
            System.out.println(j);
        }

    }
}

