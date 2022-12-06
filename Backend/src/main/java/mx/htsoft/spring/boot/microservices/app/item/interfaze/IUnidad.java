package mx.htsoft.spring.boot.microservices.app.item.interfaze;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.htsoft.spring.boot.microservices.app.item.models.UnidadMedida;

public interface IUnidad extends JpaRepository<UnidadMedida, String> {

}
