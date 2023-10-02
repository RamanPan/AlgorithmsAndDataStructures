import java.util.LinkedList;

public class PrintTree {
    private static void printSpace(double n, NodeAvl removed)
    {
        for (; n > 0; n--) {
            System.out.print("\t");
        }
        if (removed == null) {
            System.out.print(" ");
        }
        else {
            System.out.print(removed.key);
        }
    }

    private static int heightOfTree(NodeAvl root)
    {
        if (root == null) {
            return 0;
        }
        return 1
                + Math.max(heightOfTree(root.left),
                heightOfTree(root.right));
    }

    public static void printBinaryTree(NodeAvl root)
    {
        LinkedList<NodeAvl> treeLevel = new LinkedList<>();
        treeLevel.add(root);
        LinkedList<NodeAvl> temp = new LinkedList<>();
        int counter = 0;
        int height = heightOfTree(root) - 1;
        double numberOfElements
                = (Math.pow(2, (height + 1)) - 1);
        while (counter <= height) {
            NodeAvl removed = treeLevel.removeFirst();
            if (temp.isEmpty()) {
                printSpace(numberOfElements
                                / Math.pow(2, counter + 1),
                        removed);
            }
            else {
                printSpace(numberOfElements
                                / Math.pow(2, counter),
                        removed);
            }
            if (removed == null) {
                temp.add(null);
                temp.add(null);
            }
            else {
                temp.add(removed.left);
                temp.add(removed.right);
            }

            if (treeLevel.isEmpty()) {
                System.out.println("");
                System.out.println("");
                treeLevel = temp;
                temp = new LinkedList<>();
                counter++;
            }
        }
    }
}
