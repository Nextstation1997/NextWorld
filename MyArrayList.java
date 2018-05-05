/**
 * @author Jiang Meng Ze
 * 手写arraylist容器
 * @date 2018/5/4 19:07
 */
public class MyArrayList {
    private Object[] value;
    private int size;

    public int Size() {
        return size;
    }


    public MyArrayList() {
        // value = new Object[16];
        this(10);

    }

    public boolean isEmpty() {
        return size == 0;
    }


    public MyArrayList(int size) {
        if (size < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        value = new Object[size];
    }

    public void add(Object obj) {
        value[size] = obj;
        size++;
        if (size >= value.length) {
            int newCapacity = value.length * 2;
            Object[] newList = new Object[newCapacity];
            for (int i = 0; i < value.length; i++) {
                newList[i] = value[i];
            }
            value = newList;
        }
    }

    public Object get(int index) throws Exception {
        if (index < 0 || index > size - 1) {
            throw new Exception();
        }
        return value[index];
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        } else {
            for (int i = 0; i < value.length; i++) {
                if (obj == value[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

    public int LastindexOf(Object obj) {
        if (obj == null) {
            return -1;
        } else {
            for (int i =value.length-1;i>=0; i--) {
                if (obj == value[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        MyArrayList list = new MyArrayList();
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add(new Human("老王"));
        list.add(23);
        // Human h= (Human) list.get(1);
        System.out.println(list.get(3));
        System.out.println(list.Size());
    }

}
