package KostPLE.pemesanan.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import KostPLE.kamar.core.Kamar;
import KostPLE.kamar.core.KamarComponent;
import KostPLE.profilpengguna.core.ProfilPengguna;
import KostPLE.profilpengguna.core.ProfilPenggunaComponent;


@Entity
@Table(name="pemesanan_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PemesananComponent implements Pemesanan{
	@Id
	public UUID idPemesanan; 
	public Date startDate;
	public Date endDate;
	public Float totalPay;
	public String statusPemesanan;
	public String detail;
	public Date createdAt;
	@ManyToOne(targetEntity=KostPLE.kamar.core.KamarComponent.class)
	public Kamar kamar;
	@ManyToOne(targetEntity=KostPLE.profilpengguna.core.ProfilPenggunaComponent.class)
	public ProfilPengguna profilPengguna;
	protected String objectName = PemesananComponent.class.getName();

	public PemesananComponent() {

	} 

	public PemesananComponent(
        UUID idPemesanan, Date startDate, Date endDate, Float totalPay, String statusPemesanan, String detail, Date createdAt, Kamar kamar, ProfilPengguna profilPengguna
    ) {
        this.idPemesanan = idPemesanan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPay = totalPay;
        this.statusPemesanan = statusPemesanan;
        this.detail = detail;
        this.createdAt = createdAt;
        this.kamar = kamar;
        this.profilPengguna = profilPengguna;
    }

	public abstract UUID getIdPemesanan();
	public abstract void setIdPemesanan(UUID idPemesanan);
	
	public abstract Date getStartDate();
	public abstract void setStartDate(Date startDate);
	
	public abstract Date getEndDate();
	public abstract void setEndDate(Date endDate);
	
	public abstract Float getTotalPay();
	public abstract void setTotalPay(Float totalPay);
	
	public abstract String getStatusPemesanan();
	public abstract void setStatusPemesanan(String statusPemesanan);
	
	public abstract String getDetail();
	public abstract void setDetail(String detail);
	
	public abstract Date getCreatedAt();
	public abstract void setCreatedAt(Date createdAt);
	
	public abstract Kamar getKamar();
	public abstract void setKamar(Kamar kamar);
	
	public abstract ProfilPengguna getProfilPengguna();
	public abstract void setProfilPengguna(ProfilPengguna profilPengguna);
	
 

	@Override
    public String toString() {
        return "{" +
            " idPemesanan='" + getIdPemesanan() + "'" +
            " startDate='" + getStartDate() + "'" +
            " endDate='" + getEndDate() + "'" +
            " totalPay='" + getTotalPay() + "'" +
            " statusPemesanan='" + getStatusPemesanan() + "'" +
            " detail='" + getDetail() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " kamar='" + getKamar() + "'" +
            " profilPengguna='" + getProfilPengguna() + "'" +
            "}";
    }
	
}
