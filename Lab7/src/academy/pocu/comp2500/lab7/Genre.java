package academy.pocu.comp2500.lab7;

public enum Genre {
    SCIENCE_FICTION("science fiction"),
    ROMANCE("Romance"),
    BIOGRAPHY("Biography"),
    FANTASY("Fantasy"),
    MYSTERY("Mystery"),
    SUSPENSE("Suspense");

    private String value;

    Genre(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
