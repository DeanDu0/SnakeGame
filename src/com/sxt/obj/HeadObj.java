package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.untils.GameUtils;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class HeadObj extends GameObj{
    private String direction="right";
    public String getDirection(){
        return direction;
    }

    public void setDirection(String direction){
        this.direction=direction;

    }

    public HeadObj(Image image, int x,int y, GameWin frame){
        super(image,x,y,frame);
        this.frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                changeDirection(e);
            }
        });
    }
    public void changeDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                if(!"down".equals(direction)){
                    direction="up";
                    image= GameUtils.upImage;
                }
                break;
            case KeyEvent.VK_S:
                if(!"up".equals(direction)){
                    direction="down";
                    image= GameUtils.downImage;
                }
                break;
            case KeyEvent.VK_A:
                if(!"right".equals(direction)){
                    direction="left";
                    image= GameUtils.leftImage;
                }
                break;
            case KeyEvent.VK_D:
                if(!"left".equals(direction)){
                    direction="right";
                    image= GameUtils.rightImage;
                }
                break;
            default:
                break;
        }
    }
    public void move (){
        List<BodyObj> bodyObjList=this.frame.bodyObjList;
        for(int i=bodyObjList.size()-1;i>=1;i--){
            bodyObjList.get(i).x=bodyObjList.get(i-1).x;
            bodyObjList.get(i).y=bodyObjList.get(i-1).y;
            if(this.x==bodyObjList.get(i).x&&this.y==bodyObjList.get(i).y){
                this.frame.status=3;
            }
        }
        bodyObjList.get(0).x=this.x;
        bodyObjList.get(0).y=this.y;
        switch(direction){
            case"up":
                y-=height;
                break;
            case"down":
                y+=height;
                break;
            case"left":
                x-=width;
                break;
            case"right":
                x+=width;
                break;
            default:
                break;

        }
    }


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        FoodObj food=this.frame.foodObj;
        Integer newX=null;
        Integer newY=null;
        if(this.x==food.x && this.y==food.y){
            this.frame.foodObj=food.getFoodObj();
            BodyObj lastbody=this.frame.bodyObjList.get(this.frame.bodyObjList.size()-1);
            newX= lastbody.x;
            newY= lastbody.y;
            this.frame.score++;
        }
        if(this.frame.score>=10){
            GameWin.status=4;
        }
        move();
        if(newX!=null&&newY!=null){
            this.frame.bodyObjList.add(new BodyObj(GameUtils.bodyImage,newX,newY,this.frame));
        }
        if(x<0){
            x=570;
        } else if (x>570) {
            x=0;
        } else if (y<30) {
            y=570;
        } else if (y>570) {
            y=30;

        }
    }
}
