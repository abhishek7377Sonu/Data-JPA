package com.nt;

interface MyInterface {  
    int myMethod(int x);  
}  
  
public class LambdaExample {  
    public static void main(String[] args) {  
        MyInterface myInterface = (x) -> {    return x * x; }; // Return the square of x     
        int result = myInterface.myMethod(5);  
        System.out.println("The square of 5 is " + result); // Output: The square of 5 is 25  
    }  
}  