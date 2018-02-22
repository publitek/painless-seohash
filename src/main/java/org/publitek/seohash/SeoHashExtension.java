package org.publitek.seohash;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.painless.spi.PainlessExtension;
import org.elasticsearch.painless.spi.Whitelist;
import org.elasticsearch.painless.spi.WhitelistLoader;
import org.elasticsearch.script.ScriptContext;
import org.elasticsearch.script.SearchScript;


public class SeoHashExtension implements PainlessExtension {

    private static final Whitelist WHITELIST =
        WhitelistLoader.loadFromResourceFiles(SeoHashExtension.class, "seohash_whitelist.txt");

    @Override
    public Map<ScriptContext<?>, List<Whitelist>> getContextWhitelists() {
        Map<ScriptContext<?>, List<Whitelist>> map = new HashMap<ScriptContext<?>, List<Whitelist>>();
        map.put(SearchScript.CONTEXT, Collections.singletonList(WHITELIST));
        map.put(SearchScript.AGGS_CONTEXT, Collections.singletonList(WHITELIST));
        return map;
    }
}
