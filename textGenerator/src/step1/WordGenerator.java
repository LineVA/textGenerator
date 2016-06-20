package step1;

import java.util.Random;

/**
 *
 * @author doyenm
 */
public class WordGenerator {

   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Generation gen = new Generation();
        System.out.println(gen.generate(n));
    }

}
