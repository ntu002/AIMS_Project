package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GarbageCreator {

    public static void main(String args[]) throws IOException {
        String filename = "src/test";
        Path pathToFile = Paths.get(filename);
        byte[] inputBytes = { 0 };

        long startTime, endTime;
        inputBytes = Files.readAllBytes(pathToFile.toAbsolutePath());
        startTime = System.currentTimeMillis();
        String outputString = "";
        for(byte i : inputBytes){
            outputString += (char)i;
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(byte b : inputBytes){
            sb.append((char)b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
