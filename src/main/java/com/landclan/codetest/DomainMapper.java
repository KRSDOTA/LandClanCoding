package com.landclan.codetest;

import java.util.List;

/**
 * Contract specifying conversion between some source type (A) and a target Type (B)
 * And back again
 *
 * @param <A> Source
 * @param <B> Target
 */
public interface DomainMapper<A, B> {

    B convertFromSourceToTarget(A source);

    List<B> convertFromSourceToTarget(List<A> sources);

    A convertFromTargetToSource(B target);

    List<A> convertFromTargetToSource(List<B> targets);

}
