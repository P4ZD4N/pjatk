/**
 *
 *  @author Chudy Wiktor S30359
 *
 */

package zad1;


public interface Mapper<T, U> { // Uwaga: interfejs musi być sparametrtyzowany

    U map(T t);
}
