package tags;

import java.util.ArrayList;
import java.util.List;

public class ListTerm {

    private List<Element> list;

    public ListTerm() {
        this.list = new ArrayList<>();
    }

    public List<Element> getList() {
        return list;
    }

    public void setList(List<Element> list) {
        this.list = list;
    }

    public void addElement(Element term) {
        //Kiem tra tu term co trong list chua
        if (!this.list.contains(term)) {
            this.list.add(term);
        }
        //Neu chua co thi them moi
        //Neu da co thi khong lam gi ca
    }
    
    public Long find(String term){
       return this.list.get(this.list.indexOf(new Element(0, term))).getIndex();
    }
    
    public long getSize(){
        return this.list.size();
    }
    
    public void clearList(){
        this.list.clear();
    }

}
