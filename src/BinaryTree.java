

public class BinaryTree {

    private Node root = null;
    private String inOrder = "";
    private int i = 0; //index
    private int numOfNodes = 0;

    static class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }

    }

    public BinaryTree(String str) throws InvalidTreeSyntax {
        root = buildTree(root, str.replaceAll(" ", "").toCharArray());
    }

    public String inOrderTraversal() {

        if(root != null) {
            inOrder = buildInOrderString(root);
        }

        return inOrder;
    }

    private String buildInOrderString(Node node) {

        if(node.left != null) {
            traverse(node);
        }

        return inOrder;
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if(node == null) {
            return -1;
        } else {
            numOfNodes += 1;
            if(node.left != null) {
                countNodes(node.left);
            }
            if(node.right != null) {
                countNodes(node.right);
            }
        }
        return numOfNodes;
    }

    public boolean checkBalanced() {
        return checkBalanced(root);
    }
    
    private boolean checkBalanced(Node node) {
        return false;
    }

    public boolean checkFull() {
        return checkFull(root);
    }

    private boolean checkFull(Node node) {
        return false;
    }

    public boolean checkProper() {
        return checkProper(root);
    }

    private boolean checkProper(Node node) {
        return false;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {

        if(node == null) {
            return -1;
        } else {
            int leftTree = getHeight(node.left);
            int rightTree = getHeight(node.right);

            if(leftTree > rightTree) {
                return 1 + leftTree;
            } else {
                return 1 + rightTree;
            }
        }
    }

    private Node traverse(Node node) {
        if(node.left == null) {
            inOrder = inOrder + "( " + node.value + " )";
            return node;
        } else {
            inOrder = inOrder + "(";
            traverse(node.left);

            inOrder = inOrder + " "+ node.value + " ";

            if(node.right != null) {
                traverse(node.right);
            }

            inOrder = inOrder + ")";
        }

        return node;
    }

    private Node buildTree(Node node, char[] c) throws InvalidTreeSyntax {

        // (A(G(j)(1))(z(5)))

       if(c[i] != '(') {
            throw new InvalidTreeSyntax("Must start tree with (");
       } else {
           i++;
       }

       if(c[i] == '(') {
           throw new InvalidTreeSyntax("Double ( error");
       } else {
           node = new Node(c[i]);
           i++;

           if (c[i] == ')') {
               i++;
               return node;
           }

           if(c[i] != '(') {
               throw new InvalidTreeSyntax("No ( to continue tree");
           }  else {
               node.left = buildTree(node.left, c);

               if(c[i] == '(') {
                   node.right = buildTree(node.right, c);
               }
           }

           if(c[i] == ')') {
               i++;
           }
       }

        return node;
    }







}
