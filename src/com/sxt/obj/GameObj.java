package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;

public class GameObj {
    //图片
    Image image;
    int x;
    int y;
    int width=30;
    int height=30;
    //窗口类的引用
    GameWin frame;
    public Image getImage(){
        return image;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public GameWin getFrame(){
        return frame;
    }


    public void setImage(Image image){
        this.image=image;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setWidth(int width){
        this.width=width;
    }
    public void setHeight(int height){
        this.height=height;
    }
    public void setFrame(GameWin frame){
        this.frame=frame;
    }
    public GameObj(){

    }
    public GameObj(Image image,int x,int y,GameWin frame){
        this.image=image;
        this.x=x;
        this.y=y;
        this.frame=frame;

    }
    public GameObj(Image image,int x,int y,int width,int height,GameWin frame){
        this.image=image;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.frame=frame;

    }
    public void paintSelf(Graphics g){
        g.drawImage(image,x,y,null);

    }






}
