package com.lzl.myEverything.core.search.impl;

import com.lzl.myEverything.core.mudel.Thing;
import com.lzl.myEverything.core.search.ThingSearch;

import java.util.List;

public class ThingSearchImpl implements ThingSearch {
    @Override
    public List<Thing> search() {
        // TODO 此处需要依赖数据库检索，为了更好的分层，此处不要直接把数据源拿来
        return null;
    }
}
