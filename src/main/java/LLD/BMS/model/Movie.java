package LLD.BMS.model;

import java.util.Date;
import java.util.List;

public class Movie {
    long id;
    String name;
    Date duration;
    List<Artist> artistList;
    List<Genre> genreList;
    List<Props> props;
}
