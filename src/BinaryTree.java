import java.util.Stack;

public class BinaryTree {

    private Node root = null;

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

    public BinaryTree(String str) {
        createTrees(str);
    }

    private void createTrees(String str) {
    // (A(G(j)(1))(z(5)))
       root = insertNode(str);
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
                if (temp != null) {
                    temp = temp.left;
                }
                index++;

            } else if(c == ')') {
                charStack.pop();
                temp = orig;
                index++;
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
