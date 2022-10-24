package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import se.uu.swedifying.model.entity.TextSource;
import se.uu.swedifying.model.projection.TextSourceView;

@RepositoryRestResource(excerptProjection = TextSourceView.class)
public interface TextSourceRepository extends CrudRepository<TextSource, Long> {
}