package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

class Multiply {
    public static String multiply(String num1, String num2) {
        if (num1 == "0" || num2 == "0") return "0";
        var product = new int[num1.length() + num2.length()];
        for (var i1 = 0; i1 < num1.length(); i1++) {
            var c1 = num1.charAt(i1);
            for (var i2 = 0; i2 < num2.length(); i2++) {
                var c2 = num2.charAt(i2);
                product[i1 + i2 + 1] += (c1 - '0') * (c2 - '0');
            }
        }
        for (var i = product.length - 1; i > 0; i--) {
            product[i - 1] += product[i] / 10;
            product[i] %= 10;
        }
        return Arrays.stream(product)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(""))
            .replaceFirst("^0+(?!$)", "");
    }
}
