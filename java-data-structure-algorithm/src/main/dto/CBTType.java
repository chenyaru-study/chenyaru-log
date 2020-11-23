/**
 * 数据结构-二叉树JavaBean
 */
public class CBTType {
    private String data;
    private CBTType left;
    private CBTType right;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public CBTType getLeft() {
        return left;
    }

    public void setLeft(CBTType left) {
        this.left = left;
    }

    public CBTType getRight() {
        return right;
    }

    public void setRight(CBTType right) {
        this.right = right;
    }

}
