package myBlockQueue;

/**
 * Created by jingbao on 18-5-5.
 */
public class JavapTest {
    public void say(int a){
        System.out.println(a);
    }
    public static void main(String[] args) {
        int i=1;
        while (i<10){
            int b=4;
            int c=8;
            i++;
        }
        new JavapTest().say(i);
    }
}
//Classfile /home/jingbao/IdeaProjects/untitled4/src/myBlockQueue/JavapTest.class
//Last modified 2018-5-5; size 331 bytes
//        MD5 checksum 8e6a9444d3613914d8199a4189fc2dda
//        Compiled from "JavapTest.java"
//public class myBlockQueue.JavapTest
//        minor version: 0
//        major version: 52
//        flags: ACC_PUBLIC, ACC_SUPER
//        Constant pool:
//        #1 = Methodref          #3.#13         // java/lang/Object."<init>":()V
//        #2 = Class              #14            // myBlockQueue/JavapTest
//        #3 = Class              #15            // java/lang/Object
//        #4 = Utf8               <init>
//   #5 = Utf8               ()V
//           #6 = Utf8               Code
//           #7 = Utf8               LineNumberTable
//           #8 = Utf8               main
//           #9 = Utf8               ([Ljava/lang/String;)V
//           #10 = Utf8               StackMapTable
//           #11 = Utf8               SourceFile
//           #12 = Utf8               JavapTest.java
//           #13 = NameAndType        #4:#5          // "<init>":()V
//           #14 = Utf8               myBlockQueue/JavapTest
//           #15 = Utf8               java/lang/Object
//           {
//public myBlockQueue.JavapTest();
//        descriptor: ()V
//        flags: ACC_PUBLIC
//        Code:
//        stack=1, locals=1, args_size=1
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//        LineNumberTable:
//        line 6: 0
//
//public static void main(java.lang.String[]);
//        descriptor: ([Ljava/lang/String;)V
//        flags: ACC_PUBLIC, ACC_STATIC
//        Code:
//        stack=2, locals=2, args_size=1
//        0: iconst_1
//        1: istore_1
//        2: iload_1
//        3: bipush        10
//        5: if_icmpge     14
//        8: iinc          1, 1
//        11: goto          2
//        14: return
//        LineNumberTable:
//        line 8: 0
//        line 9: 2
//        line 10: 8
//        line 12: 14
//        StackMapTable: number_of_entries = 2
//        frame_type = 252 /* append */
//        offset_delta = 2
//        locals = [ int ]
//        frame_type = 11 /* same */
//        }
//        SourceFile: "JavapTest.java"
