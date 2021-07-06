import java.util.Random;

public class TreeTest {
    public static void main(String[] args) {
        /*BinaryTree bt = new BinaryTree();
        bt.add(16);
        bt.add(5);
        bt.add(27);
        bt.add(43);
        bt.add(18);
        bt.add(3);
        bt.add(6);
        bt.add(13);
        bt.add(15);

        System.out.println(bt);
        bt.delete(16);

        System.out.println(bt);
        //System.out.println(bt.findLeftMax(bt.root.getLeftChild()));*/
        TreeNode t = new TreeNode(0);
        t.setLeftChild(new TreeNode(0, new TreeNode(0), new TreeNode(0, new TreeNode(6), null)));
        t.setRightChild(new TreeNode(0, null, new TreeNode(3, new TreeNode(0), new TreeNode(5))));
    }
}
