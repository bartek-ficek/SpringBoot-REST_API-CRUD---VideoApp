package pl.bartekficek.video_app;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VideotapeApi {

    private List<Videotape> videotapes;

    public VideotapeApi() {
        videotapes = new ArrayList<>();
        videotapes.add(new Videotape(1L, "Titanic", LocalDate.of(1995,1,1)));
        videotapes.add(new Videotape(2L, "Matrix", LocalDate.of(2000,3,5)));
        videotapes.add(new Videotape(3L, "Shrek", LocalDate.of(2005,12,7)));
    }

}
