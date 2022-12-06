package mx.htsoft.spring.boot.microservices.app.item.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class sendToken {
	
	public sendToken(String token) {
		// TODO Auto-generated constructor stub
	}

	public String token;
	
}
