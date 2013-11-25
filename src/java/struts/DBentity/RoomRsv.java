/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.DBentity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zsx
 */
@Entity
@Table(name = "room_rsv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoomRsv.findAll", query = "SELECT r FROM RoomRsv r"),
    @NamedQuery(name = "RoomRsv.findById", query = "SELECT r FROM RoomRsv r WHERE r.id = :id"),
    @NamedQuery(name = "RoomRsv.findByRoom", query = "SELECT r FROM RoomRsv r WHERE r.room = :room"),
    @NamedQuery(name = "RoomRsv.findByDate", query = "SELECT r FROM RoomRsv r WHERE r.date = :date"),
    @NamedQuery(name = "RoomRsv.findByTime1", query = "SELECT r FROM RoomRsv r WHERE r.time1 = :time1"),
    @NamedQuery(name = "RoomRsv.findByTime2", query = "SELECT r FROM RoomRsv r WHERE r.time2 = :time2"),
    @NamedQuery(name = "RoomRsv.findByUser", query = "SELECT r FROM RoomRsv r WHERE r.user = :user")})
public class RoomRsv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "room")
    private String room;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time1")
    @Temporal(TemporalType.TIME)
    private Date time1;
    @Column(name = "time2")
    @Temporal(TemporalType.TIME)
    private Date time2;
    @Column(name = "user")
    private String user;

    public RoomRsv() {
    }

    public RoomRsv(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime1() {
        return time1;
    }

    public void setTime1(Date time1) {
        this.time1 = time1;
    }

    public Date getTime2() {
        return time2;
    }

    public void setTime2(Date time2) {
        this.time2 = time2;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomRsv)) {
            return false;
        }
        RoomRsv other = (RoomRsv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "struts.DBentity.RoomRsv[ id=" + id + " ]";
    }
    
}
