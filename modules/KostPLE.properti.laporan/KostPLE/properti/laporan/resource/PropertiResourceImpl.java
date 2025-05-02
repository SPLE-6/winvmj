package KostPLE.properti.laporan;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import KostPLE.properti.core.PropertiResourceDecorator;
import KostPLE.properti.core.PropertiImpl;
import KostPLE.properti.core.PropertiResourceComponent;

public class PropertiResourceImpl extends PropertiResourceDecorator {
    public PropertiResourceImpl (PropertiResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/laporan/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		PropertiLaporan propertilaporan = createPropertiLaporan(vmjExchange);
		propertilaporanRepository.saveObject(propertilaporan);
		return getAllPropertiLaporan(vmjExchange);
	}

    public Properti createPropertiLaporan(VMJExchange vmjExchange){
		
		PropertiLaporan propertilaporan = record.createPropertiLaporan(vmjExchange);
		PropertiLaporan propertilaporandeco = PropertiLaporanFactory.createPropertiLaporan("KostPLE.laporan.core.PropertiImpl", propertilaporan, idProperti, namaProperti, deskripsiProperti, lokasiProperti, fotoUrlProperti, profilpenggunaimpl
		pemasukan, pengeluaran
		);
			return propertilaporandeco;
	}


    public Properti createPropertiLaporan(VMJExchange vmjExchange, int id){
		PropertiLaporan propertilaporan = propertilaporanRepository.getObject(id);
		int recordPropertiLaporanId = (((PropertiLaporanDecorator) savedPropertiLaporan.getRecord()).getId();
		
		PropertiLaporan propertilaporan = record.createPropertiLaporan(vmjExchange);
		PropertiLaporan propertilaporandeco = PropertiLaporanFactory.createPropertiLaporan("KostPLE.laporan.core.PropertiImpl", id, propertilaporan, idProperti, namaProperti, deskripsiProperti, lokasiProperti, fotoUrlProperti, profilpenggunaimpl
		pemasukan, pengeluaran
		);
			return propertilaporandeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/laporan/update")
    public HashMap<String, Object> updatePropertiLaporan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("idProperti");
		int id = Integer.parseInt(idStr);
		
		PropertiLaporan propertilaporan = propertilaporanRepository.getObject(id);
		propertilaporan = createPropertiLaporan(vmjExchange, id);
		
		propertilaporanRepository.updateObject(propertilaporan);
		propertilaporan = propertilaporanRepository.getObject(id);
		//to do: fix association attributes
		
		return propertilaporan.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/laporan/detail")
    public HashMap<String, Object> getPropertiLaporan(VMJExchange vmjExchange){
		return record.getPropertiLaporan(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/laporan/list")
    public List<HashMap<String,Object>> getAllPropertiLaporan(VMJExchange vmjExchange){
		List<PropertiLaporan> propertilaporanList = propertilaporanRepository.getAllObject("propertilaporan_impl");
		return transformPropertiLaporanListToHashMap(propertilaporanList);
	}

    public List<HashMap<String,Object>> transformPropertiLaporanListToHashMap(List<PropertiLaporan> PropertiLaporanList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < PropertiLaporanList.size(); i++) {
            resultList.add(PropertiLaporanList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/laporan/delete")
    public List<HashMap<String,Object>> deletePropertiLaporan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("idProperti");
		int id = Integer.parseInt(idStr);
		propertilaporanRepository.deleteObject(id);
		return getAllPropertiLaporan(vmjExchange);
	}

	
}
