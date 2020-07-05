package academy.pocu.comp2500.lab7;

public enum Genre {
    SCIENCE_FICTION("Science Fiction"),
    ROMANCE("Romance"),
    BIOGRAPHY("Biography"),
    FANTASY("Fantasy"),
    MYSTERY("Mystery"),
    SUSPENSE("Suspense");

    private String value;

    Genre(String suspense) {
        this.value = suspense;
    }

    public String getValue() {
        return value;
    }


}