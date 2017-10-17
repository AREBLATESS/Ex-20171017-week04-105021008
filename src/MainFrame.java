import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame{
    private Container cp;
    private TextField Jtf = new TextField();
    JButton jbtn[] = new JButton[9];
    JPanel jpn = new JPanel(new GridLayout(3,3));
    public MainFrame(){
        initComp();
    }
    LoginFrame lgf;
    public MainFrame(LoginFrame lFrm){
        lgf=lFrm;
        initComp();
    }

    private void initComp(){
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        this.setBounds(100,100,400,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp.add(Jtf,BorderLayout.NORTH);
        cp.add(jpn,BorderLayout.CENTER);



        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                lgf.setVisible(true);
            }
        });

            for(int i = 0; i < 9 ; i++){
                jbtn[i] = new JButton(Integer.toString(i));
                jpn.add(jbtn[i]);
                jbtn[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tembtn = (JButton)e.getSource();
                        Jtf.setText(Jtf.getText()+tembtn.getText());
                    }
                });

            }


    }
}
