package simpleJson;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/3/27.
 */
public class SimpleJsonTest {

    private static String gsonAnswer(Object x){
        return new Gson().toJson(x);
    }

    private static  String csonAnswer(Object x){
        return new SimpleJson().toJsonString(x);
    }

    private static  void compare(Object x, String name){

        System.out.println("============================" + name + "============================");
        String gString = gsonAnswer(x);
        String cString = csonAnswer(x);
        System.out.println("Gson Answer is:" + gString);
        System.out.println("Cson Answer is:" + cString);
        System.out.println("result is [" + gString.equals(cString) + "]\n");
        System.out.println("--------------------------------------------------------------------");
        Integer gx = (Integer)new Gson().fromJson(gString, x.getClass());
        Integer cx = (Integer)new SimpleJson().fromJson(gString, x.getClass());
        System.out.println("Gson Answer is:" + gx);
        System.out.println("Cson Answer is:" + cx);
        System.out.println(gx.equals(cx));

    }


    private void testInteger(){

    }
    
    public static void main(String[] args){

    }
}
