package sonlmz.service.impl;

import java.util.HashMap;
import java.util.Map;

public class MyDictionaryServiceImpl implements sonlmz.service.MyDictionaryService {

    Map<String, String> wordMap;
    public MyDictionaryServiceImpl() {
        wordMap = new HashMap<String, String>();
    }
    public MyDictionaryServiceImpl(Map<String, String> wordMap) {
        this.wordMap = wordMap;
    }

    public void add(final String word, final String meaning) {
        wordMap.put(word, meaning);
    }
    public String getMeaning(final String word) {
        return wordMap.get(word);
    }
}