package context;

import java.util.Map;
import java.util.HashMap;

import enums.Context;

public class ScenContext {

	private Map<String,Object> scenContext;
	
	public ScenContext() {
		scenContext=new HashMap<>();}
	
	public void setContext(Context key, Object value) {
		scenContext.put(key.toString(),value);}
	public Object getContext(Context key) {
		return scenContext.get(key.toString());}
	public Boolean isContains(Context key) {
		return scenContext.containsKey(key.toString());}
	
}
