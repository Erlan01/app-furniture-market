package app.uz.appfurnituremarket.entity;

import app.uz.appfurnituremarket.entity.template.AbsUUID;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "users")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update users set deleted=true where id=?")
@Builder(setterPrefix = "set")
public class User extends AbsUUID {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "is_account_non_expired")
    private boolean isAccountNonExpired = true;

    @Column(name = "is_account_non_locked")
    private boolean isAccountNonLocked = true;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "is_credentials_non_expired")
    private boolean isCredentialsNonExpired = true;

    @Override
    public String getUsername() {
        return this.phoneNumber;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
