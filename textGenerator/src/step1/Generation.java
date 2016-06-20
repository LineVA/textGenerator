package step1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author doyenm
 */
public class Generation {

    public char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
        'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
        'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public double[] frequencies = {8.122, 0.901, 3.345, 3.669, 17.133, 1.066, 0.866,
        0.737, 7.585, 0.545, 0.049, 5.456, 2.968, 7.095, 5.378, 3.021, 1.362,
        6.553, 7.948, 7.244, 6.311, 1.628, 0.114, 0.387, 0.308, 0.136};

    public ArrayList<Double> cumulateFrequencies;

    Random rand = new Random();

    public Generation() {
        this.cumulateFrequencies = generateCumulateFrequencies();
    }

    public ArrayList<Double> generateCumulateFrequencies() {
        double tmp = 0.0;
        ArrayList<Double> cumulates = new ArrayList<>();
        for (int i = 0; i < frequencies.length; i++) {
            cumulates.add(tmp + frequencies[i]);
            tmp += frequencies[i];
        }
        cumulates.set(cumulates.size() - 1, 100.0);
        return cumulates;
    }

    public char findLetterByFrequency(double pos) {
        if (pos <= this.cumulateFrequencies.get(0)) {
            return this.letters[0];
        } else {
            for (int i = 0; i < frequencies.length - 1; i++) {
                if (pos> this.cumulateFrequencies.get(i) && pos<=this.cumulateFrequencies.get(i+1)) {
                    return this.letters[i+1];
                }
            }
            return '&';
        }
    }
    

    public char generateChar() {
        double pos = rand.nextDouble() * 100;
        return findLetterByFrequency(pos);
    }

    public String generate(int length) {
        String word = "";
        for (int i = 0; i < length; i++) {
            word += generateChar();
        }
        return word;
    }
}
