package spring.masterclass.sages.users;

import lombok.*;
import spring.masterclass.sages.common.BaseEntity;
import spring.masterclass.sages.common.validator.Name;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Table(name = "users", indexes = @Index(name = "email", columnList = "email"))
@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Name
    @Pattern(regexp = "\\p{L}*")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Name
    @Pattern(regexp = "\\p{L}*")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

}