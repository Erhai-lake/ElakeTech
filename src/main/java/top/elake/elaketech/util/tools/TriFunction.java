package top.elake.elaketech.util.tools;

/**
 * @author ElakeStudio
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    /**
     * 函数
     *
     * @param t tier
     * @param u properties
     * @param v craftingDamage
     * @return item
     */
    R apply(T t, U u, V v);
}