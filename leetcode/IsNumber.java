package leetcode;

import java.util.List;

class IsNumber {
    public static boolean isNumber(String s) {
        var state = "init";
        for (var c : s.trim().toCharArray()) {
            switch (c) {
                case '+':
                case '-':
                    switch (state) {
                        case "init": state = "sign"; break;
                        case "exp": state = "exp_sign"; break;
                        default: state = "dead"; break;
                    };
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    switch (state) {
                        case "init": case "num": case "sign": state = "num"; break;
                        case "dot": case "frac": state = "frac"; break;
                        case "exp": case "exp_num": case "exp_sign": state = "exp_num"; break;
                        default: state = "dead"; break;
                    };
                    break;
                case '.':
                    switch (state) {
                        case "init": case "sign": state = "dot"; break;
                        case "num": state = "frac"; break;
                        default: state = "dead"; break;
                    };
                    break;
                case 'e':
                case 'E':
                    switch (state) {
                        case "num": case "frac": state = "exp"; break;
                        default: state = "dead"; break;
                    };
                    break;
                default:
                    state = "dead";
                    break;
            }
            if (state == "dead") {
                return false;
            }
        }
        return List.of("num", "frac", "exp_num").contains(state);
    }
}
