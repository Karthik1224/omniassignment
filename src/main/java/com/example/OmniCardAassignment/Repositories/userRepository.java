package com.example.OmniCardAassignment.Repositories;

import com.example.OmniCardAassignment.Modals.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface userRepository extends JpaRepository<User,Integer> {
}
