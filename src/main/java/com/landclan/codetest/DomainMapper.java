package com.landclan.codetest;

import java.util.List;

/**
 * Contract specifying conversion between some Target (B) and a source (B)
 * And back again
 *
 * @param <A> Target
 * @param <B> Source
 */
public interface DomainMapper<A, B> {

    A convertFromSourceToTarget(B source);

    List<A> convertFromSourceToTarget(List<B> sources);

    B convertFromTargetToSource(A target);

    List<B> convertFromTargetToSource(List<A> targets);

}
