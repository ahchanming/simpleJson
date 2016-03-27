package simpleJson.adapter;

/**
 * Created by chanming on 16/3/25.
 */

public class StringAdapter implements TypeAdapter{
    @Override
    public Object read(String jsonIn, Class klass) throws Exception {
        return null;
    }

    @Override
    public String write(Object object) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("\"").append(object).append("\"");
        return sb.toString();
    }

    @Override
    public boolean isSuitable(Object object) {
        if (object instanceof String){
            return true;
        }
        return false;
    }

    @Override
    public boolean isSuitableByClass(Class klass) {
        if (klass == String.class){
            return true;
        }
        return false;
    }
}
