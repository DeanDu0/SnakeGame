package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.untils.GameUtils;

import java.awt.*;
import java.util.Random;

public class FoodObj extends GameObj{
    public FoodObj(){

    }
    public FoodObj(Image image, int x, int y, GameWin frame){
        super(image, x, y, frame);
    }
    Random r=new Random();
    public FoodObj getFoodObj(){
        return new FoodObj(GameUtils.foodImage,r.nextInt(20)*30,(r.nextInt(19)+1)*30,this.frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
    }
}
