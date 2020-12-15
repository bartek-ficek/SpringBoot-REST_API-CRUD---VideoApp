package pl.bartekficek.video_app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.bartekficek.video_app.dao.entity.Videotape;

@Repository
public interface VideoTapeRepo extends CrudRepository<Videotape, Long> {
}
