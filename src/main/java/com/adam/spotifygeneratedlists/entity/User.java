package com.adam.spotifygeneratedlists.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String clientId;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<Composition> compositions;

    @OneToMany
    private List<CopyRequest> copyRequests;

    @ManyToMany
    private List<User> subscribedTo;
}
