package huaweispecification;

class Dog {
    public static void bark() {
        System.out.println("Wolf");
    }
}

class Baseji extends Dog {
    public static void bark() {
        System.out.println("miao miao");
    }
}

public class Rule53 {
    static String sentence = "test shadow";
    //如果下一句被打开，main函数里面的System 无法使用，
    // 因为，main函数里面的System 被static String System; 这句话 遮掩了，会编有错误
    //obscure type java.lang.System
//    static String System;
    public static void main(String[] args) {
         Dog dog = new Dog();
         Dog baseji = new Baseji();
        System.out.println("===========分割线（hide 隐藏）============");
         dog.bark();
        /**
         * 当父类和子类有同名的静态方法的时候，声明父类变量引用子类实例，声明父类变量引用子类实例，声明父类变量引用子类实例
         * 调用该静态方法时调用的是父类的静态方法，而不是子类的静态方法
         */
        baseji.bark();
        System.out.println("===========分割线（hide 隐藏）============");
        Dog.bark();
        Baseji.bark();
        System.out.println("===========分割线（shadow 遮蔽）============");
        String sentence = "test shadow fail, original sentence was shadow : 'static String sentence = \"test shadow\";'";
        System.out.println(sentence);
        System.out.println("===========分割线（obscure 遮掩）============");
        // this line won't compile if "static String System;" was set  :System refers to static field"
        System.out.println("hello, obscure word");

    }

}
