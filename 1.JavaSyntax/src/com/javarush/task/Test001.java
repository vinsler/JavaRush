package com.javarush.task;

public class Test001 {
    private int i = 10;

    void method(){
        System.out.println(i);

        Inner1 inner1 = new Inner1();
        System.out.println(inner1.j);

        Inner1.Inner2 inner2 = new Inner1().new Inner2();
        System.out.println(inner2.k);

        // классы внутри методов внутренних классов как сюда запихать хз?
    }

    class Inner1{
        private int j = 20;

        void method1(){
            System.out.println(j);
        }

        class  Inner2 {
            private int k = 30;

            void method2(){

                class InnerMethod{
                    private int l = 40;
                    void method3() {
                        System.out.println(l);
                        System.out.println(k);
                        System.out.println(j);
                        System.out.println(i);
                    }
                }

                InnerMethod innerMethod = new InnerMethod();
                innerMethod.method3();

                /*System.out.println(k);
                System.out.println(j);
                System.out.println(i);*/
            }
        }
    }

    public static void main(String[] args) {
        Test001 test001 = new Test001();
        Inner1 inner1 = test001.new Inner1();
        Inner1.Inner2 inner2 = inner1.new Inner2();

        //inner2.method2();

    }
}


class Test002 {
    Test001.Inner1.Inner2 inner2 = new Test001().new Inner1().new Inner2();

    void met(){
        inner2.method2();
    }

    public static void main(String[] args) {
        Test002 test002 = new Test002();
        test002.met();
    }
}
