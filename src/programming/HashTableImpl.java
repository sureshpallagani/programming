package programming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class HashTableImpl {
	
	List<KeyValuePair> kvpList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> sortedKvpList = new ArrayList<KeyValuePair>();
	List<Object> values = new ArrayList<Object>();
	List<Object> keys = new ArrayList<Object>();
	int size = 0;
	
	public HashTableImpl() {
		clearMap();
	}

	public void clear() {
		clearMap();
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean remove(Object key) {
		if (key == null) {
			throw new NullPointerException("Key is null");
		}
		Iterator<KeyValuePair> kvpIterator = kvpList.iterator();
		while (kvpIterator.hasNext()) {
			KeyValuePair kvp = kvpIterator.next();
			if (kvp.getKey().equals(key)) {
				kvpIterator.remove();
				size--;
				keys.remove(key);
				values.remove(kvp.getValue());
				return true;
			}
		}
		return false;
	}
	
	public boolean put(Object key, Object value) {
		if (key == null || value == null) {
			throw new NullPointerException("Key/Value is null");
		}
		return kvpList.add(new KeyValuePair(key, value));
	}
	
	public Object get(Object key) {
		return getFromList(key).getValue();
	}
	
	public Collection<Object> values() {
		return values;
	}
	
	public Collection<Object> keys() {
		return keys;
	}
	
	private KeyValuePair getFromList(Object key) {
		if (key == null) {
			return null;
		}
		for (KeyValuePair keyValuePair : kvpList) {
			if (keyValuePair.getKey().equals(key)) {
				return keyValuePair;
			}
		}
		return null;
	}
	
	private void clearMap() {
		kvpList.clear();
		sortedKvpList.clear();
		values.clear();
		keys.clear();
	}

	private class KeyValuePair {
		private Object key;
		private Object value;

		public KeyValuePair(Object key, Object value) {
			this.key = key;
			keys.add(key);
			this.value = value;
			values.add(value);
			size++;
		}
		public Object getKey() {
			return key;
		}
		public Object getValue() {
			return value;
		}
	}
}
