package com.example.RishiTraders.BookMyShow.Controller;

import com.example.RishiTraders.BookMyShow.*;
import com.example.RishiTraders.BookMyShow.Enum.City;
import com.example.RishiTraders.BookMyShow.Enum.SeatType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Slf4j
@Component
@Profile("book-my-show")
public class BookMyShowMain implements CommandLineRunner {

    @Autowired
    MovieController movieController;

    @Autowired
    TheatreController theatreController;

    @Override
    public void run(String... args) throws Exception {
        log.info("Book My Show Design Running");
        initilaise();

        // User 1
        createBooking(City.BANGALORE,"Bahubali");

        // User 2
        createBooking(City.MUMBAI,"Avengers");
        return;
    }
    public void createBooking(City city, String interestedMovieName){

        Set<Movie> movieSet= movieController.getMovieByCity(city).get();
        if(movieSet.isEmpty()){
            log.info("No Movie in given City: {}",city.getName());
            return;
        }
        else if(!movieSet.contains(movieController.getMovie(interestedMovieName).get())){
            log.info("Movie : {} not casted in city {}",interestedMovieName,city.getName());
        }
        else {
            List<Theatre> theatreList= theatreController.getTheatresInCity(city).get();
            for(Theatre theatre: theatreList){
                List<Show> showList= theatre.getShowList();

                for (Show show: showList){
                    if(show.getMovie().getMovieName().equals(interestedMovieName)){
                        Screen screen = show.getScreen();
                        if(!screen.getTotalCapacity().equals(screen.getTotalOccupancy())){
                            Integer bookedSeatNumber=-1;
                            List<Seat> seatList =screen.getSeatList();
                            for(Seat seat: seatList){
                                if(!seat.getSeatBookedStatus()){
                                    bookedSeatNumber = seat.getSeatNumber();
                                    seat.setSeatBookedStatus(Boolean.TRUE);
                                    log.info("seat booked with seatNumber ={}",bookedSeatNumber);
                                    break;
                                }
                            }
                            if(bookedSeatNumber==-1){
                                log.info("No Empty Seats");
                            }
                            else{
                                show.getBookedSeatIdList().add(bookedSeatNumber);
                            }
                        }
                    }
                }
            }
        }

    }

    public void initilaise(){

        createMovies();
        createTheatre();
    }
    public void createMovies(){
        Movie Avengers = Movie.builder()
                            .movieName("AVENGERS")
                            .movieId(1)
                            .movieDuration(120)
                            .build();
        Movie Bahubali = Movie.builder()
                            .movieName("BAHUBALI")
                            .movieId(2)
                            .movieDuration(150)
                            .build();

        movieController.addMovie("Avengers",Avengers);
        movieController.addMovie("Bahubali",Bahubali);
        movieController.addMovieToCity(City.BANGALORE,Avengers);
        movieController.addMovieToCity(City.MUMBAI,Avengers);
        movieController.addMovieToCity(City.MUMBAI,Bahubali);
    }
    public void createTheatre(){

        Movie avengers = movieController.getMovie("Avengers").get();
        Movie bahubali =movieController.getMovie("Bahubali").get();
        Theatre inoxMumbai = Theatre.builder()
                                    .theatreId(12L)
                                    .address(Address.builder()
                                            .area_road("Vile Parle East")
                                            .landmark("Near Vile Parle east")
                                            .pinCode(400001)
                                            .build())
                                    .screenList(createScreens())
                                    .showList(createShows(List.of(bahubali,avengers)))
                                    .build();

        Theatre inoxBanglore = Theatre.builder()
                                    .theatreId(14L)
                                    .address(Address.builder()
                                            .area_road("Kadubeesandhalli")
                                            .landmark("In Front of Shell Petrol Pump")
                                            .pinCode(560103)
                                            .build())
                                    .screenList(createScreens())
                                    .showList(createShows(List.of(bahubali,avengers)))
                                    .build();
        theatreController.addTheatre("inoxMumbai",inoxMumbai);
        theatreController.addTheatre("inoxBanglore",inoxBanglore);
        theatreController.addTheatreToCity(inoxMumbai,City.MUMBAI);
        theatreController.addTheatreToCity(inoxBanglore,City.BANGALORE);

    }
    public List<Screen> createScreens(){
        Screen screen1 = Screen.builder()
                            .screenId(1)
                            .totalOccupancy(50)
                            .totalCapacity(100)
                            .seatList(createSeats())
                            .build();
        Screen screen2 = Screen.builder()
                            .screenId(2)
                            .totalOccupancy(23)
                            .totalCapacity(200)
                            .seatList(createSeats())
                            .build();

        return List.of(screen1,screen2);
    }
    public List<Show> createShows(List<Movie> movieList){
        Show show1 = Show.builder()
                        .showId(1)
                        .bookedSeatIdList(List.of(1,2))
                        .movie(movieList.get(0))
                        .build();
        Show show2= Show.builder()
                        .showId(2)
                        .bookedSeatIdList(List.of(1,2))
                        .movie(movieList.get(1))
                        .build();
        return List.of(show1,show2);
    }
    public List<Seat> createSeats() {

        Seat seat1 = Seat.builder()
                        .seatNumber(1)
                        .seatPrice(45)
                        .seatType(SeatType.GOLD)
                        .seatBookedStatus(Boolean.TRUE)
                        .build();
        Seat seat2 = Seat.builder()
                        .seatNumber(2)
                        .seatPrice(60)
                        .seatType(SeatType.SILVER)
                        .seatBookedStatus(Boolean.FALSE)
                        .build();
        return List.of(seat1,seat2);

    }




}
