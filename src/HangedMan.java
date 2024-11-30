public class HangedMan {

    private int stage;
    private final int limit;

    private final int DEFAULT_VALUE_STAGE = 0;
    private final int DEFAULT_VALUE_LIMIT = 6;

    public HangedMan ()
    {
        this.stage = DEFAULT_VALUE_STAGE;
        this.limit = DEFAULT_VALUE_LIMIT;
    }

    public void up()
    {
        this.stage++;
    }

    public boolean isAlive()
    {
        return stage < limit;
    }

    public int getStage()
    {
        return stage;
    }
}
