package pl.devset.jooq;

import jakarta.annotation.PostConstruct;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.stereotype.Repository;
import pl.devset.generate.jooq.tables.Users;
import pl.devset.generate.jooq.tables.records.UsersRecord;

@Repository
public class UserRepo {
    private final DSLContext dslContext;

    public UserRepo(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @PostConstruct
    void postConstruct() {
        selectUsers();
    }

    void selectUsers() {

        // Przykładowe zapytanie SELECT dla tabeli users
        Result<UsersRecord> result = dslContext.selectFrom(Users.USERS)
                .fetch();

        // Przetwarzanie wyników
        for (UsersRecord user : result) {
            System.out.println("ID: " + user.getId());
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
        }
    }

}
