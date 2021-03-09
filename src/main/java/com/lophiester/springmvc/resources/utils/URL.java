package com.lophiester.springmvc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {

    public static List<Integer> decodeToIntList(String s) {
        return Arrays.stream(s.split(",")).map(s1 -> Integer.parseInt(s1)).collect(Collectors.toList());
    }

    public static String decodeParam(String s) {
        try {
            URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "";
    }
}