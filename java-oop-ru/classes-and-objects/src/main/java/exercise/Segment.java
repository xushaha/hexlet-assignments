package exercise;

// BEGIN
public class Segment {
        private Point point1;
        private Point point2;

        public Segment(Point point1, Point point2) {
                this.point1 = point1;
                this.point2 = point2;
        }

        public Point getBeginPoint() {
                Segment segment = new Segment(point1, point2);
                return segment.point1;
        } //— возвращает начальную точку отрезка.

        public Point getEndPoint() {
                Segment segment = new Segment(point1, point2);
                return segment.point2;
        } //— возвращает конечную точку отрезка.

        public Point getMidPoint() {
                Segment segment = new Segment(point1, point2);
                Point point1 = segment.getBeginPoint();
                Point point2 = segment.getEndPoint();

                return new Point(((point1.getX() + point2.getX()) / 2), ((point1.getY() + point2.getY()) / 2));
        }//— возвращает новую точку — середину отрезка.



}
// END
