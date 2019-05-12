package utils.data;

/**
 * Created by robert on 6/4/17.
 */

public class BTreeNode {
    public char data;
    public String szData;
    public int iData;
    public BTreeNode lChild;
    public BTreeNode rChild;

    public BTreeNode(char data) {
        this.data = data;
    }

    public BTreeNode(int data) {
        this.iData = data;
    }

    public BTreeNode(String data) {
        this.szData = data;
    }

    public BTreeNode(String data, BTreeNode lChild, BTreeNode rChild) {

        this.szData = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }
}
