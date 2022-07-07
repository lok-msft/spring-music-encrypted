package demo.az.spring.jdbc;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import demo.az.spring.jdbc.custom.RepoArtistJDBCCustom;



@RepositoryRestResource(collectionResourceRel = "artists-jdbc", path = "artists-jdbc")
public interface RepoArtistJDBC extends PagingAndSortingRepository<EntityArtistJDBC, Integer>, RepoArtistJDBCCustom {

    @RestResource(path = "by-email")
    List<EntityArtistJDBC> findByEmail(@Param("email") String email);

    // !!! THIS WON'T WORK !!!
    //because the DB column type (always-encrypted) is not matching the default SQL type underlying JPA/hibernate making use of, when setParameter for the query
    //this endpoint is just for reference to show the exception you shall expect in this case
    //...The data types nvarchar(50) encrypted with (...) and varchar(13) encrypted with (...)  are incompatible in the equal to operator
    //one of the workarounds - refer to the class "RepoArtistJDBCCustomImpl"
    @RestResource(path = "by-email-nq")
    @Query("select * from music.artist a where a.email = :email")
    List<EntityArtistJDBC> findByEmailQ(@Param("email") String email);


}
