package com.adnane.repo;

import com.adnane.model.Audience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface AudienceRepository extends JpaRepository<Audience,Long> {
}
