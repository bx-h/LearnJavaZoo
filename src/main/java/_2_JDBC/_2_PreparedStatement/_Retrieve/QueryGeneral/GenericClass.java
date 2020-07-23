package _2_JDBC._2_PreparedStatement._Retrieve.QueryGeneral;

import org.junit.Test;

public class GenericClass<T> {
    //Type declaration <T> already done at class level
    private  T myMethod(T a){
        return  a;
    }

    //<T> is overriding the T declared at Class level;
    //So There is no ClassCastException though a is not the type of T declared at MyClass<T>.
    private <T> T myMethod1(Object a){
        return (T) a;
    }

    //Runtime ClassCastException will be thrown if a is not the type T (MyClass<T>).
    private T myMethod2(Object a){
        return (T) a;
    }

    // No ClassCastException
    // MyClass<String> obj= new MyClass<String>();
    // obj.myMethod2(Integer.valueOf("1"));
    // Since type T is redefined at this method level.
    private <T> T myMethod3(T a){
        return  a;
    }

    // No ClassCastException for the below
    // MyClass<String> o= new MyClass<String>();
    // o.myMethod3(Integer.valueOf("1").getClass())
    // Since <T> is undefined within this method;
    // And MyClass<T> don't have impact here
    private <T> T myMethod4(Class a){
        return (T) a;
    }

    // ClassCastException for o.myMethod3(Integer.valueOf("1").getClass())
    // Should be o.myMethod3(String.valueOf("1").getClass())
    private  T myMethod5(Class a){
        return (T) a;
    }


    // Class<T> a :: a is Class object of type T
    //<T> is overriding of class level type declaration;
    private <T> Class<T> myMethod6(Class<T> a){
        return  a;
    }


    @Test
    public void test() {
        Integer a = 0;
        String b = "abc";
        GenericClass<Integer> GC = new GenericClass<>();
        GC.myMethod(a);
        String result = GC.myMethod3(b);
        System.out.println(result);
    }
}
