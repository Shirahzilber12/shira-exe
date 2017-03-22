package com.company;

import java.awt.event.MouseMotionListener;

public class Main {

    public static void main(String[] args) {
// Dog dog=new Dog();
        Dog dog=Dog.createDog();


        ShapeFactory shapeFactory=new ShapeFactory();

        Shape s=shapeFactory.getShape("circle");
        s.draw();

    }
}

// ללא המילה new , ניצור פונקציה שהיא סטטית
//קטגורית Creational Patterns - יצירת אובייקטים שלא דרך new

//singelton
class Dog {

    private Dog(){// א"א ליצור מבחוץ כי הבנאי הוא private
        System.out.println("in dog constractor");
    }

    /* for singelton
    private static Dog d=null;
    */
    public static Dog createDog() {
        return new Dog();
    }
}




//קטגורית Behavioral Patterns - תקשורת בין אובייקטים

// design pattern - Observer/Listener
class MotionSensor{
    private MotionListener listener;

    public void setListener(MotionListener listener) {
        this.listener = listener;
    }

    public void detectMotion(){
        if (listener!=null)
            listener.motionDetected(123);
    }

    interface MotionListener{
        void motionDetected(int sensorId);
    }
}

// קטגורית Structural Patterns - מחלקות מורכבות בתוך מחלקות




// קטגורית J2EE - קשור לממשק משתמש יותר מאשר לקוד
// תהיה קשורה להמשך יותר




//תבנית ה- Factory
//יוצרים אובייקטים מבלי לחשוף החוצה את לוגיקת יצירת האובייקט ומתייחסים לאובייקט שנוצר באמצעות interface מוכר.
interface Shape{
    void draw();
}

class Circle implements Shape{
    @Override
    public void draw() {

    }
}
class Square implements Shape{
    @Override
    public void draw() {

    }
}
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println();
    }
}

class ShapeFactory{
    public Shape getShape(String shapeType){
        if (shapeType==null)
            return null;
        switch (shapeType) {
            case "circle":
                return new Circle();
            case "rectangle:":
                return new Rectangle();
            case "square:":
                return new Square();
            default:
                return null;

        }
    }
}

 abstract class ShapeDecorator implements Shape{
    protected Shape decoractedShape;

    public ShapeDecorator(Shape decoractedShape) {
        this.decoractedShape = decoractedShape;
    }


     @Override
     public void draw() {
         decoractedShape.draw();
     }
 }






//(Structural Patterns) Decorator - תבנית ה
// מאפשר למשתמש להוסיף פונקציונליות לאובייקט קיים מבלי לשנות את המבנה שלו. תבנית זו היא תחת הקטגוריה השניה והתבנית משתמש ב״מעטפת״ למחלקה קיימת
// נישאר עם Shape

