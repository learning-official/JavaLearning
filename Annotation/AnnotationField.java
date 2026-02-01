package Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class AnnotationField {

    public static void main(String[] args){
        AnnotationFieldTest aft = new AnnotationFieldTest(null);
        try{
            checkNull(aft);
        }catch (IllegalAccessException e){
            System.out.println(e.getCause());
        }

        Method[] methods = aft.getClass().getDeclaredMethods();
        for (int i=0; i<methods.length; i++){
            System.out.print(methods[i] + " ");
        }

    }

    public static void checkNull(Object obj) throws IllegalAccessException{
        for (Field field : obj.getClass().getDeclaredFields()){
            if (field.isAnnotationPresent(FieldCheck.class)){
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value == null){
                    System.out.println("error : " + field.getAnnotation(FieldCheck.class).message());
                }else{
                    System.out.println("pass : " + field.getName());
                }
            }
        }
    }
}
