/**
 * Very verbose solution for converting an integer to a Roman Numeral.
 * Shorter version on the way...
 */
public class Converter {
    private int ones, tens, hundreds, thousands;

    // A Roman number can be made of the following components:
    private String one, two, three, four, five, six, seven, eight, nine;
    private String ten, twenty, thirty, fourty, fifty, sixty, seventy, eighty, ninety;
    private String h1, h2, h3, h4, h5, h6, h7, h8, h9, t1;

    public Converter(){
        one = "I";
        two = "II";
        three = "III";
        four = "IV";
        five = "V";
        six = "VI";
        seven = "VII";
        eight = "VIII";
        nine = "IX";
        ten = "X";
        twenty = "XX";
        thirty = "XXX";
        fourty = "XL";
        fifty = "L";
        sixty = "LX";
        seventy = "LXX";
        eighty =  "LXXX";
        ninety = "XC";
        h1 = "C";
        h2 = "CC";
        h3 = "CCC";
        h4 = "CD";
        h5 = "D";
        h6 = "DC";
        h7 = "DCC";
        h8 = "DCCC";
        h9 = "CM";
        t1 = "M";
    }

    public String convert(int number){
        String theThousands, theHundreds, theTens, theOnes;

        setConstants(number);

        theThousands = makeRomanThousands(thousands);
        theHundreds = makeRomanHundreds(hundreds);
        theTens = makeRomanTens(tens);
        theOnes = makeRomanOnes(ones);

        return theThousands + theHundreds + theTens + theOnes;
    }

    private String makeRomanOnes(int ones) {
        switch (ones){
            case 1:
                return one;
            case 2:
                return two;
            case 3:
                return three;
            case 4:
                return four;
            case 5:
                return five;
            case 6:
                return six;
            case 7:
                return seven;
            case 8:
                return eight;
            case 9:
                return nine;
            default: return "";


        }
    }

    private String makeRomanTens(int tens) {
        switch (tens){
            case 1:
                return ten;
            case 2:
                return twenty;
            case 3:
                return thirty;
            case 4:
                return fourty;
            case 5:
                return fifty;
            case 6:
                return sixty;
            case 7:
                return seventy;
            case 8:
                return eighty;
            case 9:
                return ninety;
            default: return "";


        }
    }

    private String makeRomanHundreds(int hundreds){
        switch (hundreds){
            case 1:
                return h1;
            case 2:
                return h2;
            case 3:
                return h3;
            case 4:
                return h4;
            case 5:
                return h5;
            case 6:
                return h6;
            case 7:
                return h7;
            case 8:
                return h8;
            case 9:
                return h9;
            default: return "";


        }
    }

    private String makeRomanThousands(int thousands){
        String result = "";
        for(int i = 0; i < thousands; i++){
            result += t1;
        }
        return result;
    }

    private void setConstants(int number){
        int rest;
        //breaking into thousands
        thousands = breakNumber(number,1000);
        rest = number - thousands * 1000;
        //breaking into hundreds
        hundreds = breakNumber(rest,100);
        rest = rest - hundreds * 100;
        //breaking into tens
        tens = breakNumber(rest,10);
        rest = rest - tens * 10;
        //breaking into ones
        ones = breakNumber(rest,1);
        rest = rest - ones * 1;

        /* System.out.println(
                "thousands: " + thousands +
                " hundreds: " + hundreds +
                " tens: " + tens +
                " ones: " + ones); */
    }

    private int breakNumber(int number, int factor){
        int count = 0;
        while (number >= factor){
            count++;
            number -= factor;
        }
        return count;
    }

    public static void main(String[] args) {
        Converter converter = new Converter();
        String result = converter.convert(Integer.parseInt(args[0]));
        System.out.println("The number: " + args[0] + " is: " + result + " in Roman Numerals");
    }
}
