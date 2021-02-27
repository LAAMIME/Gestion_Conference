package com.adnane.repo;

import com.adnane.model.Chair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ChairRepository extends JpaRepository<Chair,Long> {
    @Query("select c from Chair c where c.user.id =:x")
    public List<Chair> trouver(@Param("x")Long idUser);
}
