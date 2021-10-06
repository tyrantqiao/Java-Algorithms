package com.tyrantqiao.algorithms.interview;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HuaWeiInterview {
    // ferg(3,10)a13fdsf3(3,4)f2r3rfasf(5,10)
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputString = in.next();
        if (null == inputString || "".equals(inputString)) {
            errorStr();
            return;
        }
        String inputK = in.next();
        int inputKInt = Integer.parseInt(inputK);

        if (inputString.length() == 1) {
            if (inputKInt > 1) {
                errorStr();
                return;
            } else {
                System.out.println("1");
            }
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        char[] chars = inputString.toCharArray();
        int begin = 0, fast = 1;
        while (fast < inputString.length() - 1) {
            char beginChar = chars[begin];
            char fastChar = chars[fast];
            int eachCount = 1;
            while (fast < inputString.length() - 1 && beginChar == fastChar) {
                begin++;
                fast++;
                beginChar = chars[begin];
                fastChar = chars[fast];
                eachCount++;
            }
            int existCharCount = charCountMap.getOrDefault(beginChar, Integer.MIN_VALUE);
            if (eachCount > existCharCount) {
                charCountMap.put(beginChar, eachCount);
            }
            if (fast < inputString.length() - 1) {
                begin++;
                fast++;
            }
        }

        if (chars[begin] != chars[fast]) {
            int eachCount = 1;
            int existCharCount = charCountMap.getOrDefault(chars[fast], Integer.MIN_VALUE);
            if (eachCount > existCharCount) {
                charCountMap.put(chars[fast], eachCount);
            }
        }

        if (inputKInt > charCountMap.size()) {
            errorStr();
            return;
        }

        List<Character> sortedCharList = charCountMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(charCountMap.getOrDefault(sortedCharList.get(inputKInt - 1), -1));
    }

    private static void errorStr() {
        System.out.println("-1");
    }

    private static void findMaxLocation(String inputString) {
        if (inputString == null || "".equals(inputString)) {
            errorMsg();
            return;
        }
        int leftSize = 0, rightSize = 0, midSize = 0;
        char[] chars = inputString.toCharArray();
        for (char eachChar : chars) {
            if (eachChar == '(') {
                leftSize++;
            }
            if (eachChar == ')') {
                rightSize++;
            }
            if (eachChar == ',') {
                midSize++;
            }
        }
        if (leftSize != midSize || rightSize != midSize) {
            errorMsg();
            return;
        }

        Pattern pattern = Pattern.compile("\\s?([\\w]+)\\((\\d+),(\\d+)\\)\\s?");
        Matcher matcher = pattern.matcher(inputString);

        final int[] maxResult = {Integer.MIN_VALUE};
        AtomicReference<String> result = new AtomicReference<>("(0,0)");
        AtomicInteger allStringSize = new AtomicInteger(0);
        while (matcher.find()) {
            allStringSize.addAndGet(matcher.group().length());
            String beginStr = matcher.group(2);
            String endStr = matcher.group(3);

            if ("01".equals(beginStr) && "1".equals(endStr)) {
                errorMsg();
                return;
            }

            if ("1".equals(beginStr) && "01".equals(endStr)) {
                errorMsg();
                return;
            }

            int beginNum = Integer.parseInt(beginStr);
            int endNum = Integer.parseInt(endStr);

            if (beginNum <= 0 || beginNum >= 1000 || endNum <= 0 || endNum >= 1000) {
                errorMsg();
                return;
            }

            if (beginNum == 0 && endNum == 100) {
                errorMsg();
                return;
            }

            int tempResult = beginNum * beginNum + endNum * endNum;
            if (tempResult > maxResult[0]) {
                maxResult[0] = tempResult;
                result.set("(" + beginNum + "," + endNum + ")");
            }
        }
        if (allStringSize.get() != inputString.length()) {
            errorMsg();
            return;
        }

        System.out.println(result);
    }

    private static void errorMsg() {
        System.out.println("(0,0)");
    }
}
