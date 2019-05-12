package problem_3;

import java.util.Stack;

import utils.data.BTreeNode;

/*
* Given the root to a binary tree, implement serialize(root), which
* serializes the tree into a string, and deserialize(s),
* which deserializes the string back into the tree.
*
* For example, given the following Node class
*
* class Node:
*     def __init__(self, val, left=None, right=None):
*         self.val = val
*         self.left = left
*         self.right = right
* The following test should pass:
*
* node = Node('root', Node('left', Node('left.left')), Node('right'))
* assert deserialize(serialize(node)).left.left.val == 'left.left'*/
public class Problem_3 {

    private static final int LEFT = 1;
    private static final int RIGHT = 2;

    public static void main(String[] args) {
        String bufferForBTree = "1(9(5(6,4)),7(15,3(,1)))";
        StringBuffer bufferForDeserialized = new StringBuffer();

        BTreeNode tree = deserializeBTree(bufferForBTree);
        serializeTree(tree, bufferForDeserialized);

        System.out.println("bufferForBTree: " + bufferForBTree);
        System.out.println("bufferForDeserialized: " + bufferForDeserialized);
        System.out.println("equal to " + bufferForDeserialized.toString().equals(bufferForBTree));
    }

    private static BTreeNode deserializeBTree(String stringBuffer) {
        Stack<BTreeNode> stacks = new Stack<>();
        int childType = LEFT;
        BTreeNode node = null;
        int count = stringBuffer.length();
        for (int index = 0; index < count; index++) {
            int charCode = stringBuffer.charAt(index);
            switch (charCode) {
                case '(':
                    stacks.push(node);
                    childType = LEFT;
                    break;
                case ')':
                    node = stacks.pop();
                    break;
                case ',':
                    childType = RIGHT;
                    break;
                default:
                    int rightIndex = index;
                    while (!ifSpecificCharacter(stringBuffer.charAt(rightIndex))) {
                        rightIndex++;
                    }
                    node = new BTreeNode(Integer.valueOf(stringBuffer.substring(index, rightIndex)));
                    index = rightIndex - 1;
                    node.lChild = node.rChild = null;
                    if (!stacks.isEmpty()) {
                        switch (childType) {
                            case LEFT:
                                stacks.peek().lChild = node;
                                break;
                            case RIGHT:
                                stacks.peek().rChild = node;
                                break;
                        }
                    }
                    break;
            }
        }

        return node;
    }

    private static void serializeTree(BTreeNode tree, StringBuffer sbBuffer) {
        if (tree == null) {
            return;
        }

        sbBuffer.append(tree.iData);
        if (tree.lChild != null || tree.rChild != null) {
            sbBuffer.append("(");
            serializeTree(tree.lChild, sbBuffer);
            if (tree.rChild != null) {
                sbBuffer.append(",");
            }
            serializeTree(tree.rChild, sbBuffer);
            sbBuffer.append(")");
        }
    }

    private static boolean ifSpecificCharacter(int charCode) {
        if (charCode == '(' || charCode == ')' || charCode == ',') {
            return true;
        } else {
            return false;
        }
    }
}
