package com.kokabmedia;

public class Main {

    public static void main(String[] args) {

        TheatreTestSearch theatre = new TheatreTestSearch("SF", 8, 12);
        //theatre.getSeats();
        /*
        * The code below is for performance testing purposes the goal is to produce
        * a optimized search result algorithm.
        */
        if(theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        }else{
            System.out.println("Sorry seat is taken");
        }
        if(theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        }else{
            System.out.println("Sorry seat is taken");
        }



    }
}
