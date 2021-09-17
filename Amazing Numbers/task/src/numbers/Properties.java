package numbers;

enum Properties {
    EVEN("EVEN"),
    ODD("ODD"),
    BUZZ("BUZZ"),
    DUCK("DUCK"),
    PALINDROMIC("PALINDROMIC"),
    GAPFUL("GAPFUL"),
    SPY("SPY"),
    SQUARE("SQUARE"),
    SUNNY("SUNNY"),
    HAPPY("HAPPY"),
    SAD("SAD"),
    JUMPING("JUMPING");

    private String name;

    Properties(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
