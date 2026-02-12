public class Main {
    public static void main(String[] args) {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        System.out.println("vehicle.Saab95 speed factor: " + saab.speedFactor());
        System.out.println("vehicle.Volvo240 speed factor: " + volvo.speedFactor());
        System.out.println("vehicle.Volvo240 position: " + volvo.getPosition());
        volvo.gas(0.5);
        System.out.println("vehicle.Volvo240 speed: " + volvo.getCurrentSpeed());

        CarCarrier carCarrier = new CarCarrier(4);
        Scania scania = new Scania();

    }
}