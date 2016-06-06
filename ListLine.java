
package tags;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hienlrc
 */
public class ListLine {
    private List<LineElement> list = new ArrayList<>();
    private Long sizeOfBoW;

    public ListLine() {
    }

    public ListLine(List<LineElement> list) {
        this.list = list;
    }

    public List<LineElement> getList() {
        return list;
    }

    public Long getSizeOfBoW() {
        return sizeOfBoW;
    }
    
    public void setList(List<LineElement> list) {
        this.list = list;
    }

    public void setSizeOfBoW(Long sizeOfBoW) {
        this.sizeOfBoW = sizeOfBoW;
    }
    
    public void add(LineElement element){
        this.list.add(element);
    }
    
    public void clearList(){
        this.list.clear();
    }
    
}
