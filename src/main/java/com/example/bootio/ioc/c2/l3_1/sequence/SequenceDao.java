package com.example.bootio.ioc.c2.l3_1.sequence;

public interface SequenceDao {
    public Sequence getSequence(String sequenceId);
    public int getNextValue(String sequenceId);
}
