import java.io.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        ScatterSystem system = new ScatterSystem();
        ExtendedSystemCache cache = new ExtendedSystemCache();
        Random generator = new Random();

        int rowsNumber = 10;
        for(int i =0; i<rowsNumber; i++)
        {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            double[] input = new double[randomNum];
            for(int j=0; j< randomNum;j++)
                input[j]= generator.nextDouble() * generator.nextInt();

            Double output = cache.get(input);

            if (output == null) {
                output = system.makeOperation(input);
                cache.put(input, output);
            }

        }

        try
        {

            cache.exportCSV("Files/CSV/first.csv");
            cache.importCSV("Files/CSV/first.csv");

            File file = new File("Files/CSV/second.csv");
            cache.exportCSV(file);
            cache.importCSV(file);

            OutputStream outputStream = new FileOutputStream("Files/CSV/third.csv");
            cache.exportCSV(outputStream);
            InputStream inputStream = new FileInputStream("Files/CSV/third.csv");
            cache.importCSV(inputStream);

            cache.serialize("Files/CSV/firstSerialize.ser");
            cache.deserialize("Files/CSV/firstSerialize.ser");

            File file2 = new File("Files/CSV/firstSave.bin");
            cache.save(file.getPath());

            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
