package com.yym.lambda._04methodReference;

@FunctionalInterface
public interface PersonBuilder {
    Person builder(String name, String age);
}
