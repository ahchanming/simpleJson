package simpleJson.adapter;

/**
 * Created by chanming on 16/3/25.
 */

public class NullAdapter implements TypeAdapter {

    @Override
    public Object read(String jsonIn, Class klass) throws Exception {
        return null;
    }

    @Override
    public String write(Object object) throws Exception {
        return "null";
    }

    @Override
    public boolean isSuitable(Object object) {
        if (object == null){
            return true;
        }
        return false;
    }

    @Override
    public boolean isSuitableByClass(Class klass) {
        return false;
    }
}
