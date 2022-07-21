package assignment;

public class Bus implements Transprtation {
    int maxPassengers, currentPassengers, fare, Number, fuel, speed;
    String status;

    //생성자 Taxi()
    //승객탑승 boardPassenger(int people)
    //[주의] run(), stop()은 강제운행

    public Bus() {
        this.maxPassengers = 30;
        this.currentPassengers = 0;
        this.fare = 1000;
        this.Number = (int)(Math.random() * 10000000);
        this.fuel = 100;
        this.speed = 0;
        this.status = "운행";
        System.out.println(Number + "번 버스 생성");
        System.out.println("현재 승객수 : " + currentPassengers);
        System.out.println("잔여 승객 수 : " + (maxPassengers - currentPassengers));
        System.out.println("요금 : " + fare);
        System.out.println("주유량 : " + fuel);
        System.out.println("현재 속도 : " + speed);
    }

    public void run() {
        this.status = "운행";
        System.out.println(Number + "번 버스 운행시작");
        System.out.println("현재 승객수 : " + currentPassengers);
        System.out.println("잔여 승객 수 : " + (maxPassengers - currentPassengers));
        System.out.println("요금 : " + fare);
        System.out.println("주유량 : " + fuel);
        System.out.println("현재 속도 : " + speed);
        if (fuel < 10) {
            System.out.println("주유가 필요합니다.");
        }
    }

    @Override
    public void stop() {
        this.status = "차고지 행";
        System.out.println(Number + "번 버스 운행 종료 및 차고지 행");
        System.out.println("현재 승객수 : " + currentPassengers);
        System.out.println("잔여 승객 수 : " + (maxPassengers - currentPassengers));
        System.out.println("요금 : " + fare);
        System.out.println("주유량 : " + fuel);
        System.out.println("현재 속도 : " + speed);
    }

    public void changeStatus() {
        if (status == "운행") {
            stop();
        } else if (status == "차고지 행") {
            run();
        }
    }

    public void boardPassenger(int people) {
        if (currentPassengers + people >= maxPassengers) {
            System.out.println("최대 승객 수 초과");
        } else if (status.equals("차고지 행")) {
            System.out.println("현재 버스가 운행중이 아닙니다.");
        } else {
            this.currentPassengers += people;
            System.out.println("승객 " + people + "명 탑승");
        }
    }

    @Override
    public void changeSpeed(int speed) {
        if (fuel < 10) {
            System.out.println("주유량을 확인해 주세요.");
        } else if (speed == 0) {
            System.out.println("속도 변화 없음");
        } else {
            this.speed += speed;
            System.out.println(speed > 0 ? speed + "만큼 속도 증가" : -speed + "만큼 속도 감소");
            System.out.println("현재 속도 : " + this.speed);
        }
    }

    @Override
    public void changefuel(int fuel) {
        this.fuel += fuel;
        System.out.println("주유량 : " + this.fuel);
        if (this.fuel < 10) {
            System.out.println("주유가 필요합니다.");
        }
    }
}