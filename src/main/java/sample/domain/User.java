package sample.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISC", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "USER")
@NamedQuery(name = "User.findByNameNamed", query = "SELECT u FROM User u WHERE LOWER(u.name) = LOWER(?1)")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, unique = true)
    private String email;
    @Column(name = "full_name", nullable = false, length = 25)
    private String name;
    @ManyToMany()
    @JoinTable(name = "user_accounts", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"))
    private List<Account> accounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
