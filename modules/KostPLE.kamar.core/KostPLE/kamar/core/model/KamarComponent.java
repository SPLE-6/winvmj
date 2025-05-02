package KostPLE.kamar.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="kamar_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KamarComponent implements Kamar{
	@Id
	public String idKamar; 
	public boolean isAvailable;
	public String tipeKamar;
	public String deskripsiKamar;
	public String Property6;
	public EFloat Property7;
	@ManyToOne(targetEntity=KostPLE.properti.core.PropertiComponent.class)
	public Properti propertiimpl;
	protected String objectName = KamarComponent.class.getName();

	public KamarComponent() {

	} 

	public KamarComponent(
        int idKamar, boolean isAvailable, String tipeKamar, String deskripsiKamar, String Property6, EFloat Property7, PropertiImpl propertiimpl
    ) {
        this.idKamar = idKamar;
        this.isAvailable = isAvailable;
        this.tipeKamar = tipeKamar;
        this.deskripsiKamar = deskripsiKamar;
        this.Property6 = Property6;
        this.Property7 = Property7;
        this.propertiimpl = propertiimpl;
    }

	public abstract int getIdKamar();
	public abstract void setIdKamar(int idKamar);
	
	public abstract boolean getIsAvailable();
	public abstract void setIsAvailable(boolean isAvailable);
	
	public abstract String getTipeKamar();
	public abstract void setTipeKamar(String tipeKamar);
	
	public abstract String getDeskripsiKamar();
	public abstract void setDeskripsiKamar(String deskripsiKamar);
	
	public abstract String getProperty6();
	public abstract void setProperty6(String Property6);
	
	public abstract EFloat getProperty7();
	public abstract void setProperty7(EFloat Property7);
	
	public abstract PropertiImpl getPropertiimpl();
	public abstract void setPropertiimpl(PropertiImpl propertiimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " idKamar='" + getIdKamar() + "'" +
            " isAvailable='" + getIsAvailable() + "'" +
            " tipeKamar='" + getTipeKamar() + "'" +
            " deskripsiKamar='" + getDeskripsiKamar() + "'" +
            " Property6='" + getProperty6() + "'" +
            " Property7='" + getProperty7() + "'" +
            " propertiimpl='" + getPropertiimpl() + "'" +
            "}";
    }
	
}
