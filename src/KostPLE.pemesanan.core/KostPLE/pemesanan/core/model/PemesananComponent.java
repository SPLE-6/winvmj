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
import KostPLE.kamar.core.KamarImpl;
import KostPLE.profilpengguna.core.ProfilPengguna;
import KostPLE.profilpengguna.core.ProfilPenggunaComponent;
import KostPLE.profilpengguna.core.ProfilPenggunaImpl;


@Entity
@Table(name="pemesanan_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PemesananComponent implements Pemesanan{
	@Id
	public String idPemesanan; 
	public Date startDate;
	public Date endDate;
	public Float totalPay;
	public String statusPemesanan;
	public String detail;
	public Date createdAt;
	@ManyToOne(targetEntity=KamarComponent.class)
	public Kamar kamarImpl;
	@ManyToOne(targetEntity=ProfilPenggunaComponent.class)
	public ProfilPengguna profilpenggunaimpl;
	protected String objectName = PemesananComponent.class.getName();

	public PemesananComponent() {

	} 

	public PemesananComponent(
        String idPemesanan, Date startDate, Date endDate, Float totalPay, String statusPemesanan, String detail, Date createdAt, KamarImpl kamarimpl, ProfilPenggunaImpl profilpenggunaimpl
    ) {
        this.idPemesanan = idPemesanan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPay = totalPay;
        this.statusPemesanan = statusPemesanan;
        this.detail = detail;
        this.createdAt = createdAt;
        this.kamarImpl = kamarimpl;
        this.profilpenggunaimpl = profilpenggunaimpl;
    }

	public abstract String getIdPemesanan();
	public abstract void setIdPemesanan(String idPemesanan);
	
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
	
	public abstract KamarImpl getKamarImpl();
	public abstract void setKamarimpl(KamarImpl kamarimpl);
	
	public abstract ProfilPenggunaImpl getProfilPenggunaImpl();
	public abstract void setProfilpenggunaimpl(ProfilPenggunaImpl profilpenggunaimpl);
	
 

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
            " kamarimpl='" + getKamarImpl() + "'" +
            " profilpenggunaimpl='" + getProfilPenggunaImpl() + "'" +
            "}";
    }
	
}
