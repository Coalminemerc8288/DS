package com.pbhatna.systemdesign;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 535. Encode and Decode TinyURL
 *
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
 * and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * Design the encode and decode methods for the TinyURL service.
 * There is no restriction on how your encode/decode algorithm should work.
 *
 *
 * You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 *
 *
 */
public class CodecUsingRandomFunction {
    Map<Integer, String> map = new HashMap<Integer,String>();
    Random r = new Random();
    int key = r.nextInt(1000);

    public String encode(String longUrl) {
        while(map.containsKey(key)) {
            key = r.nextInt(1000);
        }
        map.put(key, longUrl+key);
        return "http://tinyurl.com/"+ key;
    }

    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/","")));
    }
}
