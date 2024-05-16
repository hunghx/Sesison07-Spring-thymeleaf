package ra.orm.entity;

public enum ProductType {
    MALE, FEMALE;
    public String getName(){
        switch (this){
            case MALE:
                return "Nam";
            case FEMALE:
                return "Nữ";
            default:
                return null;
        }
    }
}
