package mx.htsoft.spring.boot.microservices.app.item.interfaze;

import org.springframework.data.jpa.repository.JpaRepository;
import mx.htsoft.spring.boot.microservices.app.item.models.Proveedor;

public interface IProveedor extends JpaRepository<Proveedor, String> {

}
