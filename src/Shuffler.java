import java.util.ArrayList;
import java.util.Random;

public class Shuffler extends Thread{

    int i;
    int number;
    ArrayList<String> baralho;

    public Shuffler(ArrayList<String> baralho, int i, int number){
        this.baralho=baralho;
        this.i=i;
        this.number=number;
    }

    @Override
    public void run() {

        ArrayList<String> baralho_temp = new ArrayList<>();

        synchronized (baralho) {
            System.out.println("Shuffler "+i+" reporting for duty");
            System.out.println("Shuffler "+i+" has obtained the following cards:");
            Random rand = new Random();
            for (int j = 0; j < number; j++) {

                int rand_int = rand.nextInt(baralho.size());
                baralho_temp.add(baralho.get(rand_int));
                System.out.println(baralho.get(rand_int));
                baralho.remove(rand_int);

            }
            System.out.println("---------------------------------------------------");
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (baralho) {
            for (String s:baralho_temp) {
                baralho.add(s);
            }
            System.out.println("Shuffler "+i+" has reinserted the cards");
        }
        System.out.println("Shuffler "+i+" signing out");

    }
}
