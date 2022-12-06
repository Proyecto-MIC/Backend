package mx.htsoft.spring.boot.microservices.app.item.interfaze;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.htsoft.spring.boot.microservices.app.item.models.Usuario;

public interface IUsuario extends JpaRepository<Usuario, String>  {
   	
}
