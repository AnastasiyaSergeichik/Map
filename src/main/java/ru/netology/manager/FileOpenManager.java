package ru.netology.manager;

import java.util.*;

public class FileOpenManager {
    private Map<String, String> extensionMap = new HashMap<>();

    public void register(String name, String extension) {
        extensionMap.put(name.toLowerCase(), extension);
    }

    public String remove(String name) {
        return extensionMap.remove(name.toLowerCase());
    }

    public String getName(String extension) {
        return extensionMap.get(extension.toLowerCase());
    }

    public Set<String> getAllApps() {
        Collection<String> result = extensionMap.values();
        Set<String> appSet = new HashSet<>(result);
         return appSet;
    }

    public List<String> getAllExtension() {
        Set<String> strings = extensionMap.keySet();
        List<String> list = new ArrayList<>(strings);
        MapComparator comparator = new MapComparator();
        list.sort(comparator);
        return list;

    }
}



