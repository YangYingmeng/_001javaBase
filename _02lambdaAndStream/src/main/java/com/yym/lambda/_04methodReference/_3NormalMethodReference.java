package com.yym.lambda._04methodReference;

public class _3NormalMethodReference {

    static void print(String str, Print print) {
        print.print(str + " +");
    }
    public static void main(String[] args) {
        print("normal", System.out::println);
    }
}
