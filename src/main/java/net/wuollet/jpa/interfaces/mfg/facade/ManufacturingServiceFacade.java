package net.wuollet.jpa.interfaces.mfg.facade;

public interface ManufacturingServiceFacade {

	void startWork(String trackingId, String operationName, String locationNumber);

	void endWork(String trackingId, String operationName, String locationNumber);
}
