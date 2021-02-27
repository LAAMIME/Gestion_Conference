package com.adnane.repo;

import com.adnane.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ThemeRepository extends JpaRepository<Theme,Long> {
}
