package Annotation;

@ClassAnnotation
public class AnnotationTest {

    @FieldAnnotation
    String name;

    public AnnotationTest(String name){
        this.name = name;
    }

    @MethodAnnotation
    public void print(){
        System.out.println("My name is " + this.name);
    }
}
