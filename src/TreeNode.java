public class TreeNode {
    private TreeNode leftChild;
    private TreeNode rightChild;
    private Integer value;

    public TreeNode(Integer value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override public String toString() {
        return this.value + "";
    }

    public boolean isLeaf(){
        return this.leftChild == null && this.rightChild==null;
    }
}
