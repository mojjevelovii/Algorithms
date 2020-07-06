package ru.shumilova.algorithms;

public class Main {
    public static void main(String[] args) {
        RelatedList rl = new RelatedList();
        Cat cat2 = new Cat(3, "cat2");
        rl.push(new Cat(2, "cat1"));
        rl.push(cat2);
        rl.push(new Cat(4, "cat3"));
        rl.push(new Cat(5, "cat4"));
        rl.push(new Cat(6, "cat5"));
        System.out.println(rl);
        System.out.println(rl.pop());
        System.out.println(rl);
        System.out.println(rl.delete(cat2));
        System.out.println(rl);

        RelatedList.RelatedListIterator iterator = rl.getIterator();
        System.out.println("___----ITERATOR----___");
        iterator.next();
        System.out.println(iterator.next());
        System.out.println(iterator.previous());
        iterator.deleteCurrent();
        System.out.println(rl);
        iterator.reset();
        iterator.insertBefore(new Cat(12, "catBefore"));
        System.out.println(rl);
        iterator.insertAfter(new Cat(21, "catAfter"));
        System.out.println(rl);

    }

    //reset(); итератор перемещает себя в начало списка
    //next(); перемещение итератора к следующему элементу с возвратом текущего
    //getCurrent(); вернуть текущий элемент
    //hasNext(); проверка: есть ли следующий элемент
    //atEnd(); проверка: находится ли итератор в конце списка
    //insertAfter(); добавить после текущего элемента
    //*insertBefore(); добавить перед текущим элементом
    //deleteCurrent(); удалить текущий элемент

    //1. Реализовать класс итератора для двусвязного списка.
    //2. Реализовать двусвязный список

}