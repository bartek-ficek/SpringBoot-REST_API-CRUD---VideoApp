package pl.bartekficek.video_app.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.bartekficek.video_app.VideoAppApplication;
import pl.bartekficek.video_app.dao.VideoTapeRepo;
import pl.bartekficek.video_app.dao.entity.Videotape;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideotapeManager {

    private VideoTapeRepo videotapeRepo;

    @Autowired
    public VideotapeManager(VideoTapeRepo videotapeRepo) {
        this.videotapeRepo = videotapeRepo;
    }

    public Iterable<Videotape> findAllVideotapes() {
        return videotapeRepo.findAll();
    }

    public Optional<Videotape> findVideotapeById(Long id) {
        return videotapeRepo.findById(id);
    }

    public Videotape saveVideotape(Videotape videotape) {
        return videotapeRepo.save(videotape);
    }

    public void deleteVideotape(Long id) {
        videotapeRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        saveVideotape(new Videotape(1L, "Titanic", LocalDate.of(1995, 1, 1)));
        saveVideotape(new Videotape(2L, "Matrix", LocalDate.of(2000, 3, 5)));
        saveVideotape(new Videotape(3L, "Shrek", LocalDate.of(2005, 12, 7)));
    }
}
