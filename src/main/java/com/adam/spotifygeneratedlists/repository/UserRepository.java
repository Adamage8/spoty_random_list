package com.adam.spotifygeneratedlists.repository;

import com.adam.spotifygeneratedlists.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.clientId = ?1")
    Optional<User> findByClientId(String spotifyId);
}
