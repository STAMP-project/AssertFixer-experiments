package ru.job4j.cash;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
/*

. Необходимо сделать кеш для хранение моделей. в кеше должны быть методы
add(Base model), update(Base model) delete(Base model),

2. Для хранения данных в кеше нужно использовать ConcurrentHashMap<Integer, Base>.

В качестве ключа используйте int id. в качестве значения Base модель

3. В кеше должна быть возможность проверять актуальность данных. Для этого в модели данных должно быть после int version.
Это после должно увеличиваться на единицу каждый раз, когда произвели изменения данных в модели.
Например. Два пользователя прочитали данные task_1
первый пользователь изменил поле имя и второй сделал тоже самое. нужно перед обновлением данных проверить.
что текущий пользователь не затер данные другого пользователя. если данные затерты то выбросить OptimisticException
- такая реализация достигается за счет введение в модель поля version.
Перед обновлением данных необходимо проверять текущую версию и ту что обновляем и увеличивать на единицу каждый раз,
когда произошло обновление. Если версии не равны -  кидать исключение.

Исключение - OptimisticException нужно сделать самостоятельно.

public class OptimisticException extends RuntimeException {
}

Исключение должно быть RuntimeException, так как обработчик для BiFunction не может кидать исключение.

Использовать метод
https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html#computeIfPresent-K-java.util.function.BiFunction-

Пример.

Нить 1 изменила объект 1, тогда version должно стать 1.
Нить 2 в это же время изменила объект 1, тут тоже самое version станет 1.

Объекты 1 - создаются в разной области памяти. По сути эти два разных объекта с одинаковыми полями.

Когда нить 1 будет обновлять данные, обновление пройдет успешно. потому что данные в кеше будут на единицу отличаться.

С другой стороны нить 2 выкинет исключение. потому, что версия в кеше не будет соответствовать текущей версии.
 */

public class UnblockingCash {
    private final ConcurrentHashMap<Integer, Base> cash = new ConcurrentHashMap<Integer, Base>();

    public void add(Base base) {
        cash.putIfAbsent(base.getId(), base);
    }

    public boolean delete(Base base) {
        return cash.remove(base.getId(), base);
    }

    public void update(Base base) {

        cash.computeIfPresent(base.getId(), new BiFunction<Integer, Base, Base>() {
            @Override
            public Base apply(Integer integer, Base oldBase) {
                if (oldBase.getVersion() + 1 == base.getVersion()) {
                    return base;
                }
                throw new OptimisticException("Incorrect version");
            }
        });

    }
}
