package com.magalhaes.notifier.entity;

import com.magalhaes.notifier.model.User;
import com.magalhaes.notifier.type.CategoryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity(name = "messages")
@Table(name = "messages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String message;
    private Timestamp timestamp;
    @Enumerated(EnumType.STRING)
    private CategoryType category;
    @JdbcTypeCode(SqlTypes.JSON)
    @ElementCollection
    @CollectionTable(name = "users_list", joinColumns = @JoinColumn(name = "id")) // 2
    @Column(name = "users")
    private Set<User> notifiedUsers;
}
