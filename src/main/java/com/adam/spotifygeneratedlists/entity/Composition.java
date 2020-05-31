package com.adam.spotifygeneratedlists.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private Integer numberOfItems;

    @NotNull
    @OneToMany(cascade = {CascadeType.ALL})
    private List<CompositionItem> compositionItems;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Comment> comments;
}
