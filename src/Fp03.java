import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fp03 {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("Ali");
        l.add("Ali");
        l.add("Mark");
        l.add("Amanda");
        l.add("Christopher");
        l.add("Jackson");
        l.add("Mariano");
        l.add("Alberto");
        l.add("Tucker");
        l.add("Benjamin");
        System.out.println(l);

        printInUppercase01(l);
        System.out.println();
        //printInUppercase02(l);
        printElementsSortedByLength(l);
        System.out.println();
        printElementsReversedSortedByLength(l);
        System.out.println();
        printDistinctSortedByLastChar(l);
        System.out.println();
        printSortedByLengthThenSortedByInitial(l);
        System.out.println();
        //removeIfTheLengthIsGreaterThanFive(l);
        //removeIfStartingWithAEndingWithN01(l);
        //removeIfStartingWithAEndingWithN02(l);
        //removeIfLengthBetween8and10orEndsWithhO(l);
        System.out.println(checkLengthToBeLessThenTwelwe(l));
        System.out.println(checkNotToStartWithX(l));
        System.out.println(checkingAtLeastOneElementEndingEithR(l));

    }


    //1) Create a method to print all list elements in uppercase
    //1st Way:
    public static void printInUppercase01(List<String> list) {

        list.stream().map(String::toUpperCase).forEach(UtilsNt::printTheSameLineWithSpace);
    }
    //2nd Way:
  /*  public static void printInUppercase02(List<String> list){

        list.replaceAll(String::toUpperCase);
        System.out.println(list);
    }*/

    //2) Create a method to print the elements after ordering according to their lengths
    public static void printElementsSortedByLength(List<String> list) {

        list.stream().sorted(Comparator.comparing(String::length)).forEach(UtilsNt::printTheSameLineWithSpace);

    }

    //3) Create a method to print the elements after ordering according to their lengths (In reverse order)
    public static void printElementsReversedSortedByLength(List<String> list) {

        list.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(UtilsNt::printTheSameLineWithSpace);

    }

    //4) Create a method to sort the distinct elements by using their last characters
    public static void printDistinctSortedByLastChar(List<String> list) {

        list.stream().distinct().sorted(Comparator.comparing(UtilsNt::getLastChar)).forEach(UtilsNt::printTheSameLineWithSpace);

    }

    //5) Create a method to sort the elements according to their lengths then according to their first character

    public static void printSortedByLengthThenSortedByInitial(List<String> list) {

        list.
                stream().
                sorted(Comparator.
                        comparing(String::length).
                        thenComparing(t -> t.charAt(0))).
                forEach(UtilsNt::printTheSameLineWithSpace);

    }

    //6) Remove the elements if the length of the element is greater than 5

   /* public static void removeIfTheLengthIsGreaterThanFive(List<String> list){

        list.removeIf(t->t.length()>5);
        System.out.println(list);
    }*/

    //7) Remove the elements if the element is starting with ‘A’, ‘a’ or ending with ‘N’, ‘n’

    //1st Way:
   /* public static void removeIfStartingWithAEndingWithN01(List<String> list){

        list.removeIf(t->t.charAt(0)=='A'|| t.charAt(0)=='a'||t.charAt(t.length()-1)=='N'||t.charAt(t.length()-1)=='n');
        System.out.println(list);

    }*/

   /* //2nd Way:
    public static void removeIfStartingWithAEndingWithN02(List<String> list){

      list.removeIf(t->t.startsWith("A")||t.startsWith("a")||t.endsWith("N")||t.endsWith("n"));
        System.out.println(list);

    }*/

    /*//8) Remove the elements if the length is between 8 and 10 or ending with 'o'
    public static void removeIfLengthBetween8and10orEndsWithhO(List<String> list) {

        Predicate<String> checkCondition = t -> (t.length() > 7 && t.length() < 11) || t.endsWith("o");

        list.removeIf(t -> checkCondition.test(t));
        System.out.println(list);
    }*/
    //9) Create a method to check if the lengths of all elements are less than 12
    public static boolean checkLengthToBeLessThenTwelwe(List<String>list){
        return list.stream().allMatch(t->t.length()<12);
    }
    //10) Create a method to check if the initial of any element is not ‘X’
    public static boolean checkNotToStartWithX(List<String>list){
        return list.stream().noneMatch(t->t.startsWith("X"));
    }
    //11) Create a method to check if at least one of the elements ending with “r”
    public static boolean checkingAtLeastOneElementEndingEithR(List<String>list){
        return list.stream().anyMatch(t->t.endsWith("r"));
    }
}