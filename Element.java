
package tags;

import java.util.Objects;

public class Element {

    private long index;
    private String term;

    public Element() {
    }

    public Element(long index, String term) {
        this.index = index;
        this.term = term;
    }

    public long getIndex() {
        return index;
    }

    public String getTerm() {
        return term;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public void setTerm(String term) {
        this.term = term;
    }
    
    @Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;

        if (object != null && object instanceof Element)
        {
            sameSame = (this.term == null ? ((Element) object).term == null : this.term.equals(((Element) object).term));
        }

        return sameSame;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.index ^ (this.index >>> 32));
        hash = 83 * hash + Objects.hashCode(this.term);
        return hash;
    }
}
