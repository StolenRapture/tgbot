package org.yourbro.cache;

import org.yourbro.Entity;

public abstract class CacheRegion<T extends Entity> {
    public abstract T cache(T t);

}
