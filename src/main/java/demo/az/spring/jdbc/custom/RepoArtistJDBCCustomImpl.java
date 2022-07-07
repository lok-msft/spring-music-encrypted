package demo.az.spring.jdbc.custom;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import demo.az.spring.jdbc.EntityArtistJDBC;

// import javax.persistence.EntityManager;
// import javax.persistence.PersistenceContext;

public class RepoArtistJDBCCustomImpl implements RepoArtistJDBCCustom {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;

    @Override
    @SuppressWarnings("unchecked")
    public List<EntityArtistJDBC> findByEmailCustom(String email){
        return npJdbcTemplate.query("select * from music.artist a where a.email = :email", 
                                            new MapSqlParameterSource().addValue("email", email, java.sql.Types.NVARCHAR), 
                                            BeanPropertyRowMapper.newInstance(EntityArtistJDBC.class));
    }

}
