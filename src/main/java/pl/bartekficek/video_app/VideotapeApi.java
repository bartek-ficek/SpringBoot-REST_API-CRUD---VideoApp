package pl.bartekficek.video_app;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/videotapes")
public class VideotapeApi {

    private List<Videotape> videotapes;

    public VideotapeApi() {
        videotapes = new ArrayList<>();
        videotapes.add(new Videotape(1L, "Titanic", LocalDate.of(1995,1,1)));
        videotapes.add(new Videotape(2L, "Matrix", LocalDate.of(2000,3,5)));
        videotapes.add(new Videotape(3L, "Shrek", LocalDate.of(2005,12,7)));
    }

    @GetMapping("/all")
    public List<Videotape> getAllVideotapes() {
        return videotapes;
    }
    
    @GetMapping
    public Videotape getVideotapeById(@RequestParam int id){
        Optional<Videotape> first = videotapes.stream().filter(tape -> tape.getId() == id).findFirst();
        return first.get();
    }

    @PostMapping("/add")
    public boolean addVideotape(@RequestBody Videotape videotape){
        return videotapes.add(videotape);
    }

}
