/**
 * Created by frederik290 on 01/10/16.
 */
public class Data {
    // Arrays
    private String[] onesArray;
    private String[] tensArray;
    private String[] hundredsArray;

    public Data(){
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

    public String[] getOnesArray() {
        return onesArray;
    }

    public String[] getTensArray() {
        return tensArray;
    }

    public String[] getHundredsArray() {
        return hundredsArray;
    }
}
