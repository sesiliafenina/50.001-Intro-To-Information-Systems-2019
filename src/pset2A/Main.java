package pset2A;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String[] in = {
                "hello"
                ,
                "good night"
                ,
                "good morning"
        };
        String ret =
                TestException.tstException
                        (
                                2
                                , in);
        System.
                out
                .println(ret);
        ret =
                TestException.tstException
                        (
                                -
                                        1
                                , in);
        System.
                out
                .println(ret);
    }

}
