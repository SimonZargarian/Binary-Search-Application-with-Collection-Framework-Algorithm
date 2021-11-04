package com.kokabmedia;

import java.util.ArrayList;
import java.util.List;

public class TheatreTestSearch {

    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    /*
     * The constructor takes a theatre name together with number of row and the number of
     * seats per row, and it uses these values to create seats that gets stored int the arraylist
     * seats.
     */
    public TheatreTestSearch(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1);
        for (char row = 'A'; row <= lastRow; row++){
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                Seat seat = new Seat(row + String.format("%2d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName(){
        return theatreName;
    }

    // Method for reserving a seat
    public boolean reserveSeat(String seatNumber){

        // The algorithm for Collections compareTo() method binary search
        int low =0;
        int high = seats.size();

        while (low <= high){
            System.out.print("."); // For performance testing purposes.
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0){
                low = mid + 1;
            }else if (cmp > 0) {
                high = mid - 1;
            }else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return false;

        /*
         * Use a Collections to access the binarySearch() method with the Comparable interface
         * in the Seat class and the compareTo() method.
         */
         /*Seat requestedSeat = new Seat(seatNumber); // new object for comparable purposes

        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);

        if(foundSeat >= 0){
            return seats.get(foundSeat).reserve();
        }else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }*/

        // The code below represents bruteforce search
       /* for(Seat seat : seats){
            System.out.print("."); // For performance testing purposes.
            if(seat.getSeatNumber().equals(seatNumber)){
                requestedSeat = seat;
                break;
            }
        }
        if(requestedSeat == null){
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
        return requestedSeat.reserve();*/

    }

    // For testing purposes
    public void getSeats(){
        for(Seat seat : seats){
            System.out.println(seat.getSeatNumber());
        }
    }

    /*
     * Seat Implements the Comparable interface to perform binary search
     * with compareTo() method.
     */
    private class Seat implements Comparable<Seat>{

        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            // Compares hard coded seat number from constructor to seat number in list
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        // Method checks if seat is reserved
        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return  true;
            }else{
                return false;
            }
        }

        // Method for canceling a seat
        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " has been cancelled");
                return true;
            }else{
                return false;
            }
        }

        public String getSeatNumber(){
            return seatNumber;
        }
    }
}





