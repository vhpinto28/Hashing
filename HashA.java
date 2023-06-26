import java.util.ArrayList;

public class HashA<E extends Comparable<E>> {
    protected class Element {
        int mark;
        Register<E> reg;

        public Element(int mark, Register<E> reg) {
            this.mark = mark;
            this.reg = reg;
        }
    }

    protected ArrayList<Element> table;
    protected int m;

    public HashA(int n) {
        this.m = n;
        this.table = new ArrayList<>(m);
        for (int i = 0; i < m; i++)
            this.table.add(new Element(0, null));
    }

    private int functionHash(int key) {
        int square = key * key;
        String squareString = String.valueOf(square);
        int length = squareString.length();
        int startIndex = (length >= 2) ? length / 4 : 0;
        int endIndex = (length >= 2) ? length - (length / 4) : length;
        String substring = squareString.substring(startIndex, endIndex);
        int result = Integer.parseInt(substring);
        return result % m;
    }

    private int linearProbing(int hashedAddress, int key) {
        int i = 0;
        int address = hashedAddress;
        while (table.get(address).mark == 1 && table.get(address).reg.key != key) {
            i++;
            address = (hashedAddress + i) % m;
            if (address < 0) {
                address += m; // Wrap around the index if it becomes negative
            }
        }
        return address;
    }


    public void insert(int key, E value) {
        int hashedAddress = functionHash(key);
        int address = linearProbing(hashedAddress, key);
        table.set(address, new Element(1, new Register<>(key, value)));
    }

    public E search(int key) {
        int hashedAddress = functionHash(key);
        int address = linearProbing(hashedAddress, key);
        if (table.get(address).mark == 1 && table.get(address).reg.key == key) {
            return table.get(address).reg.value;
        }
        return null;
    }

    public String toString() {
        String s = "D.Real\tD.Hash\tRegister\n";
        int i = 0;
        for (Element item : table) {
            s += (i++) + " -->\t";
            if (item.mark == 1)
                s += functionHash(item.reg.key) + "\t" + item.reg + "\n";
            else
                s += "empty\n";
        }
        return s;
    }
}
