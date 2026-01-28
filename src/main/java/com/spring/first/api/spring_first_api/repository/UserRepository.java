package com.spring.first.api.spring_first_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.spring.first.api.spring_first_api.dto.UserCampusDTO;
import com.spring.first.api.spring_first_api.dto.UserRoleView;
import com.spring.first.api.spring_first_api.dto.UserShortInfoView;
import com.spring.first.api.spring_first_api.model.User;

public interface UserRepository extends JpaRepository<User , Integer> {
    Optional<User> findByUserUsername(String username);
    Optional<UserRoleView> findProjectedByUserUsername(String username);

   @Query("SELECT new com.spring.first.api.spring_first_api.dto.UserCampusDTO(" +
           "u.userId, u.userUsername, u.userCampusId, " +
           "c.campusShortName) " +
           "FROM User u LEFT JOIN Campus c ON c.campusUsernameId = u.userCampusId") // เชื่อม table โดยใช้ความสัมพันธ์ ManyToOne
    List<UserCampusDTO> findAllUserCampus();

    @Procedure(procedureName = "sp_getUserById")
    List<UserShortInfoView> sp_getUserById(@Param("id") Integer id);
}
