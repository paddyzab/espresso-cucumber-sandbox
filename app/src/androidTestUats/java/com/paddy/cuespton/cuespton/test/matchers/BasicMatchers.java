package com.paddy.cuespton.cuespton.test.matchers;

import com.google.common.collect.Lists;
import org.hamcrest.Matcher;
import org.hamcrest.core.AllOf;

public class BasicMatchers {

    public static <T> Matcher<T> allOf(final Matcher<? extends T> first, final Matcher<? extends T> second) {
        return AllOf.allOf(Lists.newArrayList(first, second));
    }

    public static <T> Matcher<T> allOf(final Matcher<? extends T> first, final Matcher<? extends T> second, final Matcher<? extends T> third) {
        return AllOf.allOf(Lists.newArrayList(first, second, third));
    }

    public static <T> Matcher<T> allOf(final Matcher<? extends T> first,
                                       final Matcher<? extends T> second,
                                       final Matcher<? extends T> third,
                                       final Matcher<? extends T> fourth) {
        return AllOf.allOf(Lists.newArrayList(first, second, third, fourth));
    }

    public static <T> Matcher<T> allOf(final Matcher<? extends T> first,
                                       final Matcher<? extends T> second,
                                       final Matcher<? extends T> third,
                                       final Matcher<? extends T> fourth,
                                       final Matcher<? extends T> fifth) {
        return AllOf.allOf(Lists.newArrayList(first, second, third, fourth, fifth));
    }
}
