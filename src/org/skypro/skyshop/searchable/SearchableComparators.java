package org.skypro.skyshop.search;

import org.skypro.skyshop.searchable.Searchable;
import java.util.Comparator;

public class SearchableComparators {
    public static final Comparator<Searchable> SEARCHABLE_COMPARATOR = (s1, s2) -> {
        int cmp = Integer.compare(s2.getSearchTerm().length(), s1.getSearchTerm().length());
        return cmp != 0 ? cmp : s1.getSearchTerm().compareTo(s2.getSearchTerm());
    };
}