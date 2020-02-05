package jzoffer; /**
 * Created by Administrator on 2017/4/18.
 */
import java.util.ArrayList;
public class T52 {
    public int[] multiply(int[] A) {
        int lengthA = A.length;
        if (lengthA <= 0) {
            return null;
        }
        int[] c = new int[lengthA];
        c[0] = 1;
        for (int i = 1; i < lengthA; i++) {
            c[i] = c[i - 1] * A[i - 1];
        }


        int D = 1;
        for (int j = lengthA - 2; j >= 0; j--) {
            D *= A[j + 1];
            c[j] *= D;
        }
        return c;
    }
}
