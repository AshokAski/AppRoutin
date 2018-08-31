package com.aski.routin;

public class Store {

    int img,img2,img3,img4;
    String item,item2,rate,rate2,date3,rate3,start1,end1;

    private Store(){}

    Store(int img ,String item,String rate){
        this.img = img;
        this.item = item;
        this.rate = rate;
    }

    Store(String item,String rate,int img){
        item2=item;
        rate2=rate;
        img2=img;
    }

    Store(int img,String date,String rate,int i){
        img3 = img;
        date3 = date;
        rate3 = rate;
    }

    Store(int img,int i,String start,String end){
        img4 = img;
        start1 = start;
        end1 = end;
    }

    public String getItem() {return item;}
    public String getItem2() {return  item2;}
    public int getImg() {return img;}
    public String getRate(){return rate;}
    public String getRate2(){return rate2;}
    public int getImg2(){return img2;}
    public int getImg3(){return img3;}
    public String getRate3() {
        return rate3;
    }
    public String getDate3() {
        return date3;
    }
    public int getImg4() {
        return img4;
    }
    public String getStart1() {
        return start1;
    }
    public String getEnd1() {
        return end1;
    }
}
