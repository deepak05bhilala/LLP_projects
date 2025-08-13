package com.example.RishiTraders.BookMyShow;

import com.example.RishiTraders.BookMyShow.Enum.City;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class Theatre {
    private Long theatreId;
    private Address address;
    private City city;
    private List<Show> showList;
    private List<Screen> screenList;
}
