package homework1219;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO<T> {
    private Map<String,T> map;

    public DAO() {
        this.map = new HashMap<>();
    }

    public void save(String id, T entity){
        this.map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id, T entity){
        map.replace(id, map.get(id),entity);
    }
    public List<T> list(){
        List<T> list = new ArrayList<>();
        for (T t: map.values()
             ) { list.add(t);
        }
        return list;
    }
    public void delete(String id){
        map.remove(id);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}
