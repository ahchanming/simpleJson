package simpleJson.adapter;

/**
 * Created by chanming on 16/3/24.
 */

public class IntegerAdapter implements TypeAdapter {

    public IntegerAdapter(){

    }

    @Override
    public Object read(String jsonIn, Class klass) throws Exception {
        return Integer.valueOf(jsonIn);
    }

    @Override
    public String write(Object object) {
        return String.valueOf((Integer)object);
    }

//    @Override
//    public boolean isSuitable(Class klass) {
//        if (klass == Integer.TYPE){
//            return true;
//        }
//        return false;
//    }

    @Override
    public boolean isSuitable(Object object){
        if (object instanceof Integer){
            return true;
        }
        return false;
    }

    @Override
    public boolean isSuitableByClass(Class klass) {
        return klass == Integer.class ? true : false;
    }
}
