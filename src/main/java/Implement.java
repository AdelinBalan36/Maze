import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Implement extends JPanel {
    private Vector<Rectangle> listaRectangle;
    private int rectangleNr=1;
    private int constantWidth;
    private int constantHeight;
    private int[][] myArray;

    public Implement() {
        listaRectangle = new Vector<Rectangle>();
        Vector<String> objects = new Vector<>();


        try {
            File myObj = new File("fileInput.txt");
            Scanner myReader = new Scanner(myObj);
            int linii = myReader.nextInt();
            //  System.out.println(linii);
            int coloane = myReader.nextInt();
            // System.out.println(coloane);

            constantWidth = 1400 / coloane;
            System.out.println(constantWidth + " Lungime Coloana");
            constantHeight = 840 / linii;
            System.out.println(constantHeight + " Lungime linie ");
            myArray = new int[linii][coloane];


            int x , y=0 ;
            for (int i = 0; i < linii; i++) {
                for (int j = 0; j < coloane; j++) {
                    int value = myReader.nextInt();
                    myArray[i][j] = value;
                }
            }
            for (int i = 0; i < linii; i++) {
                x=0;
                for (int j = 0; j < coloane; j++) {
                    addRectangle(x,y,myArray[i][j]);
                    x=x+constantWidth;
                }
                y=y+constantHeight;
            }

            myReader.close();
        } catch(FileNotFoundException e)
    {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }


}
      private void addRectangle(int x,int y,int color) {
            Rectangle rect= new Rectangle(x,y,rectangleNr,color);
            rectangleNr++;
            listaRectangle.add(rect);
      repaint();
      }
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);// apelez metoda paintComponent din clasa de baza

        // deseneaza arcele existente in lista
        for(Rectangle rect:listaRectangle)
              rect.drawRect(g,rect.getColor(),constantWidth,constantHeight);

    }
}



