package com.conceptcoding.interviewquestions.bookmyshow;

import com.conceptcoding.interviewquestions.bookmyshow.booking.*;
import com.conceptcoding.interviewquestions.bookmyshow.enums.BookingStatus;
import com.conceptcoding.interviewquestions.bookmyshow.enums.City;
import com.conceptcoding.interviewquestions.bookmyshow.enums.PaymentMode;
import com.conceptcoding.interviewquestions.bookmyshow.enums.SeatCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShowApp {

    MovieController movieController;
    TheatreController theatreController;

    BookMyShowApp() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        System.out.println("\n###### LLD Demo of BookMyShow App ######");
        BookMyShowApp bookMyShowApp = new BookMyShowApp();
        bookMyShowApp.initialize(); // create movies and theatre

        // Demonstrate 2 users booking seats for the same movie in Bangalore
        // User 1
        System.out.println("\n===> Booking seat 30 for movie KANTARA in Bangalore for User 1");
        Customer customer = new Customer("1", "John", "john@example.com", "1234567890", "123 Main St", "password");
        bookMyShowApp.createBooking(customer, City.BANGALORE, "KANTARA");

        // User 2
        System.out.println("\n===> Booking seat 30 for movie KANTARA in Bangalore for User 2");
        Customer customer2 = new Customer("2", "Jane", "jane@example.com", "1234567890", "123 Main St", "password");
        bookMyShowApp.createBooking(customer2, City.BANGALORE, "KANTARA");
    }

    private void createBooking(Customer customer, City userCity, String movieName) {

        // 1. Search movies by location
        List<Movie> movies = movieController.getMoviesByCity(userCity);

        // 2. Select the movie
        Movie interestedMovie = null;
        for (Movie movie : movies) {
            if ((movie.getMovieName()).equals(movieName)) {
                interestedMovie = movie;
            }
        }

        // 3. Get all shows of this movie in teh requested location
        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShows(interestedMovie, userCity);

        // 4. Select a particular show from the list
        Map.Entry<Theatre, List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.getFirst();

        // 5. Select a seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
        if (!bookedSeats.contains(seatNumber)) {
            bookedSeats.add(seatNumber);
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for (Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if (screenSeat.getSeatId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
            // 6. Process Payment
            Payment payment = new Payment();
            payment.processPayment(PaymentMode.CREDIT_CARD, booking.calculateTotalAmount());
            booking.setPayment(payment);
            booking.setBookingStatus(BookingStatus.CONFIRMED);
            customer.addBooking(booking);
            System.out.println(booking);
        } else {
            System.out.println("BOOKING FAILED! Seat already booked. Please try again!");
            return;
        }
        System.out.println("BOOKING SUCCESSFUL!");
    }

    private void initialize() {
        // create movies
        createMovies();

        // create theater with screens, seats and shows
        createTheatre();
    }

    private void createTheatre() {

        Movie avengerMovie = movieController.getMovieByName("AVENGERS");
        Movie kantaraMovie = movieController.getMovieByName("KANTARA");

        // Theatre 1
        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setScreens(createScreen());
        inoxTheatre.setCity(City.BANGALORE);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1, inoxTheatre.getScreens().getFirst(), avengerMovie, 8);
        Show inoxEveningShow = createShows(2, inoxTheatre.getScreens().getFirst(), kantaraMovie, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShows(inoxShows);
        theatreController.addTheatre(inoxTheatre, City.BANGALORE);

        // Theatre 2
        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(2);
        pvrTheatre.setScreens(createScreen());
        pvrTheatre.setCity(City.DELHI);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvrTheatre.getScreens().getFirst(), avengerMovie, 13);
        Show pvrEveningShow = createShows(4, pvrTheatre.getScreens().getFirst(), kantaraMovie, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);
        theatreController.addTheatre(pvrTheatre, City.DELHI);

    }

    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);
        return screens;
    }

    private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {
        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime); // 24 hrs time ex: 14 means 2pm and 8 means 8AM
        return show;
    }

    private List<Seat> createSeats() {
        // creating 100 seats for testing purpose, this can be generalised
        List<Seat> seats = new ArrayList<>();
        // 1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }
        // 41 to 70 : GOLD
        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }
        // 71 to 100 : PLATINUM
        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }
        return seats;
    }

    private void createMovies() {
        // Movie 1
        Movie movie1 = new Movie();
        movie1.setMovieId(1);
        movie1.setMovieName("AVENGERS");
        movie1.setMovieDuration(128);

        // Movie 2
        Movie movie2 = new Movie();
        movie2.setMovieId(2);
        movie2.setMovieName("KANTARA");
        movie2.setMovieDuration(180);

        // Add movies against the cities
        movieController.addMovie(movie1, City.BANGALORE);
        movieController.addMovie(movie1, City.DELHI);
        movieController.addMovie(movie2, City.BANGALORE);
        movieController.addMovie(movie2, City.DELHI);
    }
}
