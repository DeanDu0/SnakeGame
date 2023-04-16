package com.sxt.untils;

import java.awt.*;

public class GameUtils {
    //蛇头
    public static Image upImage=Toolkit.getDefaultToolkit().getImage("src/com/sxt/image/up.png");
    public static Image downImage=Toolkit.getDefaultToolkit().getImage("src/com/sxt/image/down.png");
    public static Image leftImage=Toolkit.getDefaultToolkit().getImage("src/com/sxt/image/left.png");
    public static Image rightImage=Toolkit.getDefaultToolkit().getImage("src/com/sxt/image/right.png");
    //蛇身
    public static Image bodyImage=Toolkit.getDefaultToolkit().getImage("src/com/sxt/image/body.png");
    //食物
    public static Image foodImage=Toolkit.getDefaultToolkit().getImage("src/com/sxt/image/food.png");
    public static int level=1;
    public static void drawWord(Graphics g,String str,Color color,int size,int x,int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);

    }

}
