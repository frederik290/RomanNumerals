/**
 * A verbose solution for converting an integer to a Roman Numeral.
 * Note for reader: coded after midnight ;)
 */
public class Converter {
    private Data data;
    private int ones, tens, hundreds, thousands;
    private String[] onesArray;
    private String[] tensArray;
    private String[] hundredsArray;

    public Converter(){
        data = new Data();
        onesArray = data.getOnesArray();
        tensArray = data.getTensArray();
        hundredsArray = data.getHundredsArray();
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
