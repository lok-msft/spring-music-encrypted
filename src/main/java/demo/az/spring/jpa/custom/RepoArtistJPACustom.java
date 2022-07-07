package demo.az.spring.jpa.custom;

import java.util.List;

import org.springframework.data.rest.core.annotation.RestResource;

import demo.az.spring.jpa.EntityArtistJPA;


public interface RepoArtistJPACustom {

    @RestResource(path = "by-email-custom")
    List<EntityArtistJPA> findByEmailJPA(String email);
    
}
