package home_work2309;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        File file = new File("data/yesterday.txt");

       System.out.println("number = " + WordUtils.numberOfWords(file));

       System.out.println("the most popular = " +  WordUtils.mostPopular(file, 8));

    }
}
