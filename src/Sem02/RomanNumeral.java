package Sem02;

import java.util.Locale;

public class RomanNumeral {
    private final static int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final static String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    int arabicNum;

    public RomanNumeral(int arabicNum) {
        this.arabicNum = arabicNum;
    }

    public RomanNumeral(String romanNum) {
        romanNum = romanNum.toUpperCase(Locale.ROOT);
        int i = 0;
        int res = 0;
        while(i < romanNum.length()-1) {
            char elem = romanNum.charAt(i);
            char nextElem = romanNum.charAt(i+1);
            int currVal = letterToNum(elem);
            int nextVal = letterToNum(nextElem);
            if(nextVal > currVal) {
                res-=currVal;
            } else {
                res+=currVal;
            }
            i++;
        }
        char elem = romanNum.charAt(romanNum.length()-1);
        int currVal = letterToNum(elem);
        res += currVal;

        this.arabicNum = res;
    }

    int letterToNum(char letter) {
        switch (letter) {
            case('I'): return 1;
            case('V'): return 5;
            case('X'): return 10;
            case('L'): return 50;
            case('C'): return 100;
            case('D'): return 500;
            case('M'): return 1000;
            default:
                throw new NumberFormatException("Incorrect Symbol");
        }
    }

    @Override
    public String toString() {
        String res = "";
        int currValue = this.arabicNum;
        for(int i = 0; i < numbers.length; i++) {
            while(numbers[i] < currValue) {
                res+=letters[i];
                currValue-=numbers[i];
            }
        }
        return res;
    }

    public int toInt() {
        return this.arabicNum;
    }

}
