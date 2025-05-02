package KostPLE.properti.laporan;

import java.util.*;

import vmj.routing.route.VMJExchange;

import KostPLE.properti.core.PropertiServiceDecorator;
import KostPLE.properti.core.PropertiImpl;
import KostPLE.properti.core.PropertiServiceComponent;

public class PropertiServiceImpl extends PropertiServiceDecorator {
    public PropertiServiceImpl (PropertiServiceComponent record) {
        super(record);
    }

    
}
