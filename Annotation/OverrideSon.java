package Annotation;

public class OverrideSon extends OverrideFather{

    @OverrideE
    public void shouldBeOverride(){
        System.out.println("I'm son!");
    }

    @OverrideE
    public void aaa(){
    }

}
