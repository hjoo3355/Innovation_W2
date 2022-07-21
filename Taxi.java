package assignment;

public class Taxi implements Transprtation{
    int Number, fuel, speed, basicDistance, totalDistance, basicFare, additionalFare, maxPassengers, currentPassengers;
    String destination, status;

    //생성자 Taxi()
    //승객탑승 및 운행 boardPassenger(int people, int totalDistance, String destination)
    // [주의] run(), stop()은 강제운행

    public Taxi() {
        this.Number = (int)(Math.random() * 10000000);
        this.fuel = 100;
        this.speed = 0;
        this.basicDistance = 1;
        this.totalDistance = 0;
        this.basicFare = 3000;
        this.additionalFare = 1000;
        this.maxPassengers = 4;
        this.currentPassengers = 0;
        this.destination = "";
        this.status = "일반";
        System.out.println(Number + "번 택시 생성");
        System.out.println("현재 승객 수 : " + currentPassengers);
        System.out.println("잔여 승객 수 : " + (maxPassengers - currentPassengers));
        System.out.println("목적지 : " + destination);
        System.out.println("기본 거리 : " + basicDistance + "km");
        System.out.println("목적지까지 거리 : " + totalDistance + "km");
        System.out.println("기본 요금 : " + basicFare);
        System.out.println("거리당 추가 요금 : " + additionalFare);
        System.out.println("주유량 : " + fuel);
        System.out.println("현재 속도 : " + speed);
    }

    public void run(int people, int totalDistance, String destination) {
        if (currentPassengers + people >= maxPassengers) {
            System.out.println("최대 승객 수 초과");
        } else if (fuel >= 10) {
            this.totalDistance = totalDistance;
            this.currentPassengers += people;
            this.destination = destination;
            this.status = "운행 중";
            System.out.println(Number + "번 택시 운행 시작");
            System.out.println("현재 승객 수 : " + currentPassengers);
            System.out.println("잔여 승객 수 : " + (maxPassengers - currentPassengers));
            System.out.println("목적지 : " + destination);
            System.out.println("기본 거리 : " + basicDistance + "km");
            System.out.println("목적지까지 거리 : " + totalDistance + "km");
            System.out.println("기본 요금 : " + basicFare);
            System.out.println("거리당 추가 요금 : " + additionalFare);
            System.out.println("주유량 : " + fuel);
            System.out.println("현재 속도 : " + speed);

        } else {
            System.out.println("주유가 필요합니다.");
        }
    }

    @Override
    public void stop() {
        this.totalDistance = 0;
        this.currentPassengers = 0;
        this.destination = "";
        this.status = "일반";
        System.out.println(Number + "번 택시 운행 종료");
        System.out.println("현재 승객 수 : " + currentPassengers);
        System.out.println("잔여 승객 수 : " + (maxPassengers - currentPassengers));
        System.out.println("목적지 : " + destination);
        System.out.println("기본 거리 : " + basicDistance);
        System.out.println("목적지까지 거리 : " + totalDistance);
        System.out.println("기본 요금 : " + basicFare);
        System.out.println("거리당 추가 요금 : " + additionalFare);
        System.out.println("주유량 : " + fuel);
        System.out.println("현재 속도 : " + speed);
    }

    public void boardPassenger(int people, int totalDistance, String destination) {
        if (status.equals("운행 중")) {
            System.out.println("탑승 불가");
        } else if (currentPassengers + people >= maxPassengers) {
            System.out.println("최대 승객 수 초과");
        } else {
            System.out.println("승객 " + people + "명 탑승");
            run(people, totalDistance, destination);
        }
    }

    @Override
    public void changeSpeed(int speed) {
        this.speed += speed;
        System.out.println(speed > 0 ? speed + "만큼 속도 증가" : -speed + "만큼 속도 감소");
        System.out.println("현재 속도 : " + this.speed);
    }

    public void pay() {
        if (basicDistance > totalDistance) {
            System.out.println("기본 요금 책정");
            System.out.println("최종 요금 : " + basicFare);
        }
        else {
            System.out.println("추가 요금 발생");
            System.out.println("최종 요금 : " + (additionalFare * (totalDistance - basicDistance) + basicFare));
        }
        stop();
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