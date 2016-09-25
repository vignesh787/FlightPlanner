package bits.project.com.flightplanner;

/**
 * Created by Vignesh on 9/19/2016.
 */
public class Flight {

    private String data;
    private String progress;
    private String od;
    private String date;
    private String bookedWeight;
    private String grantedWeight;
    private String bookedVolume;
    private String gratntedVolume;





    public String getGrantedVolume() {
        return grantedVolume;
    }

    public String getOd() {
        return od;
    }

    public String getDate() {
        return date;
    }

    public String getBookedWeight() {
        return bookedWeight;
    }

    public String getGrantedWeight() {
        return grantedWeight;
    }

    public String getBookedVolume() {
        return bookedVolume;
    }

    private String grantedVolume;

    public Flight(){

    }

    public String getData(){
    return data;
    }

    public String getProgress(){
        return progress;
    }

    @Override
    public String  toString(){
        System.out.println(progress+":"+data+":"+bookedVolume+":"+grantedWeight+":"+bookedWeight+":"+date+":"+od+":"+grantedVolume);
        return null;
    }
}
