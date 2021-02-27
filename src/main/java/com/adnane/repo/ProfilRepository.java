package com.adnane.repo;

import com.adnane.model.Profil;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProfilRepository extends JpaRepository<Profil, Long>{
	@RestResource(path = "/byLabel")
    public List<Profil> findByLabelContains(@Param("mc") String label);
	@RestResource(path = "/byLabelPage")
    public Page<Profil> findByLabelContains(@Param("mc") String label, Pageable pageable);
}
