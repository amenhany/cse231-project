package org.hotelbooking.accommodation;


public class Villa extends Accommodation implements ExtraFeeApplicable {
    private boolean hasPool;


    public Villa(int villaNumber, double pricePerNight, int capacity, boolean hasPool) {
        super("VM" + villaNumber, pricePerNight, capacity);
        this.hasPool = hasPool;
    }

    public  boolean matches(AccommodationTemplate template){
     return (template.getAccommodationType() == AccommodationType.VILLA) && (template.hasPool() == hasPool);
    }

    public boolean hasPool(){
        return hasPool;
    }

    @Override
    public double getExtraFees() {
        if(hasPool)  return 100.0;
        return 0.0;
    }

    @Override
    public  void displayInfo(){
        System.out.println("Villa Info:- \n Villa ID: " + getAccommodationId() + "Pool available: " + hasPool
                +"\nPrice/Night: " + getPricePerNight());
    }
}
