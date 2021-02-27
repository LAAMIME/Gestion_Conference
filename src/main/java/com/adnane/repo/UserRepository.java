package com.adnane.repo;

import com.adnane.model.AppUser;
import com.adnane.model.Profil;

import java.util.List;

//import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface UserRepository extends JpaRepository<AppUser, Long>{
//    @Query("Select u from User u where u.firstName like :x or u.lastName like :x")
//    public Page<User> findByName(@Param("x") String motCle, Pageable pageBLE);

	//@RestResource(path = "/byUsername")
	public AppUser findByUsername(String username);
}

