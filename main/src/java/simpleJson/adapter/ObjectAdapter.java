package simpleJson.adapter;

import simpleJson.SimpleJsonUtil;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * Created by chanming on 16/3/24.
 */

public class ObjectAdapter implements TypeAdapter {


    @Override
    public String write(Object object) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        for (int i = 0; i < pds.length; ++i){
            if (pds[i].getName().equals("class")) continue;;
            for (TypeAdapter adapter : SimpleJsonUtil.getAdapters()){
                if (adapter.isSuitable(pds[i].getReadMethod().invoke(object))){
                    try{
                        if (first){
                            first = false;
                        }else{
                            sb.append(",");
                        }
                        sb.append("\"").append(pds[i].getName()).append("\":");
                        sb.append(adapter.write(pds[i].getReadMethod().invoke(object)));
                    }catch (Exception e){
                        e.printStackTrace();
                        throw e;
                    }
                    break;
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Object read(String jsonIn, Class klass) throws Exception {
        return null;
    }

    @Override
    public boolean isSuitableByClass(Class klass) {
        return true;
    }

        @Override
    public boolean isSuitable(Object object) {
        return true;
    }

}
