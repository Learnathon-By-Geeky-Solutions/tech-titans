import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
class passbyvalue {

    void change(int i) {
        i = 20;
    }
}

class callbyreference {

    String name;

    void change(callbyreference r1) {
        r1.name = "Enam";
    }
}

class vargaradd {

    int add(int... n) {
        int sum = 0;
        for (int i : n) {
            sum += i;
        }
        return sum;
    }
}

class Student {

    String name;
    int age;
    int marks;
}

public class Basic {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int num1 = 5;
        //int num11=scan.nextInt();

        byte num2 = 127;
        // byte num22=scan.nextByte();

        short num3 = 3_45;
        //short num33=scan.nextShort();

        long num4 = 343_344_433_999_999_999L;
        // long num44=scan.nextLong();

        float num5 = 5.644f;
        //float num55=scan.nextFloat();

        double num6 = 54.33444;
        // double num66=scan.nextDouble();

        char c = 'k';
        // char c1=scan.next().charAt(0);

        boolean t = true;
        //boolean t1=scan.nextBoolean();

        System.out.println("Integer = " + num1 + " byte = " + num2 + " short = " + num3 + " long = " + num4);
        System.out.println("Float = " + num5 + " Double = " + num6);
        System.out.println("char = " + c + " boolean = " + t);

        //Ternary operator
        int numc = 5;
        String res = numc % 2 == 0 ? "even" : "odd";
        System.out.println("result = " + res);

        //1D Array
        int arr[] = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        int arr1[] = new int[5];
        //Scanner scann=new Scanner(System.in);
        //for(int i=0;i<5;i++){  arr1[i]=scann.nextInt();}
        //for(int i=0;i<5;i++)System.out.println(arr1[i]);

        //2D Array
        int arr2D[][] = new int[5][];
        //3D Array
        int arr3D[][][] = new int[5][][];

        //Array object 
        Student s1 = new Student();
        s1.name = "aminul";
        s1.age = 24;
        s1.marks = 56;

        Student s2 = new Student();
        s2.name = "rabbi";
        s2.age = 21;
        s2.marks = 93;

        Student s3 = new Student();
        s3.name = "faisal";
        s3.age = 11;
        s3.marks = 69;

        Student students[] = new Student[5];

        students[0] = s1;
        students[1] = s2;
        students[2] = s3;

        for (int i = 0; i < 3; i++) {
            System.out.println("Name = " + students[i].name + "  Age = " + students[i].age + "  Marks = " + students[i].marks);
        }

        //Wrapping
        int p = 25;
        Integer pp = Integer.valueOf(p); // boxing 
        System.out.println(pp);

        Integer ppp = p;//auto-boxing
        System.out.println(ppp);

        Double ob = new Double(10.35);
        double ob1 = ob.doubleValue(); // unboxing
        double ob2 = ob; // Auto_unboxing
        System.out.println(ob1);
        System.out.println(ob2);

        //string to primitive type
        String str = "25";
        int strN = Integer.parseInt(str);
        System.out.println(strN * 2);

        //pass by value 
        passbyvalue obb = new passbyvalue();
        int x = 10;
        obb.change(x);
        System.out.println(x);

        //pass by reference
        callbyreference obc = new callbyreference();
        obc.name = "Anis";
        obc.change(obc);
        System.out.println(obc.name);

        //Varargs in Java
        vargaradd su = new vargaradd();
        System.out.println(su.add(1, 2, 3, 4, 5, 6));// any number of parameter you can pass

        //switch statement
        int n = 9;
        switch (n) {
            case 1, 7, 9 ->
                System.out.println("Anis");
            case 2 ->
                System.out.println("Enam");
            default ->
                System.out.println("default");
        }
        String day = "Monday";
        String result;
        result = switch (day) {
            case "sunday", "Monday" ->
                "6am";
            case "Tuesday" ->
                "7am";
            default ->
                "9am";
        };
        System.out.println(result);

        //forEach
        List<Integer> nums = Arrays.asList(2, 3, 4, 5, 6);
        nums.forEach(i -> System.out.println(i));

        //final keyword
        final int bonus = 3;
        //bouns=2//cannot change the value because it is primitive type

        final A stu = new A("Sabbir Rahman");

        stu.name = "Adilur Rahman";

        //when a non primitive is final , you can change the value , but you cannot reassing another object
        // stu = new A("new object");


        
        //Garbage collection ->finalize() mehtod
        B sta = new B();
        sta = new B();
        System.gc();

    }

}

class A {

    //a final variable must be initialized at the time of declaration or within the constructor if it's an instance variable
    final int num = 5;
    String name;

    A(String name) {
        this.name = name;
    }

}

class B {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage collection : This unused object is romoved when memory space needed");
    }
}
