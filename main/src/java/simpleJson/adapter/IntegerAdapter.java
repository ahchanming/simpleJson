package simpleJson.adapter;

/**
 * Created by chanming on 16/3/24.
 */

public class IntegerAdapter implements TypeAdapter {

    @Override
    public Object read(String jsonIn, Class klass) throws Exception {
        return Integer.valueOf(jsonIn);
    }

    @Override
    public String write(Object object) {
        return String.valueOf((Integer)object);
    }

    @Override
    public boolean isSuitable(Object object){
        return isSuitableByClass(object.getClass());
    }

    @Override
    public boolean isSuitableByClass(Class klass) {
        return klass == Integer.class ? true : false;
    }
}
