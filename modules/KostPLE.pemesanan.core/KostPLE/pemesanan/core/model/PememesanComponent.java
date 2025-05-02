package KostPLE.pemesanan.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="pemesanan_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PememesanComponent implements Pemesanan{
	@Id
	public int idPemesanan; 
	public EDate startDate;
	public EDate endDate;
	public EFloat totalPay;
	public String statusPemesanan;
	public String detail;
	public EDate createdAt;
	@ManyToOne(targetEntity=KostPLE.kamar.core.KamarComponent.class)
	public Kamar kamarimpl;
	protected String objectName = PememesanComponent.class.getName();

	public PememesanComponent() {

	} 

	public PememesanComponent(
        int idPemesanan, EDate startDate, EDate endDate, EFloat totalPay, String statusPemesanan, String detail, EDate createdAt, KamarImpl kamarimpl
    ) {
        this.idPemesanan = idPemesanan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPay = totalPay;
        this.statusPemesanan = statusPemesanan;
        this.detail = detail;
        this.createdAt = createdAt;
        this.kamarimpl = kamarimpl;
    }

	public abstract int getIdPemesanan();
	public abstract void setIdPemesanan(int idPemesanan);
	
	public abstract EDate getStartDate();
	public abstract void setStartDate(EDate startDate);
	
	public abstract EDate getEndDate();
	public abstract void setEndDate(EDate endDate);
	
	public abstract EFloat getTotalPay();
	public abstract void setTotalPay(EFloat totalPay);
	
	public abstract String getStatusPemesanan();
	public abstract void setStatusPemesanan(String statusPemesanan);
	
	public abstract String getDetail();
	public abstract void setDetail(String detail);
	
	public abstract EDate getCreatedAt();
	public abstract void setCreatedAt(EDate createdAt);
	
	public abstract KamarImpl getKamarimpl();
	public abstract void setKamarimpl(KamarImpl kamarimpl);
	
 

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
            " kamarimpl='" + getKamarimpl() + "'" +
            "}";
    }
	
}
