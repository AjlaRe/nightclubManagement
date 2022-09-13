package ba.reservation.nightclubmanagement.business.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reservation")
@NamedQueries({
        @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
        @NamedQuery(name = "Reservation.findById", query = "SELECT r FROM Reservation r WHERE r.id = :id"),
        @NamedQuery(name = "Reservation.findById_guest", query = "SELECT r FROM Reservation r WHERE r.id_guest = :id_guest"),
        @NamedQuery(name = "Reservation.findById_place", query = "SELECT r FROM Reservation r WHERE r.id_place = :id_place"),
        @NamedQuery(name = "Reservation.findByDate", query = "SELECT r FROM Reservation r WHERE r.date = :Date"),
        @NamedQuery(name = "Reservation.findByPrice", query = "SELECT r FROM Reservation r WHERE r.price = :price"),})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_guest")
    @Temporal(TemporalType.TIMESTAMP)
    private Integer id_guest;
    @Basic(optional = false)
    @Column(name = "id_place")
    private Integer id_place ;
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;
    @Basic(optional = false)
    private Date date;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "price")
    private BigDecimal price;


    public Reservation() {
    }

    public Reservation(Integer id) {
        this.id = id;
    }

    public Reservation(Integer id, Date date, Integer id_guest,Integer id_tableplace, BigDecimal price) {
        this.id = id;
        this.date=date;
        this. id_guest=id_guest;
        this.id_place= id_place;
        this.price = price;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer id_guest() {
        return id_guest;
    }

    public void setin_guest() {
        this.id_guest = id_guest;
    }

    public Integer getid_tableplace() {
        return id_place ;
    }

    public void setId_tableplace() {
        this.id_place= id_place;
    }

    public Date getDate() {
        return date;
    }

    public void setToDate() {
        this.date = date;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", id_guest=" +  id_guest +
                ", id_place=" + id_place +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}