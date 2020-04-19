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

    @NotNull
    @OneToMany
    private List<Comment> comments;

    @NotNull
    @OneToMany
    private List<Composition> compositions;

    @NotNull
    @OneToMany
    private List<CopyRequest> copyRequests;

    @NotNull
    @ManyToMany
    private List<User> subscribedTo;
}
