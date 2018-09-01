package generics.ii;

import java.util.ArrayList;
import java.util.List;

// 定义Shape的子类Circle
abstract class Shape {
    public abstract void draw(Canvas c);
}

class Circle extends Shape {
    // 实现画图方法，以打印字符串来模拟画图方法实现
    public void draw(Canvas c) {
        System.out.println("在画布" + c + "上画一个圆");
    }
}

// 定义Shape的子类Rectangle
class Rectangle extends Shape {
    public void draw(Canvas c) {
        System.out.println("把一个矩形画在画布" + c + "上");
    }
}

public class Canvas {
    //	范型必须严格匹配
//    public void drawAll(List<Shape> shapes) {
//        for (Shape s : shapes) {
//            s.draw(this);
//        }
//    }
//
//    public void drawAll(List<?> shapes) {
//        for (Object obj : shapes) {
//            Shape s = (Shape) obj;
//            s.draw(this);
//        }
//    }
    // 同时在画布上绘制多个形状，使用被限制的泛型通配符
    public void drawAll(List<? extends Shape> shapes) {//函数模板
        for (Shape s : shapes) {
            s.draw(this);
        }
    }
//    public void drawAlal(List<? super Shape> shapes) {
//
//    }

    public static void main(String[] args) {
        List<Circle> circleList = new ArrayList<Circle>();
        Canvas c = new Canvas();
        circleList.add(new Circle());
        // 由于List<Circle>并不是List<Shape>的子类型,
        // 所以下面代码引发编译错误
        c.drawAll(circleList);

        List<Rectangle> rectangleList = new ArrayList<Rectangle>();
        Canvas c1 = new Canvas();
        rectangleList.add(new Rectangle());
        // 由于List<Circle>并不是List<Shape>的子类型,
        // 所以下面代码引发编译错误
        c1.drawAll(rectangleList);
    }

}
