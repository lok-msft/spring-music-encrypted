package demo.az.spring.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import demo.az.spring.jpa.custom.RepoArtistJPACustom;

@RepositoryRestResource(collectionResourceRel = "artists-jpa", path = "artists-jpa")
public interface RepoArtistJPA extends JpaRepository<EntityArtistJPA, Integer>, RepoArtistJPACustom{ 
    
    @RestResource(path = "by-city")
    List<EntityArtistJPA> findByCity(@Param("city") String city);

    @RestResource(path = "by-phone")
    List<EntityArtistJPA> findByPhone(@Param("phone") String phone);

    @RestResource(path = "by-email")
    List<EntityArtistJPA> findByEmail(@Param("email") String email);

    //!!! THIS WON'T WORK !!!
    //because the DB column type (always-encrypted) is not matching the default SQL type underlying JPA/hibernate making use of, when setParameter for the query
    //refer to doc https://docs.microsoft.com/en-us/sql/connect/jdbc/using-always-encrypted-with-the-jdbc-driver?view=sql-server-ver16#unsupported-data-type-conversion-errors
    //this endpoint is just for reference to show the exception you shall expect in this case
    //one of the workarounds - refer to the class "RepoArtistJPACustomImpl"
    @RestResource(path = "by-email-nq")
    @Query(value = "declare @emmm nvarchar(50) = :email ; select * from music.artist a where a.email = @emmm", nativeQuery = true)
    List<Object> findByEmailNative(@Param("email") String email);


}
