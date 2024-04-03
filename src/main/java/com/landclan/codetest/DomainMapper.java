package com.landclan.codetest;

public interface DomainMapper<A, B> {

    public A convertFromSourceToTarget(B source);

    public B convertFromTargetToSource(A target);

}
