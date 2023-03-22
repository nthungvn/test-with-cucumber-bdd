package cf.vlvn.nthung.config;

public enum BrowserType {

    CHROME("chrome"),
    FIREFOX("firefox");

    private final String code;

    BrowserType(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }

    public boolean same(String code) {
        return this.code.equalsIgnoreCase(code);
    }
}
