package jzoffer;

/**
 * Created by Administrator on 2017/3/19.
 */
public class T8 {
    public int JumpFloor(int target) {
        if (target < 3)
        {
            return target;
        }
        int  F2 = 2;
        int  F1 = 1;
        int  Fn = 0;
        for(int i = 3;i<=target;i++)
        {
            Fn = F2 +F1;
            F1 = F2;
            F2= Fn;
        }
        return Fn;
    }
}

