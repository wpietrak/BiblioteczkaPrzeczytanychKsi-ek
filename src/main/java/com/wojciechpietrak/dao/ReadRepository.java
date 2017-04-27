package com.wojciechpietrak.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wojciechpietrak.model.Read;
import com.wojciechpietrak.model.User;

@Repository
public interface ReadRepository extends JpaRepository<Read, Long>{

/*	List<Read> findByUser(User user);*/
	
	@Query ("SELECT r FROM Read r LEFT JOIN FETCH r.user LEFT JOIN FETCH r.book "+
	"WHERE r.user= :userParam")
	List<Read> findByUser(@Param ("userParam")User user);

 


}
