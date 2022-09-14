package ba.reservation.nightclubmanagement.business.model;


import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "place")
@NamedQueries({
        @NamedQuery(name = "Place.findAll", query = "SELECT g FROM Place g"),
        @NamedQuery(name = "Place.findById", query = "SELECT g FROM Place g WHERE g.id = :id"),
        @NamedQuery(name = "Place.findByNumberOfGuests", query = "SELECT g FROM Place g WHERE g.numberofguests= :NumberOfGuests"),
        @NamedQuery(name = "Place.findByNumberOfTable", query = "SELECT g FROM Place g WHERE g.numberoftable= :NumberOfTable"),
        @NamedQuery(name = "Place.findByPrice", query = "SELECT g FROM Place g WHERE g.price = :Price"),
        @NamedQuery(name = "Place.findById_Guest", query = "SELECT g FROM Place g WHERE g.id_guest=:Id_Guest")})


public class Place implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numberofguests")
    private Integer numberofguests;
    @Basic(optional = false)
    @Column(name = "numberoftable")
    private Integer numberoftable;
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "id_guest")
    private Integer id_guest;


    public Place(Integer id, Integer numberofguests, Integer numberoftable, BigDecimal price, Integer id_guest) {
        this.id = id;
        this.numberofguests = numberofguests;
        this.numberoftable = numberoftable ;
        this.price = price;
        this.id_guest = id_guest;

    }

    public Place() {
    }

    public Place(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void getNumberOfGuest(){
        this.numberofguests = numberofguests;

    }

    public Integer setNumberOfGuests() {
        return numberofguests;
    }

    public Integer getNumberoftable() {
      return numberoftable;

    }

    public Integer setNumberOfTable() {
        this.numberoftable = numberoftable;

        return null;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getId_guest() {
        return id_guest;
    }

    public void setId_guest(Integer id_guest) {
        this.id_guest = id_guest;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Place)) {
            return false;
        }
        Place other = (Place) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }

        return true;

    }
    @Override
    public String toString() {
        return "Place{" +
                "id =" + id +
                ", numberofguests ='" + numberofguests + '\'' +
                ", numberoftable ='" + numberoftable + '\'' +
                ", price ='" + price + '\'' +
                ", id_guest ='" + id_guest + '\'' +
                '}';


    }
    public void setCode(String text) {
    }

    public void setNumberofguests(int parseInt) {
    }
}