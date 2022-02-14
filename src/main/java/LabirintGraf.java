import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LabirintGraf extends JPanel {
    private int nodeNr=1;
    private int node_diam = 80;
    private Vector<Node> listaNoduri;
    private Vector<Arc> listaArce;
    private int constantWidth;
    private int constantHeight;
    private int[][] myArray;

    static class pair {
        int first, second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public LabirintGraf() {

         listaNoduri=new Vector<>();
         listaArce=new Vector<>();

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
                x=0;
                for (int j = 0; j < coloane; j++) {
                    int value = myReader.nextInt();
                    myArray[i][j] = value;
                    addNode(x, y, myArray[i][j]);
                    x=x+constantWidth;
                }
                y=y+constantHeight;
            }
               boolean vis[][];
               vis=new boolean[linii][coloane];
               BFS(myArray,vis,2,2,linii,coloane);

               myReader.close();
             } catch(FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    Point returnPoint(int i,int j) {
        Point nodePoint=new Point();
         for(Node node:listaNoduri)
              if((node.getX())/constantWidth==j && (node.getY())/constantHeight==i ){
                   nodePoint.setLocation(node.getX()+node_diam,node.getY()+node_diam);
              }
         if (nodePoint.x !=0 && nodePoint.y !=0)
            return nodePoint;
         return null;
    }

    boolean isValid(boolean [][] vis,int row, int col,int linii,int coloane) {

        // If cell lies out of bounds
        if (row < 0 || col < 0 ||
                row >= linii || col >= coloane)
            return false;
        if(vis[row][col])
            return false;

        // Otherwise
        return true;
    }
    void BFS(int myArray[][], boolean vis[][],
             int linieCurenta, int coloanaCurenta,int linii,int coloane) {

        Queue<pair> q = new LinkedList<>();

        q.add(new pair(linieCurenta, coloanaCurenta));
        vis[linieCurenta][coloanaCurenta] = true;
        HashMap<Integer, Integer> path = new HashMap<>();

        while (!q.isEmpty()) {
            pair cell = q.peek();
            int x = cell.first;
            int y = cell.second;

           /* System.out.print(x + " " + y);
            System.out.println();*/

            q.remove();

            int dRow[] = {-1, 0, 1, 0};
            int dCol[] = {0, 1, 0, -1};

            int precedent = 0;
            for (int i = 0; i < 4; i++) {
                int adjx = x + dRow[i];
                int adjy = y + dCol[i];

                if (isValid(vis, adjx, adjy, linii, coloane) && (myArray[adjx][adjy] == 1 || myArray[adjx][adjy] == 2)) {
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


            Node node = new Node();

            node = getNode(dreapta);

            if(node.getColor()!=2)
                node.setColor(4);

            if (dreapta != 0) {
                while (path.containsKey(dreapta)) {


                    dreapta = path.getOrDefault(dreapta, 0);
                    node = getNode(dreapta);

                    if(node.getColor()!=2)
                        node.setColor(4);

                  //  System.out.println();
                }
                node.setColor(3);
            }
          /*  Integer dreapta = path.getOrDefault(stanga, 0);

            Point inceput = new Point();
            Point sfarsit = new Point();

            Node node = new Node();

            int node1;
            int node2;

            node = getNode(dreapta);

            if(node.getColor()!=2)
                node.setColor(4);

            inceput.setLocation(node.getX() + node_diam, node.getY() + node_diam);

            System.out.println(node.getX()+" "+ node.getY());

            //  System.out.println(path);
            //  System.out.print(precedent + " ");

            if (dreapta != 0) {
                while (path.containsKey(dreapta)) {

                    node1 = node.getNodeNumber();
                    dreapta = path.getOrDefault(dreapta, 0);

                    node = getNode(dreapta);

                    node2 = node.getNodeNumber();
                   if(node.getColor()!=2)
                       node.setColor(4);

                    sfarsit.setLocation(node.getX() + node_diam, node.getY() + node_diam);

                  //System.out.println(node.getX()+" "+ node.getY());

                    if (sfarsit != null) {

                      //  addArc(inceput, sfarsit, node1, node2);

                    }
                    inceput.setLocation(sfarsit);
                    System.out.println();
                }
                node.setColor(3);
            }*/
    }

    private Node getNode(int number) {
    for(Node node: listaNoduri)
        if(node.getNodeNumber()==number)
            return node;
        return null;
}
    private void addArc(Point a, Point b,int inceput, int sfarsit) {
        Arc arc=new Arc(a,b,inceput,sfarsit);
        listaArce.addElement(arc);

    }


    private void addNode(int x, int y,int number) {
        boolean ok = true;
        for (int i = 0; i < listaNoduri.size(); i++) {

            if (Math.abs(listaNoduri.get(i).getX() - x) < node_diam
                    && Math.abs(listaNoduri.get(i).getY() - y) < node_diam)
                ok = false;
        }
        if (ok) {
            Node node = new Node(x, y, nodeNr,number);
            listaNoduri.add(node);
            nodeNr++;
            repaint();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponents(g);// apelez metoda paintComponent din clasa de baza
        g.drawString("This is my Graph!", 10, 20);

        // deseneaza arcele existente in lista
        //System.out.println(listaArce.size());
        for (int i = 0; i < listaNoduri.size(); i++) {
            listaNoduri.elementAt(i).drawNode(g, node_diam,listaNoduri.elementAt(i).getColor());
        }
         /*   for (Arc a : listaArce) {
           a.drawArc(g, a.getStart(), a.getEnd());
         }*/
        //System.out.println(listaArce.size());
        // deseneaza arcul curent; cel care e in curs de desenare
        // System.out.println(returnPoint(0,0).getX()+ " "+ returnPoint(0,0).getY());
        // deseneaza lista de noduri
        /*  for (int i = 0; i < listaNoduri.size(); i++) {
           System.out.println(listaNoduri.elementAt(i).getX()+" "+ listaNoduri.elementAt(i).getY());
         }*/

        int count=1;
        // deseneaza arcele existente in lista
        /* for(Rectangle rect:labirint.listaRectangle)
            rect.drawRect(g,rect.getNumber(),labirint.constantWidth,labirint.constantHeight);*/

    }
}