package Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Annotation{
    public static void main(String[] args){

        // --------------------------------------------------------------
        AnnotationTest cat = new AnnotationTest("Alice");
        if (cat.getClass().isAnnotationPresent(ClassAnnotation.class)) System.out.println("This is an annotation class!");
        
        // --------------------------------------------------------------
        try{
            for (Method method : cat.getClass().getDeclaredMethods()){
            if (method.isAnnotationPresent(MethodAnnotation.class)){    
                    MethodAnnotation ma = method.getAnnotation(MethodAnnotation.class);
                    for (int i = 0; i<ma.time(); i++){
                        method.invoke(cat);
                    }
                }
            }
        }catch (IllegalAccessException e){
            System.out.println(e.getCause());
        }catch (InvocationTargetException e){
            System.out.println(e.getCause());
        }
        // --------------------------------------------------------------
        try{
            for (Field field : cat.getClass().getDeclaredFields()){
                if (field.get(cat) instanceof String str){
                    System.out.println(str);
                }

            }
        }catch (IllegalAccessException e){
            System.out.println(e);
        }
        // --------------------------------------------------------------
    }
}
