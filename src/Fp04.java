import java.util.stream.IntStream;

public class Fp04 {
    public static void main(String[] args) {
        System.out.println(getSumOfIntegersFromSevenAndHundert01());
        System.out.println(getSumOfIntegersFromSevenAndHundert02());
        System.out.println(getMultFromTwoToEleven());
        System.out.println(calculateFactorial(-5));
        System.out.println(calSumOfEvenIntInGivenRange(4,9));
        System.out.println(findSumOfDigitsFromTheIntegersInTheGivenRange(23,32));



    }
    //1)Create a method to find the sum of integers from 7 to 100
    //1.way
    public static int getSumOfIntegersFromSevenAndHundert01(){
       return IntStream.range(7,101).reduce(0,Math::addExact);
    }
    //2.way
    public static int getSumOfIntegersFromSevenAndHundert02(){
        return IntStream.rangeClosed(7,100).reduce(0,Math::addExact);
    }
    //2)Create a method to find the multiplication of the integers from 2(inc) to 11(inc)
    public static int getMultFromTwoToEleven(){
        return IntStream.rangeClosed(2,11).reduce(1,Math::multiplyExact);
    }
    //3)Create a method to calculate the factorial of a given number.(5 factorial = 1*2*3*4*5  ==> 5! = 1*2*3*4*5)
    public static int calculateFactorial(int x){
        if(x>0){
            return IntStream.rangeClosed(1,x).reduce(1,Math::multiplyExact);
        }
        System.out.println("Do not use negative numbers in factorial operations");
        return 0;
    }
//4)Create a method to calculate the sum of even integers between given two integers
    public static int calSumOfEvenIntInGivenRange(int a, int b){
        int x = 0;
        if(a>b){
            x = a;
            a = b;
           b = x;
        }
        return IntStream.rangeClosed(a,b).filter(UtilsNt::checkToBeEven).sum();
    }
    //5)Create a method to calculate the sum of digits of every integers between given two integers
    //  23 and 32 ==> 2+3  +  2+4  +  2+5  +  2+6  +  2+7  +   2+8  +   2+9  +   3+0  +   3+1  +   3+2 ==> 68

    public static int findSumOfDigitsFromTheIntegersInTheGivenRange(int a,int b) {
        int x = 0;
        if (a > b) {
            x = a;
            a = b;
            b = x;
        }
        return IntStream.rangeClosed(a, b).map(UtilsNt::getSumOfDigits).sum();
    }
}
