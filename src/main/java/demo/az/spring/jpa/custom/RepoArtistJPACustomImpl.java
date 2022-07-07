package demo.az.spring.jpa.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import demo.az.spring.jpa.EntityArtistJPA;

public class RepoArtistJPACustomImpl implements RepoArtistJPACustom {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    @SuppressWarnings("unchecked")
    public List<EntityArtistJPA> findByEmailJPA(String email){

        javax.persistence.Query q = entityManager.createNativeQuery("select * from music.artist a where a.email = :email", 
            EntityArtistJPA.class);

        org.hibernate.query.NativeQuery<EntityArtistJPA> hq = q.unwrap(org.hibernate.query.NativeQuery.class)
             .setParameter("email", email, org.hibernate.type.StringNVarcharType.INSTANCE);
       
             return hq.getResultList();
    }

}
