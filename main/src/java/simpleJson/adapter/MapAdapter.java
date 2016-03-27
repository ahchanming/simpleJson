package simpleJson.adapter;

import simpleJson.SimpleJsonUtil;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Map;

/**
 * Created by chanming on 16/3/25.
 */

public class MapAdapter implements TypeAdapter {

    @Override
    public Object read(String jsonIn, Class klass) throws Exception {
        return null;
    }

    @Override
    public String write(Object object) throws Exception {

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        try {
            for (Map.Entry<Object, Object> entry : ((Map<Object, Object>) object).entrySet()) {
                if (first){
                    first = false;
                }else{
                    sb.append(",");
                }
                BeanInfo beanInfo = Introspector.getBeanInfo(entry.getClass());
                PropertyDescriptor pds[] = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor pd : pds) {
                    if (pd.getName().equals("class")) continue;
                    if (pd.getName().equals("key")) {
                        sb.append("\"").append(pd.getReadMethod().invoke(entry)).append("\":");
                    } else {
                        for (TypeAdapter adapter : SimpleJsonUtil.getAdapters()) {
                            if (adapter.isSuitable(pd.getReadMethod().invoke(entry))) {
                                sb.append(adapter.write(pd.getReadMethod().invoke(entry)));
                                break;
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        sb.append("}");
        return  sb.toString();
    }

    @Override
    public boolean isSuitable(Object object) {
        if (object instanceof Map){
            return true;
        }
        return false;
    }

    @Override
    public boolean isSuitableByClass(Class klass) {
        return false;
    }
}
