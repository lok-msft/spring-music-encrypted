package demo.az.spring.jdbc;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;


@Table("music.artist")
public class EntityArtistJDBC {
    
    @Id
    @Column("artistid")
    private int artistId;

    @Column("paytoken")
    private int payToken;

    @Column("email")
    private String email;

    @Column("phone")
    private String phone;

    @Column("firstname")
    private String firstName;

    @Column("lastname")
    private String lastName;

    @Column("city")
    private String city;
    
    @Column("birthdate")
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
