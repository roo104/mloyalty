package dk.unwire.fym.mloyalty.model;

public enum IdentifierType {
	
	MSISDN(1), EMAIL(2), FACEBOOK_ID(3);
	
	private int type;
	
	private IdentifierType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
