package org.yourbro.populators;

public interface Populator<SOURCE, TARGET> {
    void populate(SOURCE source, TARGET target);
}
