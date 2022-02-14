

import java.awt.*;

public class Rectangle {

    private int coordX;
    private int coordY;
    private int number;
    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    public void Rectangle(){
            coordX=0;
            coordY=0;
            number=0;
            color=-1;
    }
    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Rectangle(){
        coordX=0;
        coordY=0;
    }
    public Rectangle(int x,int y,int number,int color){
        coordX=x;
        coordY=y;
        this.number=number;
        this.color=color;
    }
    public void drawRect(Graphics g,int color,int constantWidth,int constantHeight)
    {
          if(color==2) {
              g.setColor(Color.RED);
              g.setFont(new Font("TimesRoman", Font.BOLD, 15));
              g.fillRect(coordX, coordY, constantWidth, constantHeight);
              g.setColor(Color.BLACK);
              g.drawRect(coordX, coordY, constantWidth, constantHeight);
          }
          else if(color==0)
          {
              g.setColor(Color.GRAY);
              g.setFont(new Font("TimesRoman", Font.BOLD, 15));
              g.fillRect(coordX, coordY, constantWidth, constantHeight);
              g.setColor(Color.BLACK);
              g.drawRect( coordX,coordY, constantWidth, constantHeight );
          }
          else if(color==1)
          {
              g.setColor(Color.WHITE);
              g.setFont(new Font("TimesRoman", Font.BOLD, 15));
              g.fillRect(coordX, coordY, constantWidth, constantHeight);
              g.setColor(Color.BLACK);
              g.drawRect( coordX,coordY, constantWidth, constantHeight );
          }
          else if(color==3) {
              g.setColor(Color.BLUE);
              g.setFont(new Font("TimesRoman", Font.BOLD, 15));
              g.fillRect(coordX, coordY, constantWidth, constantHeight);
              g.setColor(Color.BLACK);
              g.drawRect(coordX, coordY, constantWidth, constantHeight);

          }
          else if(color==4){
              g.setColor(Color.GREEN);
              g.setFont(new Font("TimesRoman", Font.BOLD, 15));
              g.fillRect(coordX, coordY, constantWidth, constantHeight);
              g.setColor(Color.BLACK);
              g.drawRect(coordX, coordY, constantWidth, constantHeight);
          }
    }
}
