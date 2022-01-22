package com.example.IndividualTrackProject.Repository.Interfaces;

import com.example.IndividualTrackProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
