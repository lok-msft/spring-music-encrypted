package demo.az.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;



@Entity
@Table(name = "artist", schema = "music")
public class EntityArtistJPA {
    
    @Id
    @Column(name = "artistid")
    private int artistId;

    @Column(name = "paytoken")
    private int payToken;

    @Column(name = "email")
    @Type(type = "org.hibernate.type.StringNVarcharType") 
    // type annotation is essential for "always-encrypted" column if expect mismatch on column definition at DB comparing to hibernate default type
    // to avoid "incompatible" exception, detail reason refer to this doc https://docs.microsoft.com/en-us/sql/connect/jdbc/using-always-encrypted-with-the-jdbc-driver?view=sql-server-ver16#unsupported-data-type-conversion-errors
    // this may only apply to ORM-type query leveraging this entity but perhaps won't help custom query "@Query"
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "city")
    private String city;
    
    @Column(name = "birthdate")
    private java.sql.Date birthDate;



    public int getArtistId() {
        return artistId;
    }
    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
    public int getPayToken() {
        return payToken;
    }
    public void setPayToken(int payToken) {
        this.payToken = payToken;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public java.sql.Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }


}
