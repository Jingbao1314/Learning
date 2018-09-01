package myThread;

/**
 * Created by jingbao on 18-4-12.
 */
interface B{
    int add(int a,int b);
}
public class Test
{
    private int id=100_000;
    public void setId(int id){
        this.id=id;
    }
    public static void main(String[] args) {
        B b=(int c,int d)->c+d;
        System.out.println(b.add(1,2));

    }
//    警告: 二进制文件Test包含myThread.Test
//    Classfile /home/jingbao/IdeaProjects/untitled4/src/myThread/Test.class
//Last modified 2018-4-12; size 361 bytes
//    MD5 checksum 1430f66948cc56daa712bdfb5d6928fd
//    Compiled from "Test.java"
//    public class myThread.Test
//    SourceFile: "Test.java"
//    minor version: 0
//    major version: 51
//    flags: ACC_PUBLIC, ACC_SUPER
//    Constant pool:
//        #1 = Methodref          #4.#17         //  java/lang/Object."<init>":()V
//        #2 = Fieldref           #3.#18         //  myThread/Test.id:I
//        #3 = Class              #19            //  myThread/Test
//        #4 = Class              #20            //  java/lang/Object
//        #5 = Utf8               id
//        #6 = Utf8               I
//        #7 = Utf8               <init>
//        #8 = Utf8               ()V
//        #9 = Utf8               Code
//        #10 = Utf8               LineNumberTable
//        #11 = Utf8               setId
//        #12 = Utf8               (I)V
//        #13 = Utf8               main
//        #14 = Utf8               ([Ljava/lang/String;)V
//        #15 = Utf8               SourceFile
//        #16 = Utf8               Test.java
//        #17 = NameAndType        #7:#8          //  "<init>":()V
//        #18 = NameAndType        #5:#6          //  id:I
//        #19 = Utf8               myThread/Test
//        #20 = Utf8               java/lang/Object
//    {
//  public myThread.Test();
//        flags: ACC_PUBLIC
//        Code:
//        stack=2, locals=1, args_size=1
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: aload_0
//        5: iconst_0
//        6: putfield      #2                  // Field id:I
//        9: return
//            LineNumberTable:
//        line 6: 0
//        line 8: 4
//
//        public void setId(int);
//        flags: ACC_PUBLIC
//        Code:
//        stack=2, locals=2, args_size=2
//        0: aload_0
//        1: iload_1
//        2: putfield      #2                  // Field id:I
//        5: return
//            LineNumberTable:
//        line 10: 0
//        line 11: 5
//
//        public static void main(java.lang.String[]);
//        flags: ACC_PUBLIC, ACC_STATIC
//        Code:
//        stack=0, locals=1, args_size=1
//        0: return
//            LineNumberTable:
//        line 14: 0
//    }

}
