package HaHuShoes.Model;

public class ProviderModel {
	private int providerId;
	private String providerNameString;
	private int status;
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public String getProviderNameString() {
		return providerNameString;
	}
	public void setProviderNameString(String providerNameString) {
		this.providerNameString = providerNameString;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ProviderModel(int providerId, String providerNameString, int status) {
		super();
		this.providerId = providerId;
		this.providerNameString = providerNameString;
		this.status = status;
	}
}
