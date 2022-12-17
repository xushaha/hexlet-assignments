package exercise;

// BEGIN
public class Cottage implements Home {

        double area; // Общая площадь коттеджа
        int floorCount; // количество этажей

        public Cottage (double wholeSqr, int floorAmount) {
                this.area = wholeSqr;
                this.floorCount = floorAmount;
        }

        @Override
        public double getArea() {
                return this.area;
        }

        @Override
        public int compareTo(Home another) {
                if (this.getArea() > another.getArea()) {
                        return 1;
                } else if (this.getArea() < another.getArea()) {
                        return -1;
                } else {
                        return 0;
                }
        }

        public String toString() {
                return this.floorCount + " этажный коттедж площадью " + this.getArea() + " метров";
        }
}
// END
