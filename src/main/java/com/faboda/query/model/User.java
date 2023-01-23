package com.faboda.query.model;

import com.faboda.query.model.modelprops.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private Role role;

    @Column(name = "user_name", nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String userName;

    @Column(name = "first_name", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String email;

    @Column(name = "password", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String password;

    @Column(name = "gender",  nullable = false, length = 12)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String gender;

    @Column(name = "age",  nullable = false, length = 3)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String age;

}