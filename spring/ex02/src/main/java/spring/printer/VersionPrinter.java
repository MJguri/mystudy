package spring.printer;

public class VersionPrinter {
	private int majorVersion;
	private int minorVersion;
	
	
	public VersionPrinter() {}
	
	
	public VersionPrinter(int majorVersion, int minorVersion) {
		super();
		this.majorVersion = majorVersion;
		this.minorVersion = minorVersion;
	}

	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}


	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}


	public void print() {
		System.out.printf("이프로그램의 버전은 %d.%d 입니다. \n", majorVersion, minorVersion);
	}
}
