package exercise;


class SafetyList<I extends Number> {
    // BEGIN
    private int size;
    private Object[] values;

    private final static int DEFAULT_SIZE = 10;

    private int arraySize = DEFAULT_SIZE;

    public SafetyList() {
        values = new Object[DEFAULT_SIZE];
    }

    public SafetyList(int customSize) {
        values = new Object[customSize];
    }


    public synchronized void add(Object o) {
        if (size == values.length) {
            Object[] oldValues = this.values;
            values = new Object[size * 2];
            System.arraycopy(oldValues, 0, values, 0, oldValues.length);
        }
        values[size++] = o;
    }


    public Object get(int i) {
        if (i < size && i >= 0) {
            return values[i];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }


    public int getSize() {
        return this.size;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                result.append(values[i]);
                result.append(" ");
            }
        }
        return result.toString().trim();
    }

    // END
}
