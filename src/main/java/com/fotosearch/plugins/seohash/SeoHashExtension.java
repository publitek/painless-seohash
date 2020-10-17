/*
 * Copyright [2018] [Ben Youngblut]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.fotosearch.plugins.seohash;

import org.elasticsearch.painless.spi.PainlessExtension;
import org.elasticsearch.painless.spi.Whitelist;
import org.elasticsearch.painless.spi.WhitelistLoader;
import org.elasticsearch.script.ScriptContext;
import org.elasticsearch.script.FieldScript;
import org.elasticsearch.script.AggregationScript;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SeoHashExtension implements PainlessExtension {

    @Override
    public Map<ScriptContext<?>, List<Whitelist>> getContextWhitelists() {
        Whitelist classWhitelist = WhitelistLoader.loadFromResourceFiles(SeoHashExtension.class, "seohash_whitelist.txt");
        Map<ScriptContext<?>, List<Whitelist>> map = new HashMap<ScriptContext<?>, List<Whitelist>>();
        map.put(FieldScript.CONTEXT, Collections.singletonList(classWhitelist));
        map.put(AggregationScript.CONTEXT, Collections.singletonList(classWhitelist));
        return map;
    }
}
