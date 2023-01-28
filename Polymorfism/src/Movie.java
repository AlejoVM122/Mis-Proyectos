public class Movie {

    private String tittle;

    public Movie(String tittle) {
        this.tittle = tittle;
    }

    public void watchMOvie (){
        String instanceType = this.getClass().getSimpleName();
        System.out.println( tittle + " is a " +instanceType);
    }
}
