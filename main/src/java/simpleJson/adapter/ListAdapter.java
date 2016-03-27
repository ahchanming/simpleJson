package simpleJson.adapter;

import simpleJson.SimpleJsonUtil;

import java.util.Iterator;
import java.util.List;

/**
 * Created by chanming on 16/3/25.
 */

public class ListAdapter implements TypeAdapter {
    @Override
    public String write(Object object) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        try{
            Iterator<Object> iterator = ((List<Object>)object).iterator();
            while (iterator.hasNext()){
                if (first){
                    first = false;
                }else{
                    sb.append(",");
                }
                Object obj = iterator.next();
                for (TypeAdapter adapter : SimpleJsonUtil.getAdapters()){
                    if (adapter.isSuitable(obj)){
                        sb.append(adapter.write(obj));
                        break;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Object read(String jsonIn, Class klass) throws Exception {
        return null;
    }

//    @Override
//    public boolean isSuitable(Class klass) {
//        if (klass == List.class){
//            return true;
//        }
//        return false;
//    }


    @Override
    public boolean isSuitableByClass(Class klass) {
        if (klass == List.class){
            return true;
        }
        return false;
    }

    @Override
    public boolean isSuitable(Object object) {
        if (object instanceof List){
            return true;
        }
        return false;
    }
}
