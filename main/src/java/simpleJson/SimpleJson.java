package simpleJson;

import simpleJson.adapter.TypeAdapter;

/**
 * Created by Administrator on 2016/3/27.
 */
public class SimpleJson {
    public String toJsonString(Object object){
        for (TypeAdapter typeAdapter : SimpleJsonUtil.getAdapters()){
            if (typeAdapter.isSuitable(object)){
                try{
                    return typeAdapter.write(object);
                }catch (Exception e){
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

    public Object fromJson(String jsonString, Class klass){
        try {
            for (TypeAdapter adapter : SimpleJsonUtil.getAdapters()) {
                if (adapter.isSuitableByClass(klass)) {
                    return adapter.read(jsonString, klass);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
