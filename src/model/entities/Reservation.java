package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Contrutor
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // Getters e setters
    public Integer getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber( Integer roomNumber ) {
        this.roomNumber = roomNumber;
    }
    public Date getCheckIn() {
        return checkIn;
    }
    public Date getCheckOut() {
        return checkOut;
    }

    // Metodo
    public Long duration() {
        // GetTime - quantidade em milisegundos
        Long diff = checkOut.getTime() - checkIn.getTime();
        // Convertendo para DIAS DIFF
        TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return diff;
    }
    public void updateDates(Date checkIn, Date checkOut) {
        // Valicacao
        Date now = new Date();
        //Before - anerior
        if (checkIn.before(now) || checkOut.before(now)) {
            // Illegal - quando os argumentos passados sao invalidos
            throw new IllegalArgumentException("Error in reservation: Reservation dates for update must be future dates!!!");
        }
        if( !checkOut.after(checkIn) ){
            throw new IllegalArgumentException("Error in reservation: Check-out date must be after check-in date!!!");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room" +
                roomNumber +
                ", check-in : " +
                sdf.format(checkIn) +
                ", check-out : " +
                sdf.format(checkOut) +
                ", " +
                duration() +
                " nights.";
    }

}
