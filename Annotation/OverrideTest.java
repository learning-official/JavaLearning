package Annotation;

import java.lang.reflect.Method;

public class OverrideTest {
    public static void main(String[] args){
        OverrideSon os = new OverrideSon();
        checkOverride(os);
    }

    public static void checkOverride(Object obj){
        Class<?> childClass = obj.getClass();
        Class<?> fatherClass = obj.getClass().getSuperclass();

        for (Method methods : childClass.getDeclaredMethods()){
            if (methods.isAnnotationPresent(OverrideE.class)){
                boolean check = false;
                for (Method fatherMethods : fatherClass.getDeclaredMethods()){
                    if (methods.getName() == fatherMethods.getName()){
                        check = true;
                        break;
                    }
                }
                if (check) {
                    System.out.println(methods.getName() + " 正確覆寫！");
                }else{
                    System.out.println(methods.getName() + " 覆寫失敗！" + "\n");
                }
            }
        }
    }
}
