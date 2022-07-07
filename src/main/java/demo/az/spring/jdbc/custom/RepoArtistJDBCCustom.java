package demo.az.spring.jdbc.custom;

import java.util.List;

import org.springframework.data.rest.core.annotation.RestResource;

import demo.az.spring.jdbc.EntityArtistJDBC;


public interface RepoArtistJDBCCustom {

    @RestResource(path = "by-email-custom")
    List<EntityArtistJDBC> findByEmailCustom(String email);
    
}
