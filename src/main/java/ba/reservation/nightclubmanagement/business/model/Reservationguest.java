//package ba.reservation.nightclubmanagement.business.model;
//
//
//import java.io.Serializable;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name = "reservationguest")
//@NamedQueries({
//        @NamedQuery(name = "Reservationguest.findAll", query = "SELECT g FROM Reservationguest g"),
//        @NamedQuery(name = "Reservationguest.findById_Reservation", query = "SELECT g FROM Reservationguest g WHERE g.id_reservation = :id_reservation"),
//        @NamedQuery(name = "Reservationguest.findById_Guest", query = "SELECT g FROM Reservationguest g WHERE g.id_guest= :id_guest"),})
//
//public class Reservationguest implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "id_reservation")
//    private Integer id_reservation;
//    @Basic(optional = false)
//    @Column(name = "id_guest")
//    private Integer id_guest;
//    private Object id;
//
//
//    public Reservationguest(Integer id_reservation,Integer id_guest) {
//        this.id_reservation = id_reservation;
//        this.id_guest = id_guest;
//
//    }
//
//
//    public Reservationguest() {
//    }
//
//
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        if (!(object instanceof Reservationguest)) {
//            return false;
//        }
//        Reservationguest other = (Reservationguest) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//
//        return true;
//
//    }
//    @Override
//    public String toString() {
//        return "Reservationguest{" +
//                " id_reservation =" +  id_reservation +
//                ", id_guest ='" + id_guest  + '\'' +
//                '}';
//
//    }
//
//}
//
//
//
//
