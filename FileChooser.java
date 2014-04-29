import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.SwingUtilities;

public class FileChooser extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	 static private final String newline = "\n";
	    JButton openButton,convertButton;
	    JTextArea log;
	    JTextField   textfield  = new JTextField(25);
	  //Create a file chooser
        JFileChooser fc = new JFileChooser();
        
    public FileChooser() {
        super(new BorderLayout());
 
       
        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);
      
        
        //Create the open button
        openButton = new JButton("Open");
        openButton.addActionListener(this);
 
        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        
       //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(textfield);
        buttonPanel.add(convertButton);
        //In response to a button click:
                 
        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }
    
    public void actionPerformed(ActionEvent e) {
    	
    	if (e.getSource() == openButton) {
    	        int returnVal = fc.showOpenDialog(FileChooser.this);

    	        if (returnVal == JFileChooser.APPROVE_OPTION) {
    	        	File file = fc.getSelectedFile();
    	        	
    	        	textfield.setText(file.getName());
    	        	
    	            log.append("Opening: " + file.getName() + "." + newline);
    	        } else {
    	            log.append("Open command cancelled by user." + newline);
    	        }
    	   }
    	
    	if (e.getSource() == convertButton) {
    		
    		XMLConvertor1 parser = new XMLConvertor1();
    		parser.getAllUserNames(fc.getSelectedFile());
    		log.append("Done!!" + newline);  
	   }
    } 
    
 
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame(" Parser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add content to the window.
        frame.add(new FileChooser());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
	public static void main(String[] args) {
		    SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}
