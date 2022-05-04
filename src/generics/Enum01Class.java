package generics;

public class Enum01Class {
    public static void main(String[] args) {
        Enum01 browserName = Enum01.CHROME;

        switch(browserName){
            case CHROME:
                System.out.println("Chrome browser is running");
                break;
            case SAFARI:
                System.out.println("Safari browser is running");
                break;
            case IE:
                System.out.println("IE browser is running");
                break;
            case FIREFOX:
                System.out.println("Firefox browser is running");
                break;
            default:
                System.out.println("Invalid browser name");
        }
    }
}
