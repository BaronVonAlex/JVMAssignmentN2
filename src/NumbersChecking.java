import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class NumbersChecking {

    public static int[] readIntegersFromFile(String fileName) throws IOException, NumbersException {
        int[] integers = new int[10];
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\CodingApps\\JVM Studies\\JVMAssignmentN2\\src\\numbers.txt")));
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            try {
                int num = Integer.parseInt(line.trim());
                if (num < 0) {
                    throw new NumbersException("Invalid number: " + num);
                }
                integers[i] = num;
                i++;
            } catch (NumberFormatException e) {
                throw new NumbersException("Invalid format: " + line);
            }
        }
        reader.close();
        int[] validIntegers = Arrays.copyOf(integers, i);
        System.out.println("Integers from file: " + Arrays.toString(validIntegers));
        return validIntegers;
    }

    public static int sumIntArray(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        try {
            int[] integers = readIntegersFromFile("numbers.txt");
            int sum = sumIntArray(integers);
            System.out.println("Sum of integers from Array: " + sum);
            if (sum == 0) {
                throw new ArithmeticException("Division by zero");
            }
            int result = 100 / sum;
            System.out.println("Result of division: " + result);
        } catch (IOException e) {
            System.out.println("An error happened while reading the file: " + e.getMessage());
        } catch (NumbersException e) {
            System.out.println("Invalid number: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("An arithmetic error happened: " + e.getMessage());
        }
    }
}
