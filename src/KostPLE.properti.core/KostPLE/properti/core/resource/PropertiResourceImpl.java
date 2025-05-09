package KostPLE.properti.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.RequestMethod;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import KostPLE.properti.PropertiFactory;
import KostPLE.properti.core.PropertiServiceImpl;
import KostPLE.properti.core.Properti;
import vmj.auth.annotations.Restricted;

//add other required packages

public class PropertiResourceImpl extends PropertiResourceComponent{
    
    private PropertiServiceImpl propertiServiceImpl = new PropertiServiceImpl();

    @Route(url="call/properti/save", method = RequestMethod.POST)
    @Override
    public List<HashMap<String,Object>> saveProperti(VMJExchange vmjExchange) {
        HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
        return propertiServiceImpl.saveProperti(requestBody);
    }

    @Route(url="call/properti/create", method = RequestMethod.POST)
    @Override
    public HashMap<String, Object> createProperti(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getPayload();
        Properti result = propertiServiceImpl.createProperti(requestBody);
        return result.toHashMap();
    }

    @Route(url="call/properti/update", method = RequestMethod.PUT)
    @Override
    public HashMap<String, Object> updateProperti(VMJExchange vmjExchange){
        HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload();
        return propertiServiceImpl.updateProperti(body);
    }

    @Route(url="call/properti/detail", method = RequestMethod.GET)
    @Override
    public HashMap<String, Object> getProperti(VMJExchange vmjExchange){
        Map<String, Object> requestBody = vmjExchange.getPayload(); 
        String propertiId = (String) requestBody.get("idProperti");
        return propertiServiceImpl.getPropertiById(propertiId);
    }

    @Route(url="call/properti/list", method = RequestMethod.GET)
    @Override
    public List<HashMap<String,Object>> getAllProperti(VMJExchange vmjExchange){
        Map<String, Object> requestBody = vmjExchange.getPayload();
        return propertiServiceImpl.getAllProperti(requestBody);
    }

    @Route(url="call/properti/delete", method = RequestMethod.DELETE)
    @Override
    public List<HashMap<String,Object>> deleteProperti(VMJExchange vmjExchange){
        HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload();
        return propertiServiceImpl.deleteProperti(body);
    }

}
