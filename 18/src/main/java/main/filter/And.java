package main.filter;

import main.Student;

import java.util.ArrayList;
import java.util.List;

public class And implements Filter {
    private List<Filter> filters;

    public And() {
        filters = new ArrayList<>();
    }

    public void add(Filter f) {
        filters.add(f);
    }

    public int size() {
        return filters.size();
    }

    @Override
    public boolean filter(Student st) {
        for (Filter f : filters) {
            if (!f.filter(st)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toSQL() {
        StringBuilder s = new StringBuilder();
        boolean first = true;
        for (Filter f : filters) {
            if (!first) {
                s.append(" AND ");
            } else {
                first = false;
            }
            s.append(f.toSQL());
        }
        return s.toString();
    }
}
