public class Gallows {

    private static int position = 0;

    private static final String[] frames = {
            "   ____\n  |    |\n  |\n  | \n  | \n  |\n__|__",
            "   ____\n  |    |\n  |    0 \n  |     \n  |     \n  |\n__|__",
            "   ____\n  |    |\n  |   <0 \n  |     \n  |     \n  |\n__|__",
            "   ____\n  |    |\n  |   <0>\n  |     \n  |     \n  |\n__|__",
            "   ____\n  |    |\n  |   <0>\n  |    #\n  |     \n  |\n__|__",
            "   ____\n  |    |\n  |   <0>\n  |    #\n  |    |\n  |\n__|__",
            "   ____\n  |    |\n  |    0 \n  |   /#\\\n  |   /|\n  |\n__|__",
            "   ____\n  |    |\n  |      \n  | \n  |    \\0/\n  |     #\n__|__  / \\"
    };

    public static void draw (){
        System.out.println(frames[position]);
    }

    public static void drawWin(){
        System.out.println(frames[7]);
    }

    public static void drawLose(){
        System.out.println(frames[6]);
    }

    public static void up (){
        position ++;
    }

    public static boolean check () {
        return position < 6;
    }

    public static void init (){
        position = 0;
    }

    public static void main (String[] args){
        while (Gallows.check()){
            Gallows.draw();
            Gallows.up();
        }

    }

}
