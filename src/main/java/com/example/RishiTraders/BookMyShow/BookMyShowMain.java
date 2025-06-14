package com.example.RishiTraders.BookMyShow;

import com.example.RishiTraders.BookMyShow.Enum.City;
import com.example.RishiTraders.BookMyShow.Enum.SeatType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        BookMyShowMain bookMyShowMain = new BookMyShowMain();
        bookMyShowMain.initilaise();
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
                .showList(createShows(List.of(avengers)))
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
        List<Screen> screenList =new ArrayList<>();
        screenList.add(screen1);
        screenList.add(screen2);
        return  screenList;
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
                        .build();
        Seat seat2 = Seat.builder()
                        .seatNumber(2)
                        .seatPrice(60)
                        .seatType(SeatType.SILVER)
                        .build();
        List<Seat> seatList =new ArrayList<>();
        seatList.add(seat1);
        seatList.add(seat2);
        return  seatList;

    }




}
