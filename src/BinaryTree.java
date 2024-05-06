import java.util.Stack;

public class BinaryTree {

    private Node root = null;
    private int i = 0; //index

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
        createTrees(str);
    }

    private void createTrees(String str) throws InvalidTreeSyntax {
    // (A(G(j)(1))(z(5)))
       root = buildTree(root, str.toCharArray());
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

           if(c[i] == '(') {
               node.left = buildTree(node.left, c);
           } else if (c[i] == ')') {
               i++;
               return node;
           }



       }



        return node;
    }


    private Node insertNode(String str) {

        Stack<Character> charStack = new Stack<>();

        Node temp = root;
        Node orig = null;

        int index = 0;

        while(index < str.length()) {
            char c = getCharacter(str, index);

            if(c == '(' && charStack.isEmpty()) {
                charStack.push(c);
                index++;
            } else if(c == '(' && charStack.peek() == '(') {
                charStack.push(c);
                orig = temp; //a

                if (temp.left == null) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }

                index++;

            } else if(c == ')') {
                charStack.pop();

                if(temp == orig) {
                    temp = root;
                } else {
                    temp = orig;
                }

                index++;
                continue;
            }

            if(charStack.peek() == '(') {
                c = getCharacter(str, index);
                Node newNode = new Node(c);

                if(temp == null) {
                    temp = newNode;
                    index++;
                }


            }

        }


        return temp;
    }

    private char getCharacter(String str, int index) {
        return str.charAt(index);
    }




}
