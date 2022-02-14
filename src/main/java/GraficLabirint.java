import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraficLabirint {
    private static void initUI() {

        JFrame f = new JFrame("Algoritmica Grafurilor");
        //sa se inchida aplicatia atunci cand inchid fereastra

        final Label text = new Label();
        text.setAlignment(Label.CENTER);
        text.setSize(400, 100);

        Button buton = new Button("Choose the Graph");
        buton.setBounds(320, 150, 100, 21);

        final Choice c = new Choice();
        c.setBounds(100, 150, 200, 250);
        c.add("Labirint");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //adaug in frame
        f.add(c);
        f.add(text);
        f.add(buton);


        //setez dimensiunea ferestrei
        f.setSize(600, 600);
        f.setLayout(null);

        //fac fereastra vizibila
        f.setVisible(true);
        buton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c.getSelectedItem()=="Labirint" ){
                    JFrame f = new JFrame("Tabela labirint");
                    // sa se inchida aplicatia atunci cand inchid fereastra

                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // imi creez ob MyPanel
                    Button buton = new Button("Select");
                    buton.setBounds(1450, 300, 100, 21);

                    final Choice c = new Choice();
                    c.setBounds(1410, 150, 150, 100);
                    c.add("Show paths nodes");
                    c.add("Show me the graph!");
                    f.add(c);

                    f.add(buton);
                    f.add(new Implement() );


                    // setez dimensiunea ferestrei

                    f.setSize(1600, 880);
                    // fac fereastra vizibila
                    f.setVisible(true);
                    buton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(c.getSelectedItem()=="Show paths nodes" ){
                                JFrame f = new JFrame("Tabela labirint");
                                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                f.add(new LabirintDrumuri() );
                                f.setSize(1600, 880);
                                f.setVisible(true);
                            }
                            else if(c.getSelectedItem()=="Show me the graph!" ){
                                JFrame f = new JFrame("Tabela labirint");
                                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                f.add(new LabirintGraf() );
                                f.setSize(1600, 880);
                                f.setVisible(true);
                            }

                        }

                    });
                }
            }
        });
    }

    public static void main(String[] args)
    {
        //pornesc firul de executie grafic
        //fie prin implementarea interfetei Runnable, fie printr-un ob al clasei Thread
        SwingUtilities.invokeLater(new Runnable() //new Thread()
        {
            public void run()
            {
                initUI();
            }
        });
    }
}