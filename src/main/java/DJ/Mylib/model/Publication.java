package DJ.Mylib.model;

import DJ.Mylib.model.library_user.LibraryUser;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@MappedSuperclass
public abstract class Publication {

    @Version
    private  Long version;

    private String title;

    private String publisher;

    private int year;

    private int quantity;

    private String language;

    private StatePublication statePublication;

    @OneToMany
    @JoinColumn(name = "library_user_id")
    private List<LibraryUser> ownersHistory = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "library_user_id")
    private List<LibraryUser> owners = new ArrayList<>();

    // Publication is AVAILABLE when quantity != owners.size + 1 else is INACCESSIBLE
    public enum StatePublication {

        AVAILABLE,
        INACCESSIBLE

    }

}


