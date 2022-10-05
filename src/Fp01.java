/*
1)Lambda is Functional Programming, we started to use Lambda in Java 8
2)In Functional Programming we focus on 'What to do?' but in Structured Programming we focus on 'How to do?
3)Functional Programming can be used just with Arrays and Collections.
4)By using 'entrySet()' method, you can convert Map to Set, then you can use Functional Programming in Maps as well.
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class Fp01 {
    public static void main(String[] args) {

        List<Integer> l = new ArrayList<>();
        l.add(8);
        l.add(9);
        l.add(131);
        l.add(10);
        l.add(9);
        l.add(10);
        l.add(2);
        l.add(8);

        System.out.println(l);
        printElementsStructured(l);
        System.out.println();
        printElementsFunctional(l);
        System.out.println();
        printEvenElementsStructured(l);
        System.out.println();
        printEvenElementsFunctional(l);
        System.out.println();
        printSquareOfOddElements(l);
        System.out.println();
        printCubeOfDistinctOddElements(l);
        System.out.println();
        sumOfSquaresOfDistinctEvenElements(l);
        productOfCubesOfDistinctEvenElements(l);
        getMaxElement01(l);
        getMinGreaterThanSevenAndEven01(l);
        getMinGreaterThanSevenAndEven02(l);
        getMinGreaterThanSevenAndEven03(l);
        halfOfElementsDistinctInReverse(l);
        getMinElement(l);
        getMinElement2(l);
    }
    //1)Create a method to print the list elements on the console in the same line with a space
    //  between two consecutive elements.(Structured)
    public static void printElementsStructured(List<Integer> list){
        for(Integer w : list){
            System.out.print(w + " ");
        }
    }
    //1)Create a method to print the list elements on the console in the same line with a space
    //  between two consecutive elements.(Functional)
    public static void printElementsFunctional(List<Integer> list){
        list.stream().forEach(t-> System.out.print(t+" "));
    }
    //2)Create a method to print the even list elements on the console in the same line with a space
    //  between two consecutive elements.(Structured)
    public static void printEvenElementsStructured(List<Integer> list){
        for(Integer w: list){
            if(w%2==0){
                System.out.print(w+" ");
            }
        }
    }
        //2)Create a method to print the even list elements on the console in the same line with a space
        //  between two consecutive elements.(Functional)
    public static void printEvenElementsFunctional(List<Integer> list){
        list.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" "));
    }
    //3)Create a method to print the square of odd list elements on the console in the same line with a
    //  space between two consecutive elements.(Functional)
    public static void printSquareOfOddElements(List<Integer> list){
        list.stream().filter(t->t%2!=0).map(t->t*t).forEach(t-> System.out.print(t+" "));
    }
    //4)Create a method to print the cube of distinct odd list elements on the console in the same line
    //  with a space between two consecutive elements.
    public static void  printCubeOfDistinctOddElements(List<Integer> list){
        list.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t-> System.out.print(t+" "));
    }
    //5)Create a method to calculate the sum of the squares of distinct even elements
    public static void sumOfSquaresOfDistinctEvenElements(List<Integer> list){
        Integer sum = list.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0,(t,u)->t+u);
        System.out.println(sum);
    }
        //6)Create a method to calculate the product of the cubes of distinct even elements

    public static void productOfCubesOfDistinctEvenElements(List<Integer> list){
        Integer product = list.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1,(t,u)->t*u);
        System.out.println(product);
    }
        //7)Create a method to find the maximum value from the list element
    //1st Way:
    public static void getMaxElement01(List<Integer> list){
        Integer max =list.stream().distinct().reduce(Integer.MIN_VALUE,(t,u)->t>u ? t : u);
        System.out.println(max);
    }
    //2nd Way:
    public static void getMaxElement02(List<Integer> list){
        Integer max = list.stream().distinct().sorted().reduce(Integer.MIN_VALUE,(t,u)->u);
        System.out.println(max);
    }
        //Homework
        //8)Create a method to find the minimum value from the list elements(In 2 ways)
    public static void getMinElement(List<Integer> list){
        Integer min= list.stream().distinct().reduce(Integer.MAX_VALUE,(t,u)->t<u?t:u);
        System.out.println("homework is "+min);
    }
    public static void getMinElement2(List<Integer> list){
        Integer min2=list.stream().distinct().sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE,(t,u)->u);
        System.out.println("homework min2 "+min2);
    }
    //9)Create a method to find the minimum value which is greater than 7 and even from the list
    //1st Way:
    public static void getMinGreaterThanSevenAndEven01(List<Integer> list){
        Integer min = list.stream().distinct().filter(t->t>7).filter(t->t%2==0).reduce(Integer.MAX_VALUE,(t,u)->t<u ? t : u);
        System.out.println(min);
    }
    //2nd Way:
    public static void getMinGreaterThanSevenAndEven02(List<Integer> list){
        Integer min = list.
                stream().
                distinct().filter(t->t%2==0).
                filter(t->t>7).
                sorted(Comparator.reverseOrder()).
                reduce(Integer.MAX_VALUE,(t, u)->u);
        System.out.println(min);
    }
    //3rd Way:
    public static void getMinGreaterThanSevenAndEven03(List<Integer> list){
        Integer min = list.
                stream().
                filter(t->t%2==0).
                filter(t->t>7).
                sorted().
                findFirst().
                get();
        System.out.println(min);
    }
        //10)Create a method to find the half of the elements which are distinct and greater than 5 in reverse order in the list.
    public static void halfOfElementsDistinctInReverse(List<Integer> list){
        List<Double> result = list.
                stream().
                distinct().
                filter(t->t>5).
                map(t->t/2.0).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
        System.out.println(result);
    }
}