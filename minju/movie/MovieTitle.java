public class MovieTitle implements Comparable<MovieTitle> {
    private String title;
    private String korTitle;

    public MovieTitle(String title, String korTitle) {
        if (title.isEmpty())
            throw new IllegalArgumentException("영어 제목은 비어있을 수 없습니다.");
        this.title = title.replace("\"", "");
        if (!(korTitle.equals("NULL") || korTitle.isEmpty()))
            this.korTitle = korTitle.replace("\"", "");
    }

    @Override
    public int compareTo(MovieTitle other) {
        return this.title.compareTo(other.getTitle());
    }

    public int compareTo(String title) {
        return this.title.toLowerCase().compareTo(title.toLowerCase());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title : " + this.title + "\n");
        sb.append("Korean Title : " + this.korTitle + "\n");
        return sb.toString();
    }

    public String getTitle() {
        return this.title;
    }

}
