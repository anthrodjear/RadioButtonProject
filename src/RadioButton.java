import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class RadioButton extends JFrame{
    private final JLabel imageLabel;
    public RadioButton(){
        setTitle("AnimalRadioButton");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));
        setResizable(true);

        //left panel for radio buttons
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        //Image Label in the center
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setPreferredSize(new Dimension(300,300));

        //Create radio Button
        JRadioButton falconButton = new JRadioButton("Falcon");
        JRadioButton horseButton = new JRadioButton("Horse");
        JRadioButton tigerButton = new JRadioButton("Tiger");
        JRadioButton doveButton = new JRadioButton("Dove");
        JRadioButton lionButton = new JRadioButton("Lion");
        JRadioButton snakeButton = new JRadioButton("Snake");
        JRadioButton elephantButton = new JRadioButton("Elephant");
        JRadioButton pantherButton = new JRadioButton("Panther");

        //Group only one to be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(falconButton);
        group.add(horseButton);
        group.add(tigerButton);
        group.add(doveButton);
        group.add(lionButton);
        group.add(snakeButton);
        group.add(elephantButton);
        group.add(pantherButton);

        //Add to left panel
        leftPanel.add(falconButton);
        leftPanel.add(Box.createVerticalStrut(8));
        leftPanel.add(horseButton);
        leftPanel.add(Box.createVerticalStrut(8));
        leftPanel.add(tigerButton);
        leftPanel.add(Box.createVerticalStrut(8));
        leftPanel.add(doveButton);
        leftPanel.add(Box.createVerticalStrut(8));
        leftPanel.add(lionButton);
        leftPanel.add(Box.createVerticalStrut(8));
        leftPanel.add(snakeButton);
        leftPanel.add(Box.createVerticalStrut(8));
        leftPanel.add(elephantButton);
        leftPanel.add(Box.createVerticalStrut(8));
        leftPanel.add(pantherButton);
        leftPanel.add(Box.createVerticalStrut(8));

        //Register a single ActionListener for all
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pet = e.getActionCommand();

                //loading images
                ImageIcon icon = loadScaledIcon("images/" + pet.toLowerCase() + ".jpg",280,280);
                imageLabel.setIcon(icon);

                //massage box showing
                JOptionPane.showMessageDialog(RadioButton.this,
                        "You Selected: " + pet,
                        "Selection",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        };

        //Set action command and listeners
        falconButton.setActionCommand("Falcon");
        horseButton.setActionCommand("Horse");
        tigerButton.setActionCommand("Tiger");
        doveButton.setActionCommand("Dove");
        lionButton.setActionCommand("Lion");
        snakeButton.setActionCommand("Snake");
        elephantButton.setActionCommand("Elephant");
        pantherButton.setActionCommand("Panther");

        falconButton.addActionListener(listener);
        horseButton.addActionListener(listener);
        tigerButton.addActionListener(listener);
        doveButton.addActionListener(listener);
        lionButton.addActionListener(listener);
        snakeButton.addActionListener(listener);
        elephantButton.addActionListener(listener);
        pantherButton.addActionListener(listener);

        //Default selection
        doveButton.setSelected(true);
        imageLabel.setIcon(loadScaledIcon("images/dove.jpg",280,280));

        //Add panels to frame
        add(leftPanel,BorderLayout.WEST);
        add(imageLabel,BorderLayout.CENTER);

        pack();
        setSize(600,380);
        setLocationRelativeTo(null);
    }
//loading image from file
    private ImageIcon loadScaledIcon(String path, int width, int height){
        try {
            File f=new File(path);
            Image img;
            if (f.exists()) {
                img=new ImageIcon(f.getAbsolutePath()).getImage();
            }else{
                URL res=getClass().getResource("/" + path);
                if (res!=null){
                    img=new ImageIcon(res).getImage();
                }else {
                    return new ImageIcon(new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB));
                }
            }
            Image scaled =img.getScaledInstance(width,height,Image.SCALE_SMOOTH);
            return new ImageIcon(scaled);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ImageIcon(new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB));
        }
    }
    static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            RadioButton radioButton = new RadioButton();
            radioButton.setVisible(true);
        });
    }
}