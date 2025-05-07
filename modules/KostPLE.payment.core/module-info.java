module KostPLE.payment.core {
	requires KostPLE.pemesanan.core;
	exports KostPLE.payment;
    exports KostPLE.payment.core;
	exports KostPLE.payment.core.model;
	exports KostPLE.payment.core.repository;
	exports KostPLE.payment.core.resource;
	exports KostPLE.payment.core.service;
	requires vmj.routing.route;
	requires vmj.hibernate.integrator;
	requires vmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens KostPLE.payment.core to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
