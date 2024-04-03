package com.landclan.codetest;

import java.util.List;

/**
 * Contract specifying methods for converting between some source type (A) and a target Type (B)
 * And back again
 *
 * @param <A> Source type
 * @param <B> Target type
 */
public interface DomainConverter<A, B> {

    /**
     * Map field values from source to existing target object
     * @param source source object to map fields from
     * @param target target object to take values from source
     */
    void convertFromSourceToTarget(A source, B target);

    /**
     * Map field values from source to new target object
     * @param source source object
     * @return new target object with mapped fields
     */
    B convertFromSourceToTarget(A source);

    /**
     * Map field values from target object to new source object
     * @param target object to map fields from
     * @return source object with mapped fields
     */
    A convertFromTargetToSource(B target);


    /**
     * Maps input list of type B to new list containing objects of type B
     * @param targets List of type B to map
     * @return new list of type B
     */
    List<A> convertFromTargetToSource(List<B> targets);

}
