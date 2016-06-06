package tags;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 *
 */
public class LineElement {

    private String pathOfFile;
    private String topicName;
    private HashMap<String, String> data = new HashMap<String, String>();

    public LineElement() {
    }

    public LineElement(String pathOfFile, String topicName) {
        this.pathOfFile = pathOfFile;
        this.topicName = topicName;
    }

    public HashMap<String, String> getData() {
        return data;
    }

    public String getPathOfFile() {
        return pathOfFile;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }

    public void setPathOfFile(String pathOfFile) {
        this.pathOfFile = pathOfFile;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void add(String key) {
        if (this.data.containsKey(key)) {//Có tồn tại - lấy term frequency + 1
            int t_f = Integer.parseInt(this.data.get(key).split("##")[1]);
            t_f++;
            this.data.replace(key, this.data.get(key).split("##")[0] + "##" + t_f);
        } else {//Chưa có thì thêm mới mặc tf = 1
            this.data.put(key, key + "##" + 1);//<key,value>  = <cần thơ, cần thơ##1>
        }
    }

    public static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public static String getKeysByValue(Map<String, String> map, String value) {
        for (Entry<String, String> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue().split("##")[0])) {
                return entry.getValue();
            }
        }
        return "";
    }
}
