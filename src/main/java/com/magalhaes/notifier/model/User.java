package com.magalhaes.notifier.model;

import com.magalhaes.notifier.type.CategoryType;
import com.magalhaes.notifier.type.NotificationType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CollectionOfElements;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class User {

    private String name;
    private String email;
    private String phone;
    private Set<CategoryType> categories;
    private Set<NotificationType> notifications;

}
