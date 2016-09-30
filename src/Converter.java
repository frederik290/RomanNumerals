/**
 * A verbose solution for converting an integer to a Roman Numeral.
 * Note for reader: coded after midnight ;)
 */
public class Converter {
    private int ones, tens, hundreds, thousands;

    // Arrays
    private String[] onesArray;
    private String[] tensArray;
    private String[] hundredsArray;

    public Converter(){
        onesArray = new String[9];
        tensArray = new String[9];
        hundredsArray = new String[9];

        onesArray[0] = "I";
        onesArray[1]= "II";
        onesArray[2] = "III";
        onesArray[3]= "IV";
        onesArray[4]="V";
        onesArray[5]="VI";
        onesArray[6]="VII";
        onesArray[7]="VIII";
        onesArray[8]="IX";

        tensArray[0] = "X";
        tensArray[1] = "XX";
        tensArray[2] = "XXX";
        tensArray[3] = "XL";
        tensArray[4] = "L";
        tensArray[5] = "LX";
        tensArray[6] = "LXX";
        tensArray[7] = "LXXX";
        tensArray[8] = "XC";

        hundredsArray[0] = "C";
        hundredsArray[1] = "CC";
        hundredsArray[2] = "CCC";
        hundredsArray[3] = "CD";
        hundredsArray[4] = "D";
        hundredsArray[5] = "DC";
        hundredsArray[6] = "DCC";
        hundredsArray[7] = "DCCC";
        hundredsArray[8] = "CM";
    }

    public String convert(int number){
        String theThousands, theHundreds, theTens, theOnes;

        setConstants(number);

        theThousands = makeRomanThousands(thousands);
        theHundreds = makeRomanBelowAThousand(hundredsArray, hundreds);
        theTens = makeRomanBelowAThousand(tensArray, tens);
        theOnes = makeRomanBelowAThousand(onesArray,ones);

        return theThousands + theHundreds + theTens + theOnes;
    }

    private String makeRomanBelowAThousand(String[] romans, int amount) {
        switch (amount){
            case 1:
                return romans[0];
            case 2:
                return romans[1];
            case 3:
                return romans[2];
            case 4:
                return romans[3];
            case 5:
                return romans[4];
            case 6:
                return romans[5];
            case 7:
                return romans[6];
            case 8:
                return romans[7];
            case 9:
                return romans[8];
            default: return "";


        }
    }

    private String makeRomanThousands(int thousands){
        String result = "";
        for(int i = 0; i < thousands; i++){
            result += "M";
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
