package exercise;

// BEGIN
public class Flat implements Home {

        double area; //— жилая площадь квартиры, число типа
        double balconyArea; //— площадь балкона, число типа
        int floor; //— этаж, на котором расположена квартира

        public Flat (double livingSqr, double balconySqr, int flatFloor) {
                this.area = livingSqr;
                this.balconyArea = balconySqr;
                this.floor = flatFloor;
        }

        @Override
        public double getArea() {
                return this.area + this.balconyArea;
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
                return "Квартира площадью " + this.getArea() + " метров на " + this.floor + " этаже";
        }
}
// END
