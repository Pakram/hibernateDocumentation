package pokramovich.domain.pojo;


import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Pokramovich on 16.09.2016.
 */
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "id")
    private Integer id;
    @Column(nullable = false, unique = true)
    private String login;
    @Column
    private String password;
    @Column
    @Temporal(TemporalType.DATE)
    private Date dateAdd=new Date();
    @Column(unique = true)
    private String email;

    public User() {
    }

    private User(UserBuilder personBuilder) {
        this.login = personBuilder.getLogin();
        this.password = personBuilder.getPassword();
        this.email = personBuilder.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (dateAdd != null ? !dateAdd.equals(user.dateAdd) : user.dateAdd != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (dateAdd != null ? dateAdd.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", dateAdd=" + dateAdd +
                ", email='" + email + '\'' +
                '}';
    }

    public static class UserBuilder {
        private final String login;
        private final String password;
        private Date dateAdd;
        private final String email;

        public UserBuilder(String login, String password, String email) {
            this.login = login;
            this.password = password;
            this.email = email;
        }

        private String getLogin() {
            return login;
        }

        private String getPassword() {
            return password;
        }

        public Date getDateAdd() {
            return dateAdd;
        }

        public UserBuilder setDateAdd(Date dateAdd) {
            this.dateAdd = dateAdd;
            return this;
        }

        private String getEmail() {
            return email;
        }

        public User build() {
            return new User(this);
        }
    }
}
