package DJ.Mylib.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.MappedSuperclass;

@Data
@Accessors(chain = true)
@MappedSuperclass
public abstract class User {

    private String firstName;

    private String lastName;

    private String email;
}
