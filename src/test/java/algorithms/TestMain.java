package algorithms;

import data.RedBlackBST;
import org.junit.jupiter.api.Test;

public class TestMain {
    
    @Test
    public void test(){
        RedBlackBST<String,String> tree=new RedBlackBST<>();
        tree.put("A","apple");
        tree.put("D","Dog");
        tree.put("B","baby");
        tree.put("Z","z");
        tree.put("E","element");

        tree.print();
    }
}
