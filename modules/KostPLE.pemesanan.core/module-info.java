module KostPLE.pemesanan.core {
	requires KostPLE.kamar.core;
	requires KostPLE.profilpengguna.core;
	exports KostPLE.pemesanan;
    exports KostPLE.pemesanan.core;
	exports KostPLE.pemesanan.core.model;
	exports KostPLE.pemesanan.core.resource;
	requires vmj.routing.route;
	requires vmj.hibernate.integrator;
	requires vmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens KostPLE.pemesanan.core to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
	opens KostPLE.pemesanan.core.model to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
	// No repository package to open
	opens KostPLE.pemesanan.core.resource to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
