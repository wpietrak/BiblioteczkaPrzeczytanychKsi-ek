package com.wojciechpietrak.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wojciechpietrak.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

/*	@Query("SELECT u FROM User u " + "LEFT JOIN FETCH u.reads " + "WHERE u.email = :email")
	User findByEmailWithReads(@Param("email") String email);*/

}
