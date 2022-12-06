package mx.htsoft.spring.boot.microservices.app.item.interfaze;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import mx.htsoft.spring.boot.microservices.app.item.models.user_rol;
public interface IUser_rol extends JpaRepository<user_rol, String> {

}
