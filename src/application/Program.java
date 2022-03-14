package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Room number: ");
            int number = sc.nextInt();
            System.out.println("Check in date (dd/mm/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Check out date (dd/mm/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            // Atualizacao da reserva
            System.out.println("Enter data to update the reservation: ");
            System.out.println("Check in date (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check out date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid date format!!!");
        }
        catch( DomainException e ) {
            System.out.println("Error in reservation: " + e.getMessage());
        }

        sc.close();
    }
}
