package pl.bartekficek.video_app.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bartekficek.video_app.dao.VideoTapeRepo;
import pl.bartekficek.video_app.dao.entity.Videotape;

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
}
