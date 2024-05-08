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

        this.setSize(700, 200);
        this.setTitle("Binary Tree Categorizer");

        //Panels for organizing each section of the GUI
        inputLine = new JPanel();
        buttonLine = new JPanel();
        outputLine = new JPanel();

        enterTree = new JLabel("Enter Tree:");
        inputLine.add(enterTree);

        treeEntry = new JTextField();
        treeEntry.setPreferredSize(new Dimension(100, 20));
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

        makeTree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    binaryTree = new BinaryTree(treeEntry.getText());
                } catch (InvalidTreeSyntax ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        showInOrder.addActionListener(e -> {
            output.append(binaryTree.inOrderTraversal());
        });


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }

}
