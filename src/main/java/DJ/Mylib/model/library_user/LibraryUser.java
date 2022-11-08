package DJ.Mylib.model.library_user;


import DJ.Mylib.model.Publication;
import DJ.Mylib.model.User;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
public class LibraryUser extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<Publication> publicationHistory = new ArrayList<>();

    @OneToMany(mappedBy = "owners")
    private List<Publication> borrowedPublication = new ArrayList<>();

    private CanIBorrow canIBorrow;

    // LibraryUser can not borrow next publication if he has borrowed 3 publications in one moment
    public enum CanIBorrow {

        YES,
        NO

    }
}
