import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private TreeNode root;
    private int size;

    public BinaryTree(){
        this.root = null;
        this.size=0;
    }

    public BinaryTree(Integer rootValue){
        this.root = new TreeNode(rootValue);
        this.size=0;
    }

    public void printPreOrder(){ printPreOrder(this.root); }
    private void printPreOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root + " ");
        printPreOrder(root.getLeftChild());
        printPreOrder(root.getRightChild());
    }

    public void printPostOrder(){ printPostOrder(this.root); }
    private void printPostOrder(TreeNode root){
        if(root == null) return;
        printPostOrder(root.getLeftChild());
        printPostOrder(root.getRightChild());
        System.out.print(root + " ");
    }

    public void printInOrder(){ printInOrder(this.root); }
    private void printInOrder(TreeNode root){
        if(root == null) return;
        printInOrder(root.getLeftChild());
        System.out.print(root + " ");
        printInOrder(root.getRightChild());
    }

    public void printLevelOrder(){
        if(this.root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(this.root);
        while(!q.isEmpty()){
            TreeNode current = q.peek();
            System.out.print(q.poll() + " ");
            if(current.getLeftChild() != null){
                q.add(current.getLeftChild());
            }
            if(current.getRightChild() != null){
                q.add(current.getRightChild());
            }
        }
        System.out.println();
    }

    public void add(int value){
        if(this.root==null){
            this.root = new TreeNode(value);
            return;
        }
        add(value, root);
        ++size;
    }
    private void add(int value, TreeNode root){
        if(value >= root.getValue()){
            if(root.getRightChild() == null){
                root.setRightChild(new TreeNode(value));
            }
            else {
                add(value, root.getRightChild());
            }
        }
        if(value < root.getValue()){
            if(root.getLeftChild() == null){
                root.setLeftChild(new TreeNode(value));
            }
            else{
                add(value, root.getLeftChild());
            }
        }
    }

    public boolean contains(int value){
        return contains(value, this.root);
    }
    private boolean contains(int value, TreeNode root){
        if(root==null){
            return false;
        }
        if(root.getValue()==value){
            return true;
        }
        if(value>=root.getValue()){
            return contains(value, root.getRightChild());
        }
        return contains(value, root.getLeftChild());
    }

    public int getHeight(){
        return getHeight(this.root);
    }
    private int getHeight(TreeNode root){
        if(root==null){
            return -1;
        }
        if(root.isLeaf()){
            return 0;
        }
        return 1 + Math.max(getHeight(root.getLeftChild()), getHeight(root.getRightChild()));
    }

    public int size(){
        return this.size;
    }

    public boolean delete(int value){
        TreeNode parent = null;
        TreeNode current = this.root;
        //Find node with value to delete and its parent
        while(current != null && current.getValue()!=value){
            parent = current;
            if(value>current.getValue()){
                current = current.getRightChild();
            }
            else {
                current = current.getLeftChild();
            }
        }
        //Return false if doesnt exist
        if(current==null) return false;
        //Handle case where current value is in a node with no children
        if(current.isLeaf()){
            if(current==this.root){
                this.root = null;
            }
            else {
                if(current == parent.getRightChild())
                    parent.setRightChild(null);
                else
                    parent.setLeftChild(null);
            }
        }
        //Handle case where current value is in a node with one child
        else if(current.getLeftChild() == null && current.getRightChild() != null || current.getLeftChild() != null && current.getRightChild() == null){
            if(current==root){
                current = current.getRightChild() == null ? current.getLeftChild() : current.getRightChild();
            }
            else {
                if(parent.getRightChild()==current){
                    parent.setRightChild(current.getRightChild() == null ? current.getLeftChild() : current.getRightChild());
                }
                else {
                    parent.setLeftChild(current.getRightChild() == null ? current.getLeftChild() : current.getRightChild());
                }
            }
        }
        //Handle case where current value is in a node with two children
        else if(current.getLeftChild() != null && current.getRightChild() != null){
            int leftMax = findLeftMax(current.getLeftChild());
            //Delete origin of value that deleted value is replaced with
            delete(leftMax);
            current.setValue(leftMax);
        }

        return true;
    }

    private int findLeftMax(TreeNode root){
        if(root.isLeaf()){
            return root.getValue();
        }
        int t = findLeftMax(root.getRightChild());
        if(root.getValue()>t)
            return root.getValue();
        else
            return t;
    }

    public String toString(){ return toStringHelper(this.root); }
    private String toStringHelper(TreeNode root){
        if(root == null) return "";
        return root + " " + toStringHelper(root.getLeftChild()) + toStringHelper(root.getRightChild());
    }
}
