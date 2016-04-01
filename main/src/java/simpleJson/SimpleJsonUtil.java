package simpleJson;

import simpleJson.adapter.*;

/**
 * Created by chanming on 16/3/25.
 */

public class SimpleJsonUtil {
    private static TypeAdapter adapters[] = {new NullAdapter(), new IntegerAdapter(), new StringAdapter(),
            new ArrayAdapter(), new ListAdapter(),  new SetAdapter(), new MapAdapter(), new ObjectAdapter()};


    public static TypeAdapter[] getAdapters(){
       return adapters;
    }
}
