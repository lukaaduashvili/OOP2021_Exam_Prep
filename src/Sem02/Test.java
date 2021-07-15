package Sem02;

public class Test {
    public static void main(String[] args){

        for (String arg: args){
            try {
                int number = Integer.parseInt(arg);
                RomanNumeral r = new RomanNumeral(number);
                System.out.println(r.toInt());
                System.out.println(r.toString());
            }catch (NumberFormatException ex){
                RomanNumeral r = new RomanNumeral(arg);
                System.out.println(r.toInt());
                System.out.println(r.toString());
            }
        }

    }
}
