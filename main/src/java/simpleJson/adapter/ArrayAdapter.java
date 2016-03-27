package simpleJson.adapter;


import simpleJson.SimpleJsonUtil;

/**
 * Created by chanming on 16/3/25.
 */

public class ArrayAdapter implements TypeAdapter {

    @Override
    public Object read(String jsonIn, Class klass) throws Exception {
        return null;
    }

    @Override
    public String write(Object object) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        try{
            for (Object obj : (Object[])object){
                if (first){
                    first = false;
                }else{
                    sb.append(",");
                }
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
    public boolean isSuitable(Object object) {
        return object.getClass().isArray();
    }


    @Override
    public boolean isSuitableByClass(Class klass) {
        return false;
    }
}
