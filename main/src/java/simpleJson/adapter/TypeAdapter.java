package simpleJson.adapter;

/**
 * Created by chanming on 16/3/24.
 */
public interface TypeAdapter {
    public String write(Object object) throws Exception;

    public Object read(String jsonIn, Class klass) throws Exception;

    public boolean isSuitable(Object object);

    public boolean isSuitableByClass(Class klass);

}
