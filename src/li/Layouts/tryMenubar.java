package li.Layouts;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
 
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
 

public class tryMenubar extends JFrame implements ActionListener{
	private JMenuBar menuBar = new JMenuBar();
    private JMenu mFile = new JMenu("File");
    private JMenuItem itemAbout = new JMenuItem("About");
    private JMenuItem itemNew = new JMenuItem("New");
    private JMenuItem itemOpen = new JMenuItem("Open");
    private JMenuItem itemSave = new JMenuItem("Save");
    private JMenuItem itemSaveAs = new JMenuItem("Save As");
 
    public tryMenubar(){
        // thÃªm cÃ¡c má»¥c menu con vÃ o menu cha lÃ  File
        mFile.add(itemNew);
        mFile.add(itemOpen);
        mFile.add(itemSave);
        mFile.add(itemSaveAs);
 
        // Táº¡o phÃ­m táº¯t cho cÃ¡c menu tÆ°Æ¡ng á»©ng
        itemNew.setMnemonic(KeyEvent.VK_N);
        itemOpen.setMnemonic(KeyEvent.VK_O);
        itemSave.setMnemonic(KeyEvent.VK_S);
        itemSaveAs.setMnemonic(KeyEvent.VK_A);
 
        // ThÃªm cÃ¡c má»¥c menu cha vÃ o menu chÃ­nh cá»§a Frame
        menuBar.add(mFile);
        menuBar.add(itemAbout);
        // RiÃªng menu cha About ta khÃ´ng thÃªm menu con vÃ o vÃ¬ má»¥c About chá»‰ cÃ³ 1 lá»±a chá»�n duy nháº¥t
 
        // ThÃªm menu chÃ­nh vÃ o Frame
        this.setJMenuBar(menuBar);
        // VÃ¬ Ä‘Ã¢y lÃ  JMenuBar nÃªn khi Ä‘áº·t menu cÃ¡c báº¡n pháº£i dÃ¹ng phÆ°Æ¡ng thá»©c setJMenuBar
 
        this.setSize(400, 300);
        this.setVisible(true);
        itemAbout.addActionListener(this);
        itemNew.addActionListener(this);
        itemOpen.addActionListener(this);
        itemSave.addActionListener(this);
        itemSaveAs.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        // báº¯t sá»± kiá»‡n theo cÃ¡ch 1
        // náº¿u chá»�n about
        if(e.getSource() == itemAbout ){
            JOptionPane.showMessageDialog(null, "Báº¡n vá»«a chá»�n About", "ThÃ´ng bÃ¡o", JOptionPane.CLOSED_OPTION);
        }
 
        // náº¿u chá»�n new
        if(e.getSource() == itemNew ){
            JOptionPane.showMessageDialog(null, "Báº¡n vá»«a chá»�n New ", "ThÃ´ng bÃ¡o", JOptionPane.CLOSED_OPTION);
        }
 
        // báº¯t sá»± kiá»‡n theo cÃ¡ch 2
        // náº¿u chá»�n Open
        if(e.getActionCommand().equalsIgnoreCase("Open") ){
            JOptionPane.showMessageDialog(null, "Báº¡n vá»«a chá»�n Open ", "ThÃ´ng bÃ¡o", JOptionPane.CLOSED_OPTION);
        }
 
        if(e.getActionCommand().equalsIgnoreCase("Save") ){
            JOptionPane.showMessageDialog(null, "Báº¡n vá»«a chá»�n Save ", "ThÃ´ng bÃ¡o", JOptionPane.CLOSED_OPTION);
        }
 
        if(e.getActionCommand().equalsIgnoreCase("Save As") ){
            JOptionPane.showMessageDialog(null, "Báº¡n vá»«a chá»�n Save As", "ThÃ´ng bÃ¡o", JOptionPane.CLOSED_OPTION);
        }
    }
 
    public static void main(String[] args) {
        new tryMenubar();
    }
}
