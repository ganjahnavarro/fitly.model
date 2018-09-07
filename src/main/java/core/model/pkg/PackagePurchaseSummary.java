package core.model.pkg;

public class PackagePurchaseSummary {

	private Package pkg;
	private Long count;

	public PackagePurchaseSummary(Package pkg, Long count) {
		this.pkg = pkg;
		this.count = count;
	}

	public Package getPkg() {
		return pkg;
	}

	public Long getCount() {
		return count;
	}

}
