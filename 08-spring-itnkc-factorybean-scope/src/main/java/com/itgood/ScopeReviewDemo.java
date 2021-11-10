package com.itgood;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/10 10:33
 */
public class ScopeReviewDemo {
    // 类级别成员
    private static String classVariable = "";

    // 对象级别成员
    private String objectVariable = "";

    public static void main(String[] args) throws Exception {
        // 方法级别成员
        String methodVariable = "";
        for (int i = 0; i < args.length; i++) {
            // 循环体局部成员
            String partVariable = args[i];

            // 此处能访问哪些变量？
            System.out.println(classVariable);
        }
        System.out.println(classVariable);
        // 此处能访问哪些变量？
    }

    public void test() {
        // 此处能访问哪些变量？
        System.out.println(objectVariable);
    }

    public static void staticTest() {
        // 此处能访问哪些变量？
        System.out.println(classVariable);
    }
}
