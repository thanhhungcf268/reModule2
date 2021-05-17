import CaseStudy.BlockStatic;


public class CarWash extends Thread implements Runnable{
    private final Car car = new Car();
    @Override
    public void start() {
        System.out.println(" Nhập biển số xe ! ");
        String licensePlate = BlockStatic.sc.nextLine();
        car.setLicensePlate(licensePlate);
        int k = 0;
        int a = 10;
        while (k<a){
            System.out.println(" đang rửa xe "+ car.getLicensePlate());
            try {
                Thread.sleep(1500);
                k++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (k==10){
            System.out.println(" rủa xong ");
        }
    }
}
