package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *     Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
 */
public class ReverseIterator<T> implements Iterator<T>, Iterable<T> {

    private final List<T> list;
    private int index;

    public ReverseIterator(List<T> list) {
        this.list = list;
        this.index = list.size() - 1;
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public T next() {
        if(!this.hasNext())
        {
            throw new NoSuchElementException();
        }
        int ret = index;
        index--;
        return list.get(ret);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Первый");
        words.add("Второй");
        words.add("Третий");
        words.add("Четрвертый");
        ReverseIterator<String> iterator = new ReverseIterator<>(words);
        for (String s : iterator) System.out.println(s);
    }

}
