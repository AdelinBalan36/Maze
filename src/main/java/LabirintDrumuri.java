import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;


public class LabirintDrumuri extends JPanel {
    private Vector<Rectangle> listaRectangle;
    private int rectangleNr=1;
    private int constantWidth;
    private int constantHeight;
    private int linii, coloane;
    private int[][] myArray;

    static int dRow[] = { -1, 0, 1, 0 };
    static int dCol[] = { 0, 1, 0, -1 };

    static class pair {
        int first, second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public LabirintDrumuri() {

        listaRectangle = new Vector<>();

        try {
            File myObj = new File("fileInput.txt");
            Scanner myReader = new Scanner(myObj);
            linii = myReader.nextInt();
            //  System.out.println(linii);
            coloane = myReader.nextInt();
            // System.out.println(coloane);

            constantWidth = 1400 / coloane;
            System.out.println(constantWidth + " Lungime Coloana");
            constantHeight = 840 / linii;
            System.out.println(constantHeight + " Lungime linie ");
            myArray = new int[linii][coloane];


            int x, y = 0;
            for (int i = 0; i < linii; i++) {
                for (int j = 0; j < coloane; j++) {
                    int value = myReader.nextInt();
                    myArray[i][j] = value;
                }
            }

            boolean[][] vis = new boolean[linii][coloane];


            for (int i = 0; i < linii; i++) {
                x = 0;
                for (int j = 0; j < coloane; j++) {
                    addRectangle(x, y, myArray[i][j]);
                    x = x + constantWidth;
                }
                y = y + constantHeight;
            }

            BFS(myArray, vis, 2, 2);

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
    boolean isValid(boolean [][] vis,int row, int col,int linii,int coloane) {

        // If cell lies out of bounds
        if (row < 0 || col < 0 ||
                row >= linii || col >= coloane)
            return false;
        if(vis[row][col])
            return false;


        return true;
    }
     void BFS(int myArray[][], boolean vis[][],
                    int linieCurenta, int coloanaCurenta) {

         Queue<pair> q = new LinkedList<>();

         q.add(new pair(linieCurenta, coloanaCurenta));
         vis[linieCurenta][coloanaCurenta] = true;
         HashMap<Integer, Integer> path = new HashMap<>();


         while (!q.isEmpty()) {
             pair cell = q.peek();
             int x = cell.first;
             int y = cell.second;

             System.out.print(x + " " + y);

           /* System.out.print(x + " " + y);
            System.out.println();*/

             q.remove();

             int dRow[] = {-1, 0, 1, 0};
             int dCol[] = {0, 1, 0, -1};

             int precedent = 0;

             for (int i = 0; i < 4; i++) {
                 int adjx = x + dRow[i];
                 int adjy = y + dCol[i];

                 if (isValid(vis, adjx, adjy,linii,coloane) && (myArray[adjx][adjy] == 1 || myArray[adjx][adjy] == 2)) {
                     precedent = x * coloane + y + 1;
                     path.put(adjx * coloane + adjy + 1, precedent);

                     if (myArray[adjx][adjy] == 2) {
                         getPath(path, adjx * coloane + adjy + 1);
                     }
                     q.add(new pair(adjx, adjy));
                     vis[adjx][adjy] = true;
                 }

             }

         }
     }
    private void getPath (HashMap < Integer, Integer > path, int stanga){

        Integer dreapta = path.getOrDefault(stanga, 0);
        Rectangle rect = new Rectangle();

        rect = getRectangle(dreapta);

        if(rect.getColor()!=2)
            rect.setColor(4);

        if (dreapta != 0) {
            while (path.containsKey(dreapta)) {

                dreapta = path.getOrDefault(dreapta, 0);
                rect = getRectangle(dreapta);

                if(rect.getColor()!=2)
                    rect.setColor(4);

                System.out.println();
            }
            rect.setColor(3);
        }
    }
    private Rectangle getRectangle(int number){
         for(Rectangle rect:listaRectangle)
               if(rect.getNumber()==number)
                   return rect;
               return null;
    }
    private void addRectangle(int x,int y,int color)
    {
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
