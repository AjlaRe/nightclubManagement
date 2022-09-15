package ba.reservation.nightclubmanagement.business.model;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "guest")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Guest.findAll", query = "SELECT g FROM Guest g"),
        @NamedQuery(name = "Guest.findById", query = "SELECT g FROM Guest g WHERE g.id = :id"),
        @NamedQuery(name = "Guest.findByDocument", query = "SELECT g FROM Guest g WHERE g.document = :document"),
        @NamedQuery(name = "Guest.findByName", query = "SELECT g FROM Guest g WHERE g.name = :name"),
        @NamedQuery(name = "Guest.findBySurname", query = "SELECT g FROM Guest g WHERE g.surname = :surname")})

public class Guest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "document")
    private String document;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;



    public Guest() {
    }

    public Guest(Integer id) {
        this.id = id;
    }

    public Guest(Integer id, String document, String name, String surname) {
        this.id = id;
        this.document = document;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Guest)) {
            return false;
        }
        Guest other = (Guest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", document='" + document + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}