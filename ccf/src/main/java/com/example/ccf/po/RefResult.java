package com.example.ccf.po;
import java.util.List;
public class RefResult {
    private List<References> references;
    private int referenceCount;

    public List<References> getReferences() {
        return references;
    }

    public void setReferences(List<References> references) {
        this.references = references;
    }

    public int getReferenceCount() {
        return referenceCount;
    }

    public void setReferenceCount(int referenceCount) {
        this.referenceCount = referenceCount;
    }
}
