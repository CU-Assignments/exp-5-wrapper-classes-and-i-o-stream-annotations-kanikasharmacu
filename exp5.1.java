import java.util.List;
import java.util.ArrayList;

public class AutoboxingUnboxingExample {

    // Method to calculate the sum of a list of integers
    public static int sumOfIntegers(List<Integer> integers) {
        int sum = 0;
        // Using unboxing to convert Integer to int and calculate sum
        for (Integer num : integers) {
            sum += num;  // This is unboxing: Integer -> int
        }
        return sum;
    }

    // Method to parse a list of strings into their respective Integer objects using autoboxing
    public static List<Integer> parseStringsToIntegers(List<String> stringList) {
        List<Integer> integerList = new ArrayList<>();
        for (String str : stringList) {
            // Using autoboxing: converting the result of Integer.parseInt to an Integer object
            integerList.add(Integer.parseInt(str)); // Autoboxing occurs here
        }
        return integerList;
    }

    public static void main(String[] args) {
        // Example: Parsing a list of strings into Integer objects
        List<String> stringList = new ArrayList<>();
        stringList.add("10");
        stringList.add("20");
        stringList.add("30");
        stringList.add("40");

        // Parse strings to integers
        List<Integer> integerList = parseStringsToIntegers(stringList);

        // Calculate the sum using autoboxing and unboxing
        int sum = sumOfIntegers(integerList);

        // Output the result
        System.out.println("The sum of the integers is: " + sum);
    }
}
