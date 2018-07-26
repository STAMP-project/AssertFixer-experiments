package ru.job4j.departaments;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sort {

    private ArrayList<Character> departaments = new ArrayList<Character>();

    public ArrayList<String> sor(String[] units) {
        TreeSet<String> sorted = new TreeSet<String>();
        for (int i = 0; i < units.length; i++) {
            char[] sort = new char[units[i].toCharArray().length];
            for (int j = 0; j < units[i].toCharArray().length; j++) {
                if (units[i].toCharArray()[j] == '\\') {
                    sort[j] = '\\';
                    sorted.add(String.valueOf(sort, 0, j));
                } else if (j == units[i].toCharArray().length - 1) {
                    sort[j] = units[i].toCharArray()[j];
                    sorted.add(String.valueOf(sort, 0, j + 1));
                } else {
                    sort[j] = units[i].toCharArray()[j];
                }
            }
        }
        return new ArrayList<String>(sorted);
    }

    public ArrayList<String> sortInDicreasingOrder(String[] units) {
        ArrayList<String> unit = new ArrayList<String>(sor(units));
        TreeSet<Integer> categ = new TreeSet<Integer>();
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < unit.size(); i++) {
            int s = unit.get(i).length();
            categ.add(s);
        }
        ArrayList<Integer> category = new ArrayList<Integer>(categ);
        int cat = 0;

        Map<Integer, Integer> lines = new HashMap<Integer, Integer>();           // ключ l, храниться индекс категории
        int key = category.get(cat);                                             // текущая категория
        String empty = "";                                                       // пустая ячейка

        for (int l = unit.size() - 1; l >= -1; l--) {                            // проверяем весь массив начиная с конца

            if (l == -1) {                                                       // конец сортировки
                break;                                                           // выход из цикла
            } else if (lines.containsKey(l)) {                                   // если линия существует
                if (key != category.get(lines.get(l))) {                         // если категория не равна текущей
                    key = category.get(lines.get(l));                            // извлекаем индекс категорию пересекаемого подразделения
                    lines.remove(l);                                             // удаляем отсечку
                    if (cat > 0) {                                               // если категория не минимальная
                        cat--;                                                   // уменьшаем категорию
                    }
                    l = unit.size();                                             // проверяем заново
                } else {                                                         // если категория та же
                    lines.remove(l);                                             // удаляем линию
                }
            } else if (unit.get(l).length() == key) {                            // если длина подразделения равна категории
                result.add(unit.get(l));                                         // добавляем элемент в новый массив
                unit.set(l, empty);                                              // меняем на пустой массив
                lines.put(l, cat);                                               // добавляем отсечку
                if (cat < category.size() - 1) {                                 // если категория не максимальная
                    cat++;                                                       // увеличиваем категорию
                    key = category.get(cat);                                     // присваиваем новую категорию
                }
                l = unit.size();                                                 // проверяем снова
            }
        }
        return result;
    }
}
        /*
        Массив с массивами по категориям вложенности в порядке по возрастанию
        ArrayList<ArrayList<String>> test4 = new ArrayList<ArrayList<String>>();
        int x = 0;
        for (int i = 0; i < unit.size() - 1; i++) {
            if (i == unit.size() - 2) {
                if (unit.get(i).length() != unit.get(i + 1).length()) {
                    test4.add(new ArrayList<>());
                    test4.get(x).add(unit.get(i));
                    test4.add(new ArrayList<>());
                    test4.get(x + 1).add(unit.get(i + 1));
                } else if (unit.get(i).length() == unit.get(i + 1).length()) {
                    test4.add(new ArrayList<>());
                    test4.get(x).add(unit.get(i));
                    test4.get(x).add(unit.get(i + 1));
                }
                break;
            } else if (unit.get(i).length() != unit.get(i + 1).length()) {
                test4.add(new ArrayList<>());
                test4.get(x).add(unit.get(i));
                x++;
            } else if (unit.get(i).length() == unit.get(i + 1).length()) {
                test4.add(new ArrayList<>());
                test4.get(x).add(unit.get(i));
            }
        }
        */
        /*
        Извлечение номеров подразделений

        ArrayList<String> pus = new ArrayList<>();
        ArrayList<ArrayList<Integer>> group = new ArrayList<ArrayList<Integer>>();

        Pattern p = Pattern.compile("[0-9]");
        int x = 0;
        for (int i = 0; i < unit.size(); i++) {
            int y = 0;
            for (int j = 0; j < unit.get(i).length(); j++) {
                Matcher m = p.matcher(Character.toString(unit.get(i).toCharArray()[j]));
                if (m.matches()) {
                    group.add(new ArrayList<>());
                    group.get(x).add(y, Integer.parseInt(Character.toString(unit.get(i).toCharArray()[j])));
                    y++;
                }
            }
            x++;
        }
        */