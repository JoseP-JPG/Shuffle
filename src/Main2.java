import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        String [] baralho_numeros={"Ás","2","3","4","5","6","7","rainha","valete","rei"};
        String [] baralho_naipes={"copas","paus","ouros","espadas"};
        ArrayList<String> baralho=new ArrayList<>();
        int numberShufflers=2;

        Scanner myObj = new Scanner(System.in);
        System.out.println("How many shufflers?");

        numberShufflers = myObj.nextInt();
        if(numberShufflers<2)
            numberShufflers=2;
        if(numberShufflers>20)
            numberShufflers=20;
        System.out.println(numberShufflers+" shufflers!");

        int i=0;
        for (String s:baralho_numeros) {
            for (String st:baralho_naipes) {
                i++;
                baralho.add(s+" de "+st);
            }
        }

        int division=i/numberShufflers;
        int divisionSum=0;
        long start = System.currentTimeMillis();
        for (int j = 1; j <= numberShufflers; j++) {
            int number=division;
            if(j==numberShufflers)
                number=i-divisionSum;
            Shuffler2 shuffle=new Shuffler2(baralho,j,number);
            shuffle.start();
            divisionSum=divisionSum+division;
        }
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("---------------------------------------------------\nElapsed Time in milli seconds: "+(end-start)+"\n---------------------------------------------------");
        System.out.println("");

    }
}