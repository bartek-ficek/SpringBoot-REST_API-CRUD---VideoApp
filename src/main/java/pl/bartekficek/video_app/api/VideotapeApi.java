package pl.bartekficek.video_app.api;

import org.springframework.web.bind.annotation.*;
import pl.bartekficek.video_app.dao.entity.Videotape;

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
        videotapes.add(new Videotape(1L, "Titanic", LocalDate.of(1995, 1, 1)));
        videotapes.add(new Videotape(2L, "Matrix", LocalDate.of(2000, 3, 5)));
        videotapes.add(new Videotape(3L, "Shrek", LocalDate.of(2005, 12, 7)));
    }

    @GetMapping("/all")
    public List<Videotape> getAllVideotapes() {
        return videotapes;
    }

    @GetMapping
    public Videotape getVideotapeById(@RequestParam int id) {
        Optional<Videotape> first = videotapes.stream().filter(tape -> tape.getId() == id).findFirst();
        return first.get();
    }

    @PostMapping("/add")
    public boolean addVideotape(@RequestBody Videotape videotape) {
        return videotapes.add(videotape);
    }

    @PutMapping("/update")
    public void updateVideotape(@RequestParam int id, @RequestBody Videotape videotape) {
        Videotape videotapeNewData = videotapes.stream().filter(tape -> tape.getId() == id).findFirst().get();
        videotapeNewData.setProductionYear(videotape.getProductionYear());
        videotapeNewData.setTitle(videotape.getTitle());
    }

    @DeleteMapping("/delete")
    public boolean deleteVideotape(@RequestParam int id) {
        return videotapes.removeIf(videotape -> videotape.getId() == id);
    }
}