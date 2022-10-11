package mx.htsoft.spring.boot.microservices.app.item.interfaze;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.htsoft.spring.boot.microservices.app.item.models.Articulo;

@Repository
public interface IArticulo  extends JpaRepository<Articulo, String>{


}
