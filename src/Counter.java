public class Counter {
    private int counter;
    private int limit;

    public Counter (){
        this.counter = 0;
        this.limit = 6;
    }

    public Counter(int start, int finish){
        this.counter = start;
        this.limit = finish;
    }

    public void up(){
        this.counter++;
    }

    public boolean check(){
        return counter < limit;
    }

    public void show(){
        System.out.printf("Mistakes %d/%d\n", this.counter, this.limit);
    }
}
