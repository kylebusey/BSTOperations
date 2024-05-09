import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    BinaryTree binaryTree;

    private JLabel enterTree;
    private JTextField treeEntry; //text entry

    private JButton makeTree;
    private JButton isBalanced;
    private JButton isFull;
    private JButton isProper;
    private JButton height;
    private JButton showNodes;
    private JButton showInOrder;

    private JLabel outputLabel;
    private JTextArea output; //Output line, should not be able to be edited

    private JPanel inputLine;
    private JPanel buttonLine;
    private JPanel outputLine;

    public GUI() {

        this.setSize(750, 200);
        this.setTitle("Binary Tree Categorizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panels for organizing each section of the GUI
        inputLine = new JPanel();
        buttonLine = new JPanel();
        outputLine = new JPanel();

        enterTree = new JLabel("Enter Tree:");
        inputLine.add(enterTree);

        treeEntry = new JTextField();
        treeEntry.setPreferredSize(new Dimension(120, 20));
        inputLine.add(treeEntry);

        //add input line to the top of the GUI
        this.add(inputLine, BorderLayout.NORTH);

        //Initialize buttons for button line
        makeTree = new JButton("Make Tree");
        buttonLine.add(makeTree);

        isBalanced = new JButton("Is Balanced?");
        buttonLine.add(isBalanced);

        isProper = new JButton("Is Proper?");
        buttonLine.add(isProper);

        isFull = new JButton("Is Full?");
        buttonLine.add(isFull);

        height = new JButton("Height");
        buttonLine.add(height);

        showNodes = new JButton("Nodes");
        buttonLine.add(showNodes);

        showInOrder = new JButton("Inorder");
        buttonLine.add(showInOrder);

        this.add(buttonLine, BorderLayout.CENTER);

        //Start of bottom output line
        outputLabel = new JLabel("Output:");
        outputLine.add(outputLabel);

        output = new JTextArea();
        output.setEditable(false);
        output.setPreferredSize(new Dimension(200, 20));
        outputLine.add(output);

        this.add(outputLine, BorderLayout.SOUTH);

        this.setVisible(true);

        makeTree.addActionListener(e -> {
            try {
                binaryTree = new BinaryTree(treeEntry.getText());
                output.setText("Binary Tree Created");

            } catch (InvalidTreeSyntax ex) {
                throw new RuntimeException(ex);
            }
        });

        //In Order Button to build inOrder String
        showInOrder.addActionListener(e -> {
            output.setText(binaryTree.inOrderTraversal());
        });

        //Height of Tree
        height.addActionListener(e -> {
            output.setText(String.valueOf(binaryTree.getHeight()));
        });

        //Number of nodes in tree
        showNodes.addActionListener(e -> {
            output.setText(String.valueOf(binaryTree.countNodes()));
        });

        //Check if tree is balanced
        isBalanced.addActionListener(e -> {
            output.setText(String.valueOf(binaryTree.checkBalanced()));
        });

        //Check if tree is full
        isFull.addActionListener(e -> {
            output.setText(String.valueOf(binaryTree.checkFull()));
        });

        //Check if tree is proper
        isProper.addActionListener(e -> {
            output.setText(String.valueOf(binaryTree.checkProper()));
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }

}
