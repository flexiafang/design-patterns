package iterator.transition;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author hustffx
 * @Date 2020/5/6 23:30
 */
public class DinerMenuIterator implements Iterator<MenuItem> {
    private final MenuItem[] items;
    private int position;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        MenuItem menuItem = items[position];
        position++;
        return menuItem;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can't remove an item until you've done at least one next()");
        }
        if (items[position - 1] != null) {
            if (items.length - position > 0) {
                System.arraycopy(items, position, items, position - 1, items.length - position);
            }
            items[items.length - 1] = null;
        }
    }
}
