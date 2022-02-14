

import java.awt.*;

public class Node {

     private int coordX;
     private int coordY;
     private int nodeNumber;
     private int color;
    public Node(){
        this.coordX =0;
        this.coordY =0;
        this.nodeNumber =0;
        this.color=-1;
    }
    public Node(int x, int y, int nodeNumber,int color) {
        this.coordX = x;
        this.coordY = y;
        this.nodeNumber = nodeNumber;
        this.color=color;
    }

    public int getX() {
        return coordX;
    }

    public int getY() {
        return coordY;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public void setX(int x) {
        this.coordX = x;
    }

    public void setY(int y) {
        this.coordY = y;
    }

    public void setNodeNumber(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void drawNode(Graphics g, int node_diam, int color)
    {   //coordX+node_diam/2, coordY+node_diam/2, node_diam, node_diam
        //coordX-node_diam/2, coordY-node_diam/2,node_diam, node_diam
        /* if(nodeNumber < 10)
            g.drawString(((Integer)nodeNumber).toString(), coordX-node_diam/2+5, coordY+node_diam/2-5);
         else
            g.drawString(((Integer)nodeNumber).toString(), coordX-node_diam/2+2, coordY+node_diam/2-5);*/
        if (color == 0) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("TimesRoman", Font.BOLD, 15));
            g.fillOval(coordX+node_diam/2, coordY+node_diam/2, node_diam, node_diam);
            g.setColor(Color.BLACK);
            g.drawOval(coordX+node_diam/2, coordY+node_diam/2,node_diam, node_diam);
            if(nodeNumber < 10)
                g.drawString(((Integer)nodeNumber).toString(), coordX+node_diam/2, coordY+node_diam/2);
            else
                g.drawString(((Integer)nodeNumber).toString(), coordX+node_diam/2, coordY+node_diam/2);

        }else if (color==1){
            g.setColor(Color.WHITE);
            g.setFont(new Font("TimesRoman", Font.BOLD, 15));
            g.fillOval(coordX+node_diam/2, coordY+node_diam/2, node_diam, node_diam);
            g.setColor(Color.BLACK);
            g.drawOval(coordX+node_diam/2, coordY+node_diam/2, node_diam, node_diam);
            if(nodeNumber < 10)
                g.drawString(((Integer)nodeNumber).toString(), coordX+node_diam/2, coordY+node_diam/2);
            else
                g.drawString(((Integer)nodeNumber).toString(), coordX+node_diam/2, coordY+node_diam/2);
        }else if(color==2){
            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.BOLD, 15));
            g.fillOval(coordX+node_diam/2, coordY+node_diam/2, node_diam, node_diam);
            g.setColor(Color.BLACK);
            g.drawOval(coordX+node_diam/2, coordY+node_diam/2, node_diam, node_diam);
            if(nodeNumber < 10)
                g.drawString(((Integer)nodeNumber).toString(), coordX+node_diam/2, coordY+node_diam/2);
            else
                g.drawString(((Integer)nodeNumber).toString(), coordX+node_diam/2, coordY+node_diam/2);
        }else if(color==3) {
            g.setColor(Color.BLUE);
            g.setFont(new Font("TimesRoman", Font.BOLD, 15));
            g.fillOval(coordX+node_diam/2, coordY+node_diam/2, node_diam, node_diam);
            g.setColor(Color.BLACK);
            g.drawOval(coordX+node_diam/2, coordY+node_diam/2, node_diam, node_diam);
            if(nodeNumber < 10)
                g.drawString(((Integer)nodeNumber).toString(), coordX+node_diam/2, coordY+node_diam/2);
            else
                g.drawString(((Integer)nodeNumber).toString(), coordX+node_diam/2, coordY+node_diam/2);
        }
        else if(color==4) {
            g.setColor(Color.GREEN);
            g.setFont(new Font("TimesRoman", Font.BOLD, 15));
            g.fillOval(coordX+node_diam/2, coordY+node_diam/2, node_diam, node_diam);
            g.setColor(Color.BLACK);
            g.drawOval(coordX+node_diam/2, coordY+node_diam/2, node_diam, node_diam);
            if(nodeNumber < 10)
                g.drawString(((Integer)nodeNumber).toString(), coordX+node_diam/2, coordY+node_diam/2);
            else
                g.drawString(((Integer)nodeNumber).toString(), coordX+node_diam/2, coordY+node_diam/2);
        }
    }

}
