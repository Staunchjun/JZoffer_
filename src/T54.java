import java.util.Scanner;

/**
 * Created by Administrator on 2017/4/19.
 */
public class T54 {
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }
}

