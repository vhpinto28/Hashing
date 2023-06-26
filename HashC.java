import java.util.LinkedList;
class HashC<E extends Comparable<E>> {
    protected class Element {
        int mark;
        Register<E> reg;

        public Element(int mark, Register<E> reg) {
            this.mark = mark;
            this.reg = reg;
        }
    }

    protected LinkedList<Element> table;
    protected int m;

    public HashC(int n) {
        this.m = n;
        this.table = new LinkedList<>();
    }

    private int functionHash(int key) {
        int sum = 0;
        while (key > 0) {
            sum += key % 10;
            key /= 10;
        }
        return sum % m;
    }

    private int linearProbing(int hashedAddress, int key) {
        int i = 0;
        int address = hashedAddress;
        while (table.size() > address && table.get(address).mark == 1 && table.get(address).reg.key != key) {
            i++;
            address = (hashedAddress + i) % m;
        }
        return address;
    }

    public void insert(int key, E value) {
        int hashedAddress = functionHash(key);
        int address = linearProbing(hashedAddress, key);
        table.add(address, new Element(1, new Register<>(key, value)));
    }

    public E search(int key) {
        int hashedAddress = functionHash(key);
        int address = linearProbing(hashedAddress, key);
        if (table.size() > address && table.get(address).mark == 1 && table.get(address).reg.key == key) {
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