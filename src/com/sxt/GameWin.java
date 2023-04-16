package com.sxt;

import com.sxt.obj.BodyObj;
import com.sxt.obj.FoodObj;
import com.sxt.obj.HeadObj;
import com.sxt.untils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GameWin extends JFrame {
    int winWidth=800;
    int winHeight=600;
    public  int score=0;
    //��Ϸ��״̬ 0δ��ʼ 1��Ϸ�� 2��ͣ 3ʧ�� 4ͨ�� 5ʧ�ܺ�����
    public static int status=0;
    Image offScreenImage=null;
    HeadObj headObj=new HeadObj(GameUtils.rightImage,60,570,this);
    public FoodObj foodObj=new FoodObj().getFoodObj();
    public List<BodyObj>  bodyObjList=new ArrayList<>();
    public void launch(){
        //���ô����Ƿ�ɼ�
        this.setVisible(true);
        //���ô��ڴ�С
        this.setSize(winWidth,winHeight);
        //���ô��ڵ�λ������Ļ�Ͼ���
        this.setLocationRelativeTo(null);
        //���ô��ڵı���
        this.setTitle("Dean��s̰����");
        //����ĳ�ʼ��
        bodyObjList.add(new BodyObj(GameUtils.bodyImage,30,570,this));
        bodyObjList.add(new BodyObj(GameUtils.bodyImage,0,570,this));
        //��Ӽ��̼���¼�
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    switch(status){
                        case 0:
                            status=1;
                            break;
                        case 1:
                            status=2;
                            repaint();
                            break;
                        case 2:
                            status=1;
                            break;
                        case 3:
                            status=5;
                        case 4:
                            status=6;
                            break;
                        default:
                            break;

                    }
                }
            }
        });

        while(true){
            if(status==1){
                repaint();
            }
            if(status==5){
                status=0;
                resetGame();
            }
            if(status==6&&GameUtils.level!=3){
                status=1;
                GameUtils.level++;
                resetGame();
            }
            try{
                Thread.sleep(200);

            }catch(InterruptedException i){
                i.printStackTrace();
            }

        }
    }
    public void paint(Graphics g){
        if(offScreenImage==null){
            offScreenImage=this.createImage(winWidth,winHeight);
        }
        Graphics gImage=offScreenImage.getGraphics();
        //��ɫ����
        gImage.setColor(Color.gray);
        gImage.fillRect(0,0,winWidth,winHeight);
        gImage.setColor(Color.BLACK);
        for(int i=0;i<=20;i++){
            gImage.drawLine(0,i*30,600,i*30);
            gImage.drawLine(i*30,0,i*30,600);
        }
        //��������
        for(int i=bodyObjList.size()-1;i>=0;i--){
            bodyObjList.get(i).paintSelf(gImage);
        }
        //������ͷ
        headObj.paintSelf(gImage);
        foodObj.paintSelf(gImage);
        GameUtils.drawWord(gImage,"��"+GameUtils.level+"��",Color.yellow,50,640,250);
        GameUtils.drawWord(gImage,score+"��",Color.BLUE,50,650,300);
        gImage.setColor(Color.gray);
        prompt(gImage);
        g.drawImage(offScreenImage,0,0,null);

    }
    void prompt(Graphics g){
        if(status==0){
            g.fillRect(120,240,400,70);
            GameUtils.drawWord(g,"���¿ո����ʼ��Ϸ",Color.yellow,35,150,290);
        }
        if(status==2){
            g.fillRect(120,240,400,70);
            GameUtils.drawWord(g,"���¿ո��������Ϸ",Color.green,35,150,290);

        }
        if(status==3){
            g.fillRect(120,240,400,70);
            GameUtils.drawWord(g,"ҧ���Լ�,��Ϸʧ�ܵ���ո����¿�ʼ",Color.red,35,150,290);

        }
        if(status==4){
            g.fillRect(120,240,400,70);
            if(GameUtils.level==3){
                GameUtils.drawWord(g,"�����������Ϸͨ��",Color.green,35,150,290);
            }else{
                GameUtils.drawWord(g,"������������¿ո������һ��",Color.green,35,150,290);
            }


        }
    }
    void resetGame(){
        this.dispose();
        String[] args={};
        main(args);

    }
    public static void main(String[] args){
        GameWin gameWin=new GameWin();

        gameWin.launch();
    }
}
