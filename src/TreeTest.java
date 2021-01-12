import java.util.Random;

public class TreeTest {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(16);
        /*bt.add(5);
        bt.add(27);
        bt.add(43);
        bt.add(18);
        bt.add(3);
        bt.add(6);
        bt.add(13);
        bt.add(15);*/

        bt.delete(16);

        System.out.println(bt);
        //System.out.println(bt.findLeftMax(bt.root.getLeftChild()));
    }
}
