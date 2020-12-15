package pl.bartekficek.video_app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bartekficek.video_app.dao.entity.Videotape;
import pl.bartekficek.video_app.manager.VideotapeManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/videotapes")
public class VideotapeApi {

    private VideotapeManager videotapeManager;

    @Autowired
    public VideotapeApi(VideotapeManager videotapeManager) {
        this.videotapeManager = videotapeManager;
    }

    @GetMapping("/all")
    public Iterable<Videotape> getAllVideotapes() {
        return videotapeManager.findAllVideotapes();
    }

    @GetMapping
    public Optional<Videotape> getVideotapeById(@RequestParam Long id) {
        return videotapeManager.findVideotapeById(id);
    }

    @PostMapping("/add")
    public Videotape addVideotape(@RequestBody Videotape videotape) {
        return videotapeManager.saveVideotape(videotape);
    }

    @PutMapping("/update")
    public void updateVideotape(@RequestParam Long id, @RequestBody Videotape videotape) {
        Optional<Videotape> videotapeById = videotapeManager.findVideotapeById(id);
        videotapeById.ifPresent(oldDataVideotape -> oldDataVideotape.setProductionYear(videotape.getProductionYear()));
        videotapeById.ifPresent(oldDataVideotape -> oldDataVideotape.setTitle(videotape.getTitle()));
        videotapeManager.saveVideotape(vid)


//        Videotape videotapeNewData = videotapes.stream().filter(tape -> tape.getId() == id).findFirst().get();
//        videotapeNewData.setProductionYear(videotape.getProductionYear());
//        videotapeNewData.setTitle(videotape.getTitle());
    }

    @DeleteMapping("/delete")
    public void deleteVideotape(@RequestParam Long id) {
        videotapeManager.deleteVideotape(id);
    }
}
