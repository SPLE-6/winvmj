module kostple.product.basic {
    requires vmj.auth.model;
    requires vmj.routing.route;
    requires vmj.hibernate.integrator;
    
    requires net.bytebuddy;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;
    requires jdk.unsupported;

    requires KostPLE.properti.core;
    requires KostPLE.kamar.core;
    requires KostPLE.profilpengguna.core;
    requires KostPLE.pemesanan.core;

}