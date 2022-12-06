package mx.htsoft.spring.boot.microservices.app.item.interfaze;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.htsoft.spring.boot.microservices.app.item.models.venta;

public interface IVenta extends JpaRepository<venta, String> {

	venta save(List<venta> tutorial);
	

}
