package NewCode;
/**
 * Created by Administrator on 2017/6/6.
 * 牛牛有一个数组，里面的数可能不相等，
 * 现在他想把数组变为：所有的数都相等。问是否可行。
 * 牛牛可以进行的操作是：将数组中的任意一个数改为这个数的两倍。
 * 这个操作的使用次数不限，也可以不使用，并且可以对同一个位置使用多次。
 * 输入描述:
 * 输入一个正整数N (N <= 50)
 * 接下来一行输入N个正整数，每个数均小于等于1e9.
 * 输出描述:
 * 假如经过若干次操作可以使得N个数都相等，那么输出"YES", 否则输出"NO"
 * 输入例子:
 * 2
 * 1 2
 * 输出例子:
 * YES
 */
import java.util.Scanner;
public class NK_3_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] % 2 == 0)
                nums[i] = nums[i] / 2;
        }
        int basicNum = 0;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                basicNum = nums[i];
                continue;
            }
            if (basicNum != nums[i]) {
                System.out.print("NO");
                return;
            } else {
                continue;
            }
        }
        System.out.print("YES");
    }
}
