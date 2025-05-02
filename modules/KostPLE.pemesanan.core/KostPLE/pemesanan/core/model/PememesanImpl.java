package KostPLE.pemesanan.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="pemesanan_impl")
@Table(name="pemesanan_impl")
public class PememesanImpl extends PememesanComponent {

	public PememesanImpl(int idPemesanan, EDate startDate, EDate endDate, EFloat totalPay, String statusPemesanan, String detail, EDate createdAt, KamarImpl kamarimpl) {
		this.idPemesanan = idPemesanan;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPay = totalPay;
		this.statusPemesanan = statusPemesanan;
		this.detail = detail;
		this.createdAt = createdAt;
		this.kamarimpl = kamarimpl;
	}

	public PememesanImpl(EDate startDate, EDate endDate, EFloat totalPay, String statusPemesanan, String detail, EDate createdAt, KamarImpl kamarimpl) {
		this.idPemesanan =  idPemesanan.randomUUID();;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPay = totalPay;
		this.statusPemesanan = statusPemesanan;
		this.detail = detail;
		this.createdAt = createdAt;
		this.kamarimpl = kamarimpl;
	}

	public PememesanImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> pemesananMap = new HashMap<String,Object>();
		pemesananMap.put("idPemesanan",getIdPemesanan());
		pemesananMap.put("startDate",getStartDate());
		pemesananMap.put("endDate",getEndDate());
		pemesananMap.put("totalPay",getTotalPay());
		pemesananMap.put("statusPemesanan",getStatusPemesanan());
		pemesananMap.put("detail",getDetail());
		pemesananMap.put("createdAt",getCreatedAt());
		pemesananMap.put("kamarimpl",getKamarimpl());

        return pemesananMap;
    }

}
