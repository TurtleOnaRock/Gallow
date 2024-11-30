public class GallowRender {

    private static final String MISTAKE_MSG = "Ошибки: ";
    private static final String LIMIT_MSG = "/6\n";

    private static final String[] frames = {
      """
              ____
             |    |
             |
             |
             |
             |
           __|__
      """,
      """
              ____
             |    |
             |    0
             |
             |
             |
           __|__
      """,
      """
              ____
             |    |
             |   <0
             |
             |
             |
           __|__
      """,
      """
              ____
             |    |
             |   <0>
             |
             |
             |
           __|__
      """,
      """
             ____
            |    |
            |   <0>
            |    #
            |
            |
          __|__
      """,
      """
             ____
            |    |
            |   <0>
            |    #
            |    |
            |
          __|__
      """,
      """  
             ____
            |    |
            |    0
            |   /#\\
            |   /|
            |
          __|__
      """,
      """  
             ____
            |    |
            |
            |
            |   \\0/
            |    #
          __|__ / \\
      """
    };

    public static void showMistakes (int stage)
    {
        System.out.print(MISTAKE_MSG + stage + LIMIT_MSG);
    }

    public static void showGallow (int stage)
    {
        System.out.println(frames[stage]);
    }

    public static void showWin()
    {
        System.out.println(frames[Constants.WIN_STAGE]);
    }

    public static void showLose()
    {
        System.out.println(frames[Constants.LOSE_STAGE]);
    }
}
