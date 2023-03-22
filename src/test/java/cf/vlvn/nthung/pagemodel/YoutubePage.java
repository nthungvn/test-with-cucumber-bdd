package cf.vlvn.nthung.pagemodel;

public class YoutubePage {

    private static final String HOME_PAGE = "https://www.youtube.com";

    public boolean isOpen(String link) {
        return link.contains(HOME_PAGE);
    }
}
